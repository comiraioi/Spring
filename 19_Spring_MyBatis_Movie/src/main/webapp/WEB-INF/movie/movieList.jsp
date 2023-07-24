<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<script type="text/javascript">
	function insert(){
		location.href="insert.mv";
	}
</script>
    
<!-- movieList.jsp -->
<center>
	<h2>영화 정보 리스트</h2>
	<form method="get">
		<select name="col" onChange="arrange()">
			<option value="">전체 검색</option>
			<option value="genre">장르</option>
			<option value="grade">등급</option>
			<option value="actor">배우</option>
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
			<th>제목</th>
			<th>대륙</th>
			<th>제작국가</th>
			<th>장르</th>
			<th>등급</th>
			<th>출연배우</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:if test="${empty lists}">
			<tr><td colspan="9" align="center">검색 결과가 없습니다.</td></tr>
		</c:if>
		<c:if test="${not empty lists}">
			<c:forEach var="mb" items="${lists}">
				<tr>
					<td>${mb.num}</td>
					<td><a href="detail.mv?num=${mb.num}&pageNumber=${pageInfo.pageNumber}">${mb.title}</a></td>
					<td>${mb.continent}</td>
					<td>${mb.nation}</td>
					<td>${mb.genre}</td>
					<td>${mb.grade}</td>
					<td>${mb.actor}</td>
					<td><a href="update.mv?num=${mb.num}&pageNumber=${pageInfo.pageNumber}">수정</a></td>
					<td><a href="delete.mv?num=${mb.num}&pageNumber=${pageInfo.pageNumber}">삭제</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	${pageInfo.pagingHtml}
</center>