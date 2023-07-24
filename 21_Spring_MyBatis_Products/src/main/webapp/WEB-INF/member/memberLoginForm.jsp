<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">
	function register(){
		location.href='register.mb';
	}
	
	function mlist(){ 
		location.href='list.mb';
	}
</script>

memberLoginForm.jsp<br>

<form action="login.mb" method="post">
	<h2>회원 로그인</h2>
	<table border="1" height="150px">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" name="password"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인">
				<input type="reset" value="취소">
				<input type="button" value="회원가입" onClick="register()">
				<input type="button" value="회원목록" onClick="mlist()">
			</td>
		</tr>
	</table>
</form>