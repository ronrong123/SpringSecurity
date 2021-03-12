<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>로그인</h2>
<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION }">
 <font color="red">
 	${SPRING_SECURITY_LAST_EXCEPTION.message }
 	<c:remove var ="SPRING_SECURITY_LAST_EXCEPTION" scope="session" />
 </font>
</c:if>
<form action="login" method="post">
<table>
<tr><td>ID</td><td><input type="text" id="id" name="id"></td></tr>
<tr><td>PASSWORD</td><td><input type="password" id="password" name="password"></td></tr>
</table>
<button>LOGIN</button>
</form>
<a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=80e923fe43e08e05e1e6c236453db46b&redirect_uri=http://localhost/bank/callback">카카오로그인</a>
</div>
</body>
</html>