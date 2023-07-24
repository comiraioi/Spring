<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

detail.ab 요청(GET) => albumDetailView.jsp<br><br>

<form action="update.ab">
	<input type="hidden" name="num" value="${album.num}">
	<table border="1">
		<tr>
			<td>번호</td>
			<td>${album.num}</td>
		</tr>
		<tr>
			<td>노래 제목</td>
			<td>${album.title}</td>
		</tr>
		<tr>
			<td>가수명</td>
			<td>${album.singer}</td>
		</tr>
		<tr>
			<td>가격</td>
			<td>${album.price}</td>
		</tr>
		<tr>
			<td>발매일</td>
			<td>
				<fmt:parseDate var="fmtday" value="${album.day}" pattern="yyyy-MM-dd"/>
				<fmt:formatDate var="day" value="${fmtday}" pattern="yyyy-MM-dd"/>
				${day}
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="수정하기"></td>
		</tr>
	</table>
</form>