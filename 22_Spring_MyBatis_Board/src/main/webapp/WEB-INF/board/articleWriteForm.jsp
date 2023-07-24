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
	td:first-child{
		width: 100px;
		text-align: center;
		background-color: #b0e0e6;
	}
	tr:first-child td:first-child{
		text-align: right;
	}
	
	.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
	}
</style>

articleWriteForm.jsp<br>


<b>글쓰기</b>
<form action="write.bd" method="post">
<table border="1">
	<tr>
		<td colspan="2"><a href="list.bd">글목록</a></td>
	</tr>
	<tr>
		<td>이름</td>
		<td>
			<input type="text" name="writer" value="${article.writer}">
		</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>
			<input type="text" name="subject" style="width: 300" value="${article.subject}">
		</td>
	</tr>
	<tr>
		<td>email</td>
		<td>
			<input type="text" name="email" style="width: 300" value="${article.email}">
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			<textarea name="content" rows="15" cols="85">${article.content}</textarea>
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" name="passwd">
		</td>
	</tr>
	<tr height="30">
		<td colspan="2" align="center">
			<input type="submit" value="글쓰기">
			<input type="reset" value="다시작성">
			<input type="button" value="목록보기" onClick="location.href='list.bd'">
		</td>
	</tr>
</table>
</form>
