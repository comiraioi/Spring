<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

updateform 요청(GET) => update_form.jsp<br><br>

번호: ${param.num}<br>
<form action="update" method="post">
	<table border="1">
		<input type="hidden" name="num" value="${pb.num}">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="${pb.id}"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${pb.name}"></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="text" name="age" value="${pb.age}"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="전송">
			</td>
		</tr>
	</table>
</form>