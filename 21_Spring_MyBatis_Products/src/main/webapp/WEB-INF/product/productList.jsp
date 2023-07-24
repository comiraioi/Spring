<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<script type="text/javascript">
	function insert(){
		location.href="insert.prd";
	}
</script>

<%
	//HttpSession session = new HttpSession();
	//session.getAttribute("id");
%>

productList.jsp<br><br>

<center>
	<h2>상품 리스트</h2>
	<form method="get">
		<select name="whatColumn">
			<option value="">전체 검색</option>
			<option value="name">상품명</option>
			<option value="contents">설명</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
	<table border="1" width="400px">
		<tr>
			<td colspan="6" align="right">
				<input type="button" value="추가하기" onClick="insert()">
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>상품명</th>
			<th>설명</th>
			<th>가격</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		<c:forEach var="pb" items="${prdList}">
			<tr>
				<td align="center">${pb.num}</td>
				<td><a href="detail.prd?num=${pb.num}&pageNumber=${pageInfo.pageNumber}">${pb.name}</a></td>
				<td>${pb.contents}</td>
				<td>${pb.price}원</td>
				<td align="center"><a href="delete.prd?num=${pb.num}&pageNumber=${pageInfo.pageNumber}">삭제</a></td>
				<td align="center"><input type="button" value="수정" onClick="location.href='update.prd?num=${pb.num}&pageNumber=${pageInfo.pageNumber}'"></td>
			</tr>
		</c:forEach>
	</table>
	${pageInfo.pagingHtml}
</center>