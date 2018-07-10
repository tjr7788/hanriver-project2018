<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>멤버 목록</title>
</head>
<body>
<h1>멤버 목록2</h1>
<p><a href='form.html'>새회원</a></p>
<table border='1'>
<tr>
    <th>번호</th><th>아이디</th><th>이메일</th><th>전화번호</th>
</tr>
<c:forEach items="${list}" var="member">
<tr>
    <td>${member.no}</td><td><a href='view?id=${member.id}'>${member.id}</a></td><td>${member.email}</td><td>${member.tel}</td>
</tr>
</c:forEach>
</table>
</body>
</html>