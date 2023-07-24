<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<style type="text/css">
	.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
	}
</style>

memberUpdateForm.jsp<br>

<%
	String[] hobby = {"마라톤", "영화감상", "게임", "공부"};
%>

<center>
<h2>회원 수정</h2>
<form:form commandName="mb" action="update.mb" method="post">
	<input type="hidden" name="id" value="${mb.id}">
	<input type="hidden" name="pageNumber" value="${pageNumber}">
	<table border="1">
		<tr>
			<th>아이디</th>
			<td>${mb.id}</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="text" name="password" value="${mb.password}">
				<form:errors cssClass="err" path="password"/>
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
				<input type="text" name="name" value="${mb.name}">
				<form:errors cssClass="err" path="name"/>
			</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<input type="radio" name="gender" value="남자" <c:if test="${mb.gender == '남자'}">checked</c:if>>남자
				<input type="radio" name="gender" value="여자" <c:if test="${mb.gender == '여자'}">checked</c:if>>여자
				<form:errors cssClass="err" path="gender"/>
			</td>
		</tr>
		<tr>
			<th>취미</th>
			<td>
				<c:forEach var="hobby" items="<%=hobby%>">
					<input type="checkbox" name="hobby" value="${hobby}" <c:if test="${mb.hobby.contains(hobby)}">checked</c:if>>${hobby}
				</c:forEach>
				<form:errors cssClass="err" path="hobby"/>
			</td>
		</tr>
		<tr>
			<th>주소1</th>
			<td>
				<input type="text" name="address1" value="${mb.address1}">
				<form:errors cssClass="err" path="address1"/>
			</td>
		</tr>
		<tr>
			<th>주소2</th>
			<td>
				<input type="text" name="address2" value="${mb.address2}">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="수정하기"></td>
		</tr>
	</table>
</form:form>
</center>
