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

insert.ab 요청(GET) => albumInsertForm.jsp<br><br>

<form:form commandName="album" action="insert.ab" method="post">
	<p>
		<label for="title">노래 제목</label>	<!-- for: input 태그와 id로 연결 -->
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
		<input type="text" name="day" id="day" value="${album.day}">
		<form:errors cssClass="err" path="day"/>
	</p>
	<p>
		<input type="submit" value="추가하기">
	</p>
</form:form>