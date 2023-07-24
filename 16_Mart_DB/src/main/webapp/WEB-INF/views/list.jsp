<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function allCheck(obj){		//obj = document.myform.allChk
		var numArr = document.getElementsByName("numChk");
		
		if(obj.checked){
			for(i=0; i<numArr.length; i++){
				numArr[i].checked = true;
			}
		}else{
			for(i=0; i<numArr.length; i++){
				numArr[i].checked = false;
			}
		}
	}
	
	function chkDelete(){
		flag = false;
		var numArr = document.getElementsByName("numChk");
		
		for(i=0; i<numArr.length; i++){
			if(numArr[i].checked){
				flag = true;
			}
		}
		
		if(!flag){
			alert("삭제할 행을 선택하세요");
			return;
		}
		
		document.myform.submit();
	}
	
</script>

list 요청 => list.jsp<br><br>

<form name="myform" action="deleteChk" method="post">
<input type="button" value="삭제" onClick="chkDelete()"> &nbsp; <a href="insert">추가</a>  
<table border="1">
	<tr>
		<td><input type="checkbox" name="allChk" onClick="allCheck(this)"></td>
		<th>번호</th>
		<th>아이디</th>
		<th>비번</th>
		<th>구매상품</th>
		<th>배송시간</th>
		<th>결제방법</th>
		<th>동의</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="mb" items="${requestScope.lists}">
		<tr>
			<td><input type="checkbox" name="numChk" value="${mb.num}"></td>
			<td>${mb.num}</td>
			<td>${mb.id}</td>
			<td>${mb.pw}</td>
			<td>${mb.product}</td>
			<td>${mb.time}</td>
			<td>${mb.approve}</td>
			<td>${mb.agree}</td>
			<td><a href="update?num=${mb.num}">수정</a></td>
			<td><a href="delete?num=${mb.num}">삭제</a></td>
		</tr>
	</c:forEach>
</table>
</form>
