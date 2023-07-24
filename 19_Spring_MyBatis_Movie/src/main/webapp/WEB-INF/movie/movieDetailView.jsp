<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- movieDetailView -->

<center>
	<h2>영화 상세보기</h2>
	<table border="1">
		<tr>
			<th>번호</th>
			<td>${mb.num}</td>
		</tr>
		<tr>
			<th>영화 제목</th>
			<td>${mb.title}</td>
		</tr>
		<tr>
			<th>대륙</th>
			<td>${mb.continent}</td>
		</tr>
		<tr>
			<th>제작 국가</th>
			<td>${mb.nation}</td>
		</tr>
		<tr>
			<th>등급</th>
			<td>${mb.grade}</td>
		</tr>
		<tr>
			<th>배우</th>
			<td>${mb.actor}</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a href="list.mv?pageNumber=${pageNumber}">영화 리스트</a>
				<a href="update.mv?num=${mb.num}&pageNumber=${pageNumber}">수정 폼</a>
			</td>
		</tr>
	</table>
</center>