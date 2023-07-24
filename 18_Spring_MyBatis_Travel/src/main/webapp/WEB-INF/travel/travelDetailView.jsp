<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<!-- travelDetailView.jsp -->

<form action="update.tv">
	<input type="hidden" name="num" value="${tb.num}">
	<input type="hidden" name="pageNumber" value="${pageNumber}">
	<table border="1">
		<tr>
			<th>번호</th>
			<td>${tb.num}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${tb.name}</td>
		</tr>
		<tr>
			<th>나이</th>
			<td>${tb.age}</td>
		</tr>
		<tr>
			<th>관심 지역</th>
			<td>${tb.area}</td>
		</tr>
		<tr>
			<th>여행 스타일</th>
			<td>${tb.style}</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>${tb.price}</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="수정하기">
				<a href="list.tv?pageNumber=${pageNumber}">목록보기</a>
			</td>
		</tr>
	</table>
</form>