<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<script type="text/javascript">
	function insert(){ 
		location.href="insert.ab"
	}
</script>

albumList.jsp<br><br>

<h2 align="center">앨범 리스트 (레코드 수: ${totalCount})</h2>
<center>
	<form action="" method="get">
		<select name="whatColumn">
			<option value="">전체검색</option>
			<option value="title">노래 제목</option>
			<option value="singer">가수명</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
	<table border="1">
		<tr>
			<td colspan="7" align="right">
				<input type="button" value="추가하기" onClick="insert()">
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>가수</th>
			<th>가격</th>
			<th>발매일</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="ab" items="${requestScope.albumLists}">
			<tr>
				<td>${ab.num}</td>
				<td><a href="detail.ab?num=${ab.num}">${ab.title}</a></td>
				<td>${ab.singer}</td>
				<td>${ab.price}</td>
				<td>
					<fmt:parseDate var="fmtday" value="${ab.day}" pattern="yyyy-MM-dd"/>
					<fmt:formatDate var="day" value="${fmtday}" pattern="yyyy-MM-dd"/>
					${day}
				</td>
				<td><a href="update.ab?num=${ab.num}">수정</a></td>
				<td><a href="delete.ab?num=${ab.num}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</center>
<center>
	<!-- pageInfo로 model 속성 설정한 Paging 객체의 getPaingHtml 메서드 호출  -->
	${pageInfo.pagingHtml}
</center>