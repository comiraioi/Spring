<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style type="text/css">
	.err{
	    font-size: 9pt;
	    color: red;
	    font-weight: bold;
    }
</style>

form 요청(GET) => bookForm.jsp<br><br>

<form:form commandName="bookBean" action="form">	<!-- form:form의 기본 method="POST" -->
	제목: <input type="text" name="title" value="${bookBean.title}"> 
		<form:errors cssClass="err" path="title"/> <br>
	저자: <input type="text" name="author" value="${bookBean.author}"> 
		<form:errors cssClass="err" path="author"/> <br>
	가격: <input type="text" name="price" value="${bookBean.price}">
		<form:errors cssClass="err" path="price"/> <br>
	출판사: <input type="text" name="publisher"  value="${bookBean.publisher}">
		<form:errors cssClass="err" path="publisher"/> <br>
	구입 서점: 
		<input type="checkbox" name="bookstore" value="교보문고" <c:if test="${bookBean.bookstore.contains('교보문고')}">checked</c:if>>교보문고
		<input type="checkbox" name="bookstore" value="알라딘" <c:if test="${fn:contains(bookBean.bookstore,'알라딘')}">checked</c:if>>알라딘
		<input type="checkbox" name="bookstore" value="yes24" <c:if test="${fn:contains(bookBean.bookstore,'yes24')}">checked</c:if>>yes24
		<input type="checkbox" name="bookstore" value="영풍문고" <c:if test="${fn:contains(bookBean.bookstore,'영풍문고')}">checked</c:if>>영풍문고
		<form:errors cssClass="err" path="bookstore"/> <br>
	배송비:
		<input type="radio" name="kind" value="유료" <c:if test="${bookBean.kind eq '유료'}">checked</c:if>>유료
		<input type="radio" name="kind" value="무료" <c:if test="${bookBean.kind == '무료'}">checked</c:if>>무료
		<form:errors cssClass="err" path="kind"/>
	<br><br>
	<input type="submit" value="전송">
</form:form>