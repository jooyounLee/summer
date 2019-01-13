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
</head>
<body>

	<div id="grid"></div>
	<button name="goWrite">WRITE</button>
	
<script src="<c:url value="/resources/js/article/list.js"/>"></script>
<script type="text/javascript" src="https://uicdn.toast.com/tui.pagination/v3.2.0/tui-pagination.js"></script>
<script src="<c:url value="/resources/tui/tui-grid.js"/>"></script>
</body>

</html>