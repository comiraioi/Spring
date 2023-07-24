<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

form 요청(POST) => result2.jsp<br><br>

제목: ${bookBean.title}<br>
저자: ${bookBean.author} <br>
가격: ${bookBean.price} <br>
출판사:  ${bookBean.publisher} <br>
구입 서점1:
	<c:forEach var="i" items="${paramValues.bookstore}" varStatus="status">
		${i}
		<c:if test="${! status.last}">,</c:if>
	</c:forEach>
	<br>
구입 서점2: ${bookBean.bookstore} <br>		<!-- 커맨드객체로 만들어질때 set 메서드에서 자동으로 , 찍어서 넘어옴 -->
배송비: ${bookBean.kind}