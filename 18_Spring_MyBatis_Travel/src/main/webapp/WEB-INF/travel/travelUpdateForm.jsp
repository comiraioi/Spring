<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<style type="text/css">
	.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
	}
</style>

<!-- travelUpdateForm.jsp -->

<%
	String[] area = {"유럽","동남아","일본","중국"};
	String[] style = {"패키지", "크루즈", "자유여행", "골프여행"};
	String[] price = {"100~200","200~300","300~400","400~500"};
%>

<h2>여행 정보 수정</h2>
<form:form commandName="tb" action="update.tv" method="post">
	<input type="hidden" name="num" value="${tb.num}">
	<input type="hidden" name="pageNumber" value="${pageNumber}">
	<p>
		<label><b>이름</b></label>	
		<input type="text" name="name" value="${tb.name}">
		<form:errors cssClass="err" path="name"/>
	</p>
	<p>
		<label><b>나이</b></label>
		<input type="text" name="age" value="${tb.age}">
		<form:errors cssClass="err" path="age"/>
	</p>
	<p>
		<label><b>관심 지역</b></label>
		<c:forEach var="area" items="<%=area%>">
			<input type="checkbox" name="area" value="${area}" <c:if test="${tb.area.contains(area)}">checked</c:if>>${area}
		</c:forEach>
		<form:errors cssClass="err" path="area"/>
	</p>
	<p>
		<label><b>여행 스타일</b></label>
		<c:forEach var="style" items="<%=style%>">
			<input type="radio" name="style" value="${style}" <c:if test="${tb.style == style}">checked</c:if>>${style}
		</c:forEach>
		<form:errors cssClass="err" path="style"/>
	</p>
	<p>
		<label><b>가격</b></label>
		<select name="price">
			<option value="">선택하세요</option>
			<c:forEach var="price" items="<%=price%>">
				<option value="${price}" <c:if test="${tb.price eq price}">selected</c:if>>${price}</option>
			</c:forEach>
		</select>
		<form:errors cssClass="err" path="price"/>
	</p>
	<p>
		<input type="submit" value="수정하기">
	</p>
</form:form>
