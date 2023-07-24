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

insert 요청(GET) => insertForm.jsp<br><br>

<form:form commandName="fDto" action="insert" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="id" value="${fDto.id}">
      			<form:errors cssClass="err" path="id"/>
			</td>
		</tr>
		<tr>
			<td>비번</td>
			<td>
				<input type="text" name="pw" value="${fDto.pw}">
      			<form:errors cssClass="err" path="pw"/>
			</td>
		</tr>
		<tr>
			<td>우승 예상 국가</td>
			<td>
				<input type="radio" name="win" value="한국" <c:if test="${fDto.win eq '한국'}">checked</c:if>>한국
				<input type="radio" name="win" value="미국" <c:if test="${fDto.win == '미국'}">checked</c:if>>미국
				<input type="radio" name="win" value="독일" <c:if test="${fDto.win == '독일'}">checked</c:if>>독일
				<input type="radio" name="win" value="스페인" <c:if test="${fDto.win == '스페인'}">checked</c:if>>스페인
				<form:errors cssClass="err" path="win"/>
			</td>
		</tr>
		<tr>
			<td>16강 예상 국가</td>
			<td>
				<input type="checkbox" name="round16" value="한국" <c:if test="${fDto.round16.contains('한국')}">checked</c:if>>한국
				<input type="checkbox" name="round16" value="독일" <c:if test="${fDto.round16.contains('독일')}">checked</c:if>>독일
				<input type="checkbox" name="round16" value="브라질" <c:if test="${fDto.round16.contains('브라질')}">checked</c:if>>브라질
				<input type="checkbox" name="round16" value="잉글랜드" <c:if test="${fDto.round16.contains('잉글랜드')}">checked</c:if>>잉글랜드
				<input type="checkbox" name="round16" value="이탈리아" <c:if test="${fDto.round16.contains('이탈리아')}">checked</c:if>>이탈리아
				<input type="checkbox" name="round16" value="네덜란드" <c:if test="${fDto.round16.contains('네덜란드')}">checked</c:if>>네덜란드
				<input type="checkbox" name="round16" value="이란" <c:if test="${fn:contains(fDto.round16,'이란')}">checked</c:if>>이란
      			<form:errors cssClass="err" path="round16"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="전송">
			</td>
		</tr>
	</table>
</form:form>