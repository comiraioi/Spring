<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
productDetailView.jsp<br>

<center>
	<h2>상품 상세 보기</h2>
	<table border="1">
		<tr>
			<td rowspan="7">
				<img alt="없음" src="<%=request.getContextPath()%>/resources/${pb.image}" width="150">
			</td>
		</tr>
		<tr>
			<th>상품명</th>
			<td>${pb.name}</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>${pb.price}</td>
		</tr>
		<tr>
			<th>재고 수량</th>
			<td>${pb.stock}</td>
		</tr>
		<tr>
			<th>설명</th>
			<td>${pb.contents}</td>
		</tr>
		<tr>
			<th>주문하기</th>
			<td>
				<form action="add.mall" method="post">
					<input type="hidden" name="num" value="${pb.num}">
					<input type="hidden" name="pageNumber" value="${pageNumber}">
					주문수량: <input type="text" name="orderqty">
					<input type="submit" value="주문">
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<a href="list.prd?pageNumber=${pageNumber}">상품 리스트</a>
			</td>
		</tr>
	</table>
</center>