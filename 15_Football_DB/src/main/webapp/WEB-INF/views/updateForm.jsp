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

update 요청(GET) => updateForm.jsp<br><br>

<%
	String[] winArr = {"한국","미국","독일","스페인"};
	String[] round16Arr = {"한국","독일","브라질","잉글랜드","이탈리아","네덜란드","이란"};
%>

번호: ${fb.num}<br>
<form:form commandName="fb" action="update" method="post">
	<input type="hidden" name="num" value="${fb.num}">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="id" value="${fb.id}">
      			<form:errors cssClass="err" path="id"/>
			</td>
		</tr>
		<tr>
			<td>비번</td>
			<td>
				<input type="text" name="pw" value="${fb.pw}">
      			<form:errors cssClass="err" path="pw"/>
			</td>
		</tr>
		<tr>
			<td>우승 예상 국가</td>
			<td>
				<c:forEach var="i" items="<%=winArr%>">
					<input type="radio" name="win" value="${i}" <c:if test="${fb.win eq i}">checked</c:if>>${i}
				</c:forEach>
				<form:errors cssClass="err" path="win"/>
			</td>
		</tr>
		<tr>
			<td>16강 예상 국가</td>
			<td>
				<c:forEach var="i" items="<%=round16Arr%>">
					<input type="checkbox" name="round16" value="${i}" <c:if test="${fb.round16.contains(i)}">checked</c:if>>${i}
				</c:forEach>
      			<form:errors cssClass="err" path="round16"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정">
			</td>
		</tr>
	</table>
</form:form>