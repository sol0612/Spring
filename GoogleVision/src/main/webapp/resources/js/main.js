// Copyright 2015, Google, Inc.
// Licensed under the Apache License, Version 2.0 (the "License")
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

'use strict';

var CV_URL = 'https://vision.googleapis.com/v1/images:annotate?key='
		+ window.apiKey;

$(function() {
	$('#fileform').on('submit', uploadFiles);
});

/**
 * 'submit' event handler - reads the image bytes and sends it to the Cloud
 * Vision API.
 */
function uploadFiles(event) {
	event.preventDefault($('.results').empty()); // Prevent the default form post // 새로 업로드할때마다 result값 없애주깅 ㅎ

	// Grab the file and asynchronously convert to base64.
	var file = $('#fileform [name=files]')[0].files;
	console.log(file);
	/* var reader = new FileReader(); */
	[].forEach.call(file, function(file) {
		var reader = new FileReader();
		reader.onloadend = processFile; // 이미지 로드가 완료되면 processFile 실행
		reader.readAsDataURL(file); // 파일의 내용을 읽어 url형식의 문자열로 저장
									// ex)data:image/jpeg;base64,~~~~ 그리곤
									// result값에 저장해줌 로드끝나면 자동실행됨?..
	});
}

/**
 * Event handler for a file's data url - extract the image data and pass it off.
 */
function processFile(event) {
	var content = event.target.result;
	console.log(content);
	sendFileToCloudVision(content.replace('data:image/jpeg;base64,', ''));
}

/**
 * Sends the given file contents to the Cloud Vision API and outputs the
 * results.
 */
function sendFileToCloudVision(content) {
	var type = $('#fileform [name=type]').val(); // 검색하려는게 뭔지 알려줌

	// Strip out the file prefix when you convert to json.
	var request = {
		requests : [ {
			image : {
				content : content
			},
			features : [ {
				type : type,
				maxResults : 200
			} ]
		} ]
	};

	$.post({
		url : CV_URL,
		data : JSON.stringify(request),
		contentType : 'application/json'
	}).fail(function(jqXHR, textStatus, errorThrown) {
		$('#results').text('ERRORS: ' + textStatus + ' ' + errorThrown);
	}).done(displayJSON);
}

/**
 * Displays the results.
 */
function displayJSON(data) {
	var contents = JSON.stringify(data, null, 4);
	if ($('.results').html() == null) {
		$('.results').html('<p>' + contents + '</p>');
	} else {
		$('.results').append('<p>' + contents + '</p>');
	}
	/* var parsedJson = JSON.parse(contents); */
	/* console.log(parsedJson); */

	if (contents.indexOf('man') != -1) { // 특정문자열이 포함되어 있으면!
		alert('사진업로드불가능');
	} else {
		alert('사진업로드가능');
	}
	
	var evt = new Event('results-displayed');
	evt.results = contents;
	document.dispatchEvent(evt);
}
