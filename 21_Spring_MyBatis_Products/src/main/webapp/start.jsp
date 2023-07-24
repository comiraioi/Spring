<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

start.jsp<br><br>

<%
	String viewLoginPage = "login.mb";

	String viewOrderPage = "order.mall";

	String viewPrdList = "list.prd";
	/* String viewPrdList = request.getContextPath()+"/list.prd"; 
		=> http://localhost:8080/ex/list.prd */
	
	String viewMemberList = "list.mb";
%>

<a href="<%=viewLoginPage%>">로그인하기</a>
<br>

<a href="<%=viewOrderPage%>">나의 주문 관리</a>
<br>

<a href="<%=viewPrdList%>">상품 목록 보기</a>
<br>

<a href="<%=viewMemberList%>">회원 목록 보기</a>

