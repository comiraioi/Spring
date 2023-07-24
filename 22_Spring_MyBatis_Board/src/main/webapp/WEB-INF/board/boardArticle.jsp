<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/style.css">
<style>
	body{
		text-align: center;
		background-color: #e0ffff;
	}
	table{
		border: 1px solid;
		margin: auto;
		width: 600px;
		background-color: white;
	}
	table, tr, td{
		border: 1px solid;
		border-collapse:collapse;
	}
	td:nth-child(odd){
		text-align: center;
		background-color: #b0e0e6;
	}
</style>

boardArticle.jsp<br>

<b>글내용 보기</b>
<form action="update.bd" method="post" >
<table border="1">
	<tr>
		<td>글 번호</td>
		<td>${article.num}</td>
		<td>조회수</td>
		<td>${article.readcount}</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${article.writer}</td>
		<td>작성일</td>
		<td>${article.regdate}</td>
	</tr>
	<tr>
		<td>글 제목</td>
		<td colspan="3">${article.subject}</td>
	</tr>
	<tr>
		<td>글 내용</td>
		<td colspan="3">${article.content}</td>
	</tr>
	<tr>
		<td colspan="4" style="text-align:right">
			<input type="button" value="수정" onClick="location.href='update.bd?num=${article.num}&pageNumber=${pageNumber}'">
			<input type="button" value="삭제" onClick="location.href='delete.bd?num=${article.num}&pageNumber=${pageNumber}'">
			<input type="button" value="답글쓰기" onClick="location.href='reply.bd?ref=${article.ref}&restep=${article.restep}&relevel=${article.relevel}&pageNumber=${pageNumber}'">
			<input type="button" value="글 목록" onClick="location.href='list.bd?pageNumber=${pageNumber}'">
		</td>
	</tr>
</table>
</form>