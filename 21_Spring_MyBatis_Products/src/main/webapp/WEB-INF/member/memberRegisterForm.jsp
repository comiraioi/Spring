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

memberRegisterForm.jsp<br>

<%
	String[] hobby = {"마라톤", "영화감상", "게임", "공부"};
%>

<form:form commandName="mb" action="register.mb" method="post">
	<h2>회원 가입</h2>
	<p>
		<label>아이디</label>
		<input type="text" name="id" value="${mb.id}">
		<form:errors cssClass="err" path="id"/>
	</p>
	<p>
		<label>비밀번호</label>
		<input type="text" name="password" value="${mb.password}">
		<form:errors cssClass="err" path="password"/>
	</p>
	<p>
		<label>이름</label>
		<input type="text" name="name" value="${mb.name}">
		<form:errors cssClass="err" path="name"/>
	</p>
	<p>
		<label>성별</label>
		<input type="radio" name="gender" value="남자" <c:if test="${mb.gender == '남자'}">checked</c:if>>남자
		<input type="radio" name="gender" value="여자" <c:if test="${mb.gender == '여자'}">checked</c:if>>여자
		<form:errors cssClass="err" path="gender"/>
	</p>
	<p>
		<label>취미</label>
		<c:forEach var="hobby" items="<%=hobby%>">
			<input type="checkbox" name="hobby" value="${hobby}" <c:if test="${mb.hobby.contains(hobby)}">checked</c:if>>${hobby}
		</c:forEach>
		<form:errors cssClass="err" path="hobby"/>
	</p>
	<p>
		<label>주소1</label>
		<input type="text" name="address1">
		<form:errors cssClass="err" path="address1"/>
	</p>
	<p>
		<label>주소2</label>
		<input type="text" name="address2">
	</p>
	<p>
		<label>적립포인트</label>
		<input type="text" name="mpoint">
	</p>
	<p>
		<input type="submit" value="가입하기">
	</p>
</form:form>