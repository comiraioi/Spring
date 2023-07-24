<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- movieDetailView -->

<center>
	<h2>레시피 상세보기</h2>
	<table border="1">
		<tr>
			<th>번호</th>
			<td>${rb.num}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${rb.dish}</td>
		</tr>
		<tr>
			<th>대륙</th>
			<td>${rb.continent}</td>
		</tr>
		<tr>
			<th>나라</th>
			<td>${rb.nation}</td>
		</tr>
		<tr>
			<th>재료</th>
			<td>${rb.ingredient}</td>
		</tr>
		<tr>
			<th>양념</th>
			<td>${rb.seasoning}</td>
		</tr>
		<tr>
			<th>칼로리</th>
			<td>${rb.calorie}</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a href="list.rc?pageNumber=${pageNumber}">레시피 리스트</a>
				<a href="update.rc?num=${rb.num}&pageNumber=${pageNumber}">수정 폼</a>
			</td>
		</tr>
	</table>
</center>