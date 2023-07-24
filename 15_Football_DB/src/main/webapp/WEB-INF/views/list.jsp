<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

list 요청 => list.jsp<br><br>

<a href="insert">추가</a>
<table border="1">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>비번</th>
		<th>우승 예상 국가</th>
		<th>16강 예상 국가</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="fb" items="${requestScope.lists}">
	<tr>
		<td>${fb.num}</td>
		<td>${fb.id}</td>
		<td>${fb.pw}</td>
		<td>${fb.win}</td>
		<td>${fb.round16}</td>
		<td><a href="update?num=${fb.num}">수정</a></td>
		<td><a href="delete?num=${fb.num}">삭제</a></td>
	</tr>
	</c:forEach>
</table>