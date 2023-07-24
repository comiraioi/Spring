<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
	.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
	}
</style>
    
update 요청(GET) => updateForm.jsp <br>

<%
	String[] prodArr = {"식품","의류","도서","가구"};
	String[] timeArr = {"9시~11시","11시~1시","1시~5시","5시~9시"};
%>

<h2> 이마트 상품 구매 내역 </h2>
번호: ${num}<br>
<form:form commandName="mb" name="myform" method="post" action="update">
<input type="hidden" name="num" value="${num}">
<span>아이디 :</span> <INPUT TYPE="text" NAME="id" value="${mb.id}">
<form:errors cssClass="err" path="id"/> <br>
<span>비번 :</span> <INPUT TYPE="text" NAME="pw" value="${mb.pw}">
<form:errors cssClass="err" path="pw"/> <br>
<p> 
 
<span>구매상품:</span>
	<c:forEach var="p" items="<%=prodArr%>">
		<input type="checkbox" name="product" value="${p}" <c:if test="${mb.product.contains(p)}">checked</c:if>>${p}
	</c:forEach>
<form:errors cssClass="err" path="product"/>
<p>

<span>배송시간 :</span> 
 	<SELECT NAME="time">
 		<OPTION VALUE="">선택</OPTION>
 		<c:forEach var="t" items="<%=timeArr%>">
			<OPTION VALUE="${t}" <c:if test="${mb.time eq t}">selected</c:if>>${t}</OPTION>
		</c:forEach>
	</SELECT>
<form:errors cssClass="err" path="time"/>
<p>

<span>결제방법:</span>
카드 <INPUT TYPE="radio" NAME="approve" VALUE="카드" <c:if test="${mb.approve eq '카드'}">checked</c:if>>
핸드폰 <INPUT TYPE="radio" NAME="approve" VALUE="핸드폰" <c:if test="${mb.approve eq '핸드폰'}">checked</c:if>>
<form:errors cssClass="err" path="approve"/>
<p>
<span>결제 동의합니다. </span>  
<INPUT TYPE="checkbox" NAME="agree" id="agree" <c:if test="${mb.agree != null}">checked</c:if>> 
<form:errors cssClass="err" path="agree"/>
<p>

<INPUT TYPE="submit" value="보내기" onClick="return check()">
</form:form>



