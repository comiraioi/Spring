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

productUpdateForm.jsp<br>

<center>
<h2>상품 수정 (${pb.num}번)</h2>
<form:form commandName="pb" action="update.prd" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num" value="${pb.num}">
	<input type="hidden" name="pageNumber" value="${pageNumber}">
	<table border="1">
		<tr>
			<th>*상품명</th>
			<td>
				<input type="text" name="name" value="${pb.name}">
			<form:errors cssClass="err" path="name"/>
			</td>
		</tr>
		<tr>
			<th>제조회사</th>
			<td>
				<input type="text" name="company" value="${pb.company}">
			</td>
		</tr>
		<tr>
			<th>*가격</th>
			<td>
				<input type="text" name="price" value="${pb.price}">
				<form:errors cssClass="err" path="price"/>
			</td>
		</tr>
		<tr>
			<th>재고 수량</th>
			<td>
				<input type="text" name="stock" value="${pb.stock}">
			</td>
		</tr>
		<tr>
			<th>적립 포인트</th>
			<td>
				<input type="text" name="point" value="${pb.point}">
			</td>
		</tr>
		<tr>
			<th>*설명</th>
			<td>
				<input type="text" name="contents" value="${pb.contents}">
				<form:errors cssClass="err" path="contents"/> 
			</td>
		</tr>
		<tr>
			<th>*상품 이미지</th>
			<td>
				<img alt="없음" src="<%=request.getContextPath()%>/resources/${pb.image}" width="70"><br>
				<input type="text" name="upload2" value="${pb.image}"><br>	<!-- 기존 이미지 -->
				<input type="file" name="upload">	<!-- 새로 업로드하는 이미지 -->
				<form:errors cssClass="err" path="image"/>	
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="수정하기"></td>
		</tr>
	</table>
</form:form>
</center>
