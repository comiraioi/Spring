<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
person/form 요청 => form.jsp<br><br>

<!-- person이 중복이므로 action에 작성하지 않음 (person/input3 X) -->
<!-- <form action="input3" method="get"> 또는 -->
<form action="<%=request.getContextPath()%>/person/input3" method="get">
	<table border="1">
		<tr>
			<td>ID</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>PASSWD</td>
			<td><input type="text" name="passwd"></td>
		</tr>
		<tr>
			<td>ADDR</td>
			<td><input type="text" name="addr"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="전송">
			</td>
		</tr>
	</table>
</form>