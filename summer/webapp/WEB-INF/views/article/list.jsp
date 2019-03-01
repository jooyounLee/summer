<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/views/common.jsp" %>
<title>SUMMER ARTICLE</title>
<link rel="stylesheet" href="<c:url value="/resources/tui/tui-grid.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/tui/tui-pagination.css"/>" />
<style>
#view {
	display: none;
	height: auto;
	width: 50%;
	background-color: #ffffff;
	position: absolute;
	z-index: 22;
	
}
</style>
</head>
<body>
	<div class="wrap">
		<div id="view">
			<div name="title"></div>
			<div name="userName"></div>
			<div name="created"></div>
			<div name="content"></div>
		</div>
		
		<div id="grid"></div>
		<button name="goWrite">WRITE</button>
	</div>
	
	
<script src="<c:url value="/resources/js/article/list.js"/>"></script>
<script type="text/javascript" src="https://uicdn.toast.com/tui.pagination/v3.2.0/tui-pagination.js"></script>
<script src="<c:url value="/resources/tui/tui-grid.js"/>"></script>
</body>

</html>