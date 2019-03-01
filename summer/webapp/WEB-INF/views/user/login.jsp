<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<form name="frm" action="/summer/login" method="POST">
		<ul>
			<li>
				<label for="userID">ID</label> 
				<input id="userID" type="text" name="username" placeholder="ID" required>
			</li>
			<li>
				<label for="password">Password</label> 
				<input id="password" type="password" name="password" placeholder="PASSWORD" required>
			</li>
			<li>
				<input type="submit" value="로그인"/>
			</li>
		</ul>

		<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
	</form>
</body>
</html>