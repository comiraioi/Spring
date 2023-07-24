<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

form 요청(POST) => result2.jsp<br><br>

제목: ${param.title}<br>
저자: ${param.author} <br>
가격: ${param.price} <br>
출판사:  ${param.publisher} <br>
구입 서점:
	<c:forEach var="i" items="${paramValues.bookstore}" varStatus="status">
		${i}
		<c:if test="${! status.last}">,</c:if>
	</c:forEach>
	<br>
배송비: ${param.kind}