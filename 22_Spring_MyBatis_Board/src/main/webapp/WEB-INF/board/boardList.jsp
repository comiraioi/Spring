<%@page import="utility.Paging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/style.css">
<style>
	body{
		text-align: center;
	}
	table{
		margin: 5px auto;
		width : 600px;
		border-collapse:collapse;
	}
</style>

boardList.jsp<br><br>

<center>
	<h2>게시판</h2>
	<form method="get">
		<select name="whatColumn">
			<option value="">전체 검색</option>
			<option value="subject">제목</option>
			<option value="writer">작성자</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
	<c:if test="${pageInfo.totalCount == 0}">
		<table>
			<tr><td align="center" bgcolor="<%=value_c%>">게시판에 저장된 글이 없습니다</td></tr>
		</table>
	</c:if>
	<c:if test="${pageInfo.totalCount != 0}">
		<table style="text-align: center">
			<tr>
				<td colspan="6" align="right" bgcolor="<%=value_c%>">
					<a href="write.bd">글쓰기</a>
				</td>
			</tr>
			<tr height="30" bgcolor="<%=value_c%>">
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
				<th>IP</th>
			</tr>
			<c:forEach var="board" items="${boardList}" varStatus="status">
				<tr height="30">
					<td align="center" bgcolor="<%=value_c%>">${pageInfo.totalCount - pageInfo.pageSize*(pageInfo.pageNumber-1)-status.index}</td>
					<td align="left">
						<c:set var="wid" value="20"/>
						<!-- re_level: 0=원글, 1=답글, 2=답글의 답글, ... -->
						<c:if test="${board.relevel > 0}">	<!-- 답글이면 -->
							<!-- 너비 설정해서 이미지 배치 -->
							<c:set var="wid" value="${20 * board.relevel}"/>	
								<img src="<%=request.getContextPath() %>/resources/images/level.gif" width="${wid}" height="10">
								<img src="<%=request.getContextPath() %>/resources/images/re.gif">
						</c:if>
						<a href="article.bd?num=${board.num}&pageNumber=${pageInfo.pageNumber}">${board.subject}</a>
						<!-- 조회수가 10 이상이면 -->
						<c:if test="${board.readcount >= 10}">
							<img src="<%=request.getContextPath() %>/resources/images/hot.gif" height="10">
						</c:if>
					</td>
					<td>${board.writer}</td>
					<td>${board.regdate}</td>
					<td>${board.readcount}</td>
					<td>${board.ip}</td>
				</tr>
			</c:forEach>
		</table>
		${pageInfo.pagingHtml}
	</c:if>
</center>
