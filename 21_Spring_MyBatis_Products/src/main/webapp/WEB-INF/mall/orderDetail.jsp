<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

orderDetail.jsp<br>

<center>
	<h2>주문 상세 내역</h2>
	<table border="1" style="text-align:center">
		<tr>
			<td colspan="2">고객: ${loginInfo.name}</td>
			<td colspan="3">송장 번호: ${oid}</td>
		</tr>
		<tr>
			<td colspan="5">배송지: ${loginInfo.address1} ${loginInfo.address2}</td>
		</tr>
		<tr>
			<th>순번</th>
			<th>상품명 (상품번호)</th>
			<th>수량</th>
			<th>단가</th>
			<th>금액</th>
		</tr>
		<c:forEach var="join" items="${jlist}">
			<tr>
				<td>${join.no}</td>
				<td>${join.name} (${join.pnum})</td>
				<td>${join.qty}</td>
				<td>${join.price}</td>
				<td>${join.qty * join.price}</td>
			</tr>
		</c:forEach>
	</table>
</center>
