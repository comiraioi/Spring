<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<script type="text/javascript">
	function insert(){
		location.href="insert.tv";
	}
	
	function goUpdate(num, pageNumber){
		location.href="update.tv?num="+num+"&pageNumber="+pageNumber;
	}
</script>

<!-- travelList.jsp -->
<h2 align="center">여행 리스트 (레코드 수: ${pageInfo.totalCount})</h2>
<center>
	<form action="" method="get">
		<select name="col">
			<option value="" <c:if test="${pageInfo.whatColumn eq null}">selected</c:if>>전체 검색</option>
			<option value="area" <c:if test="${pageInfo.whatColumn eq 'area'}">selected</c:if>>지역</option>
			<option value="style" <c:if test="${pageInfo.whatColumn eq 'style'}">selected</c:if>>여행 스타일</option>
		</select>
		<input type="text" name="keyword" <c:if test="${pageInfo.keyword == null}">value=""</c:if><c:if test="${pageInfo.keyword != null}">value="${pageInfo.keyword}"</c:if>>
		<input type="submit" value="검색">
	</form>
	<table border="1">
		<tr>
			<td colspan="8">
				<input type="button" value="추가하기" onClick="insert()">
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>관심지역</th>
			<th>여행스타일</th>
			<th>예상비용</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:if test="${fn:length(lists) == 0}">	<!-- ${empty lists} -->
			<tr><td colspan="8" align="center">검색 결과가 없습니다</td></tr>
		</c:if>
		<c:if test="${fn:length(lists) != 0}">	<!-- ${not empty lists} -->
			<c:forEach var="tb" items="${lists}">
				<tr>
					<td>${tb.num}</td>
					<td><a href="detail.tv?num=${tb.num}&pageNumber=${pageInfo.pageNumber}">${tb.name}</a></td>
					<td>${tb.age}</td>
					<td>${tb.area}</td>
					<td>${tb.style}</td>
					<td>${tb.price}</td>
					<td><input type="button" value="수정" onClick="goUpdate(${tb.num},${pageInfo.pageNumber})"></a></td>
					<td><a href="delete.tv?num=${tb.num}&pageNumber=${pageInfo.pageNumber}">삭제</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	${pageInfo.pagingHtml}
</center>