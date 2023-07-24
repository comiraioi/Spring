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
		width: 350px;
		background-color: white;
		text-align: center;
	}
	table, tr, td{
		border: 1px solid;
		border-collapse:collapse;
	}
	tr:nth-child(odd){
		width: 100px;
		background-color: #b0e0e6;
	}
	
	.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
	}
</style>

articleDeleteForm.jsp<br>

<b>글 삭제</b>
<form action="delete.bd" method="post">
	<input type="hidden" name="num" value="${article.num}">
	<input type="hidden" name="pageNumber" value="${pageNumber}">
	<table border="1">
		<tr height="30">
			<td><b>비밀번호를 입력해주세요</b></td>
		</tr>
		<tr height="30">
			<td>비밀번호: <input type="password" name="passwd"></td>
		</tr>
		<tr height="30">
			<td>
				<input type="submit" value="글삭제">
				<input type="button" value="글목록" onClick="location.href='list.bd?pageNumber=${pageNumber}'">
			</td>
		</tr>
	</table>
</form>