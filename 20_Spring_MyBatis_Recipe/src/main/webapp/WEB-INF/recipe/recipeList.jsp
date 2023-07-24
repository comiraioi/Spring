<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<script type="text/javascript">
	function insert(){
		location.href="insert.rc";
	}
</script>
    
<!-- recipeList.jsp -->
<center>
	<h2>레시피 리스트 (${pageInfo.totalCount}개)</h2>
	<form method="get">
		<select name="col">
			<option value="">전체 검색</option>
			<option value="dish">이름</option>
			<option value="nation">나라</option>
			<option value="ingredient">재료</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
	<table border="1">
		<tr>
			<td colspan="9" align="right"><input type="button" value="추가하기" onClick="insert()"></td>
		</tr>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>대륙</th>
			<th>나라</th>
			<th>재료</th>
			<th>양념</th>
			<th>칼로리</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:if test="${empty lists}">
			<tr><td colspan="9" align="center">검색 결과가 없습니다.</td></tr>
		</c:if>
		<c:if test="${not empty lists}">
			<c:forEach var="rb" items="${lists}">
				<tr>
					<td>${rb.num}</td>
					<td><a href="detail.rc?num=${rb.num}&pageNumber=${pageInfo.pageNumber}">${rb.dish}</a></td>
					<td>${rb.continent}</td>
					<td>${rb.nation}</td>
					<td>${rb.ingredient}</td>
					<td>${rb.seasoning}</td>
					<td>${rb.calorie}</td>
					<td><a href="update.rc?num=${rb.num}&pageNumber=${pageInfo.pageNumber}">수정</a></td>
					<td><a href="delete.rc?num=${rb.num}&pageNumber=${pageInfo.pageNumber}">삭제</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	${pageInfo.pagingHtml}
</center>