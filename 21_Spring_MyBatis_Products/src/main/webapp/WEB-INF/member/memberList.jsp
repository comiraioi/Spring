<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<script type="text/javascript">
	function register(){
		location.href='register.mb';
	}
</script>

memberList.jsp<br><br>

<center>
	<h2>회원 리스트</h2>
	<form method="get">
		<select name="whatColumn">
			<option value="">전체 검색</option>
			<option value="name">이름</option>
			<option value="gender">성별</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
	<table border="1">
		<tr>
			<td colspan="9" align="right">
				<input type="button" value="로그인 페이지" onClick="location.href='login.mb'">
				<input type="button" value="추가하기" onClick="register()">
			</td>
		</tr>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>비밀번호</th>
			<th>성별</th>
			<th>취미</th>
			<th>주소</th>
			<th>포인트</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		<c:forEach var="mb" items="${memberList}">
			<tr>
				<td align="center">${mb.id}</td>
				<td><a href="detail.mb?id=${mb.id}&pageNumber=${pageInfo.pageNumber}">${mb.name}</a></td>
				<td>${mb.password}</td>
				<td>${mb.gender}</td>
				<td>${mb.hobby}</td>
				<td>${mb.address1} ${mb.address2}</td>
				<td>${mb.mpoint}</td>
				<td align="center"><a href="delete.mb?id=${mb.id}&pageNumber=${pageInfo.pageNumber}">삭제</a></td>
				<td align="center"><input type="button" value="수정" onClick="location.href='update.mb?id=${mb.id}&pageNumber=${pageInfo.pageNumber}'"></td>
			</tr>
		</c:forEach>
	</table>
	${pageInfo.pagingHtml}
</center>