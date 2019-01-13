<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/views/common.jsp" %>
<title>SUMMER ARTICLE WRITE</title>
<link rel="stylesheet" href="<c:url value="/resources/tui/tui-editor/dist/tui-editor.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/tui/tui-editor/dist/tui-editor-contents.css"/>" />
</head>

<body>
	<div>
		<div style="float:left;">Title </div>
		<div>
			<input type="text" name="title">
		</div>
		<div style="float:left;">Name </div>
		<div>
			<input type="text" name="userName">
		</div>
		<div style="float:left;">Password </div>
		<div>
			<input type="password" name="password">
		</div>
	</div>
	<div id="editSection"></div>
	<input type="button" name="btnSave" value="SAVE">
<script src="<c:url value="/resources/tui/tui-editor/dist/tui-editor-Editor.js"/>"></script>
<script src="<c:url value="/resources/js/article/write.js"/>"></script>
</body>
</html>