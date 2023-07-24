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

update.ab 요청(GET) => albumUpdateForm.jsp<br><br>

번호: ${album.num} <br>
<form:form commandName="album" action="update.ab" method="post">
	<input type="hidden" name="num" value="${album.num}">
	<p>
		<label for="title">노래 제목</label>
		<input type="text" name="title" id="title" value="${album.title}">
		<form:errors cssClass="err" path="title"/>
	</p>
	<p>
		<label for="singer">가수명</label>
		<input type="text" name="singer" id="singer" value="${album.singer}">
		<form:errors cssClass="err" path="singer"/>
	</p>
	<p>
		<label for="price">가격</label>
		<input type="text" name="price" id="price" value="${album.price}">
		<form:errors cssClass="err" path="price"/>
	</p>
	<p>
		<label for="day">발매일</label>
		<fmt:parseDate var="fmtday" value="${album.day}" pattern="yyyy-MM-dd"/>
		<fmt:formatDate var="day" value="${fmtday}" pattern="yyyy-MM-dd"/>
		<input type="text" name="day" id="day" value="${day}">
		<form:errors cssClass="err" path="day"/>
	</p>
	<p>
		<input type="submit" value="수정하기">
	</p>
</form:form>