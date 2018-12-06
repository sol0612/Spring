<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Copyright 2015, Google, Inc.
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License. -->
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Cloud Vision Demo</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/key.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</head>
<body>
	<form id="fileform" action="">
		<select name="type">
			<option value="LANDMARK_DETECTION">LANDMARK_DETECTION</option>
			<option value="TYPE_UNSPECIFIED">TYPE_UNSPECIFIED</option>
			<option value="FACE_DETECTION">FACE_DETECTION</option>
			<option value="LOGO_DETECTION">LOGO_DETECTION</option>
			<option value="LABEL_DETECTION" selected>LABEL_DETECTION</option>
			<option value="TEXT_DETECTION">TEXT_DETECTION</option>
			<option value="SAFE_SEARCH_DETECTION">SAFE_SEARCH_DETECTION</option>
			<option value="IMAGE_PROPERTIES">IMAGE_PROPERTIES</option>
		</select><br /> 
		<!-- 파일다중업로드가능 -->
		<input id="files" type="file" name="files" multiple>
		<output id="list"></output><br />
		<br /> <input type="submit" name="submit" value="Submit">
	</form>

	<code style="white-space: pre" id="results" class="results"></code>
</body>
</html>