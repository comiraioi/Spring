<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<%
	MemberBean mb = (MemberBean)session.getAttribute("loginInfo");
%>

cartList.jsp<br><br>

<center>
	<h2>장바구니 목록보기</h2>
	<form action="calculate.mall">
		<table border="1">
			<tr>
				<td colspan="5" align="center">
					주문자 정보: <%=mb.getName()%> (<%=mb.getId()%>)
				</td>
			</tr>
			<tr>
				<th>상품 번호</th>
				<th>상품명</th>
				<th>주문 수량</th>
				<th>단가</th>
				<th>금액</th>
			</tr>
			<c:forEach var="shop" items="${slist}">
				<tr>
				
					<td>${shop.pnum}</td>
					<td>${shop.pname}</td>
					<td>${shop.qty}</td>
					<td>${shop.price}</td>
					<td>${shop.amount}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3" align="center">
					<a href="calculate.mall">결제하기</a>
					<a href="list.prd">추가주문</a>
				</td>
				<td colspan="2" align="center">
					총 금액: ${totalAmount}
				</td>
			</tr>
		</table>
	</form>
</center>

