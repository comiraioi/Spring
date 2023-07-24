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

productInsertForm.jsp<br>

<%
	/* ServletContext sc = new ServletContext(); => 프로젝트당 객체 1개 자동 생성 */
	application.getAttribute("loginInfo");
%>

<!-- 파일 업로드
	- method="post"
	- enctype="multipart/form-data"	-->

<h2>상품 추가</h2>
<form:form commandName="pb" action="insert.prd" method="post" enctype="multipart/form-data">
	<p>
		<label>*상품명</label>
		<input type="text" name="name" value="${pb.name}">
		<form:errors cssClass="err" path="name"/>
	</p>
	<p>
		<label>제조회사</label>
		<input type="text" name="company" value="${pb.company}">
	</p>
	<p>
		<label>가격</label>
		<input type="text" name="price" value="${pb.price}">
	</p>
	<p>
		<label>재고 수량</label>
		<input type="text" name="stock" value="${pb.stock}">
	</p>
	<p>
		<label>적립 포인트</label>
		<input type="text" name="point" value="${pb.point}">
	</p>
	<p>
		<label>*설명</label>
		<input type="text" name="contents" value="${pb.contents}">
		<form:errors cssClass="err" path="contents"/>
	</p>
	<p>
		<label>*상품 이미지</label>
		<input type="file" name="upload">	<!-- 임시변수 -->
		<form:errors cssClass="err" path="image"/>
	</p>
	<p>
		<label>입고 일자</label>
		<input type="date" name="inputdate">
	</p>
	<p>
		<input type="submit" value="추가하기">
	</p>
</form:form>
