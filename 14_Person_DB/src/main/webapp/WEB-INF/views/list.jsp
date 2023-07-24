<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function allCheck(obj){
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
	
	function deleteChk(){
		var flag = false;
		var numArr = document.getElementsByName("numChk");
		
		for(i=0; i<numArr.length; i++){
			if(numArr[i].checked){
				flag = true;
			}
		}
		
		if(!flag){
			alert("삭제할 행을 선택하세요")
		}
		
		myform.submit();
	}
	
</script>

list 요청 => list.jsp<br><br>

<form name="myform" action="deleteChk">
<input type="button" value="삭제" onClick="deleteChk()">
<table border="1">
	<tr>
		<td><input type="checkbox" name="allChk" onClick="allCheck(this)"></td>
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>나이</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="pb" items="${requestScope.lists}">
		<tr>
			<td><input type="checkbox" name="numChk" value="${pb.num}"></td>
			<td>${pb.num}</td>
			<td>${pb.id}</td>
			<td>${pb.name}</td>
			<td>${pb.age}</td>
			<td><a href="updateform?num=${pb.num}">수정</a></td>
			<td><a href="delete?num=${pb.num}">삭제</a></td>
		</tr>
	</c:forEach>
</table>
<a href="writeform">추가</a>	<!-- get 방식 요청 -->
<!-- 컨트롤러를 거치지 않고 writeform.jsp로 이동 불가능 -->
</form>
