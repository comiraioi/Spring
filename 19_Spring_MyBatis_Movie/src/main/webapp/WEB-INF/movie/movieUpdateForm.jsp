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

<script type="text/javascript" src="resources/js/jquery.js"></script>	<!-- ready 함수 사용 -->
<script type="text/javascript">
	var contArr = new Array('아시아','아프리카','유럽','아메리카','오세아니아');
	
	var nationArr = new Array();
	nationArr[0] = new Array('한국','중국','일본','인도');
	nationArr[1] = new Array('케냐', '가나', '세네갈');
	nationArr[2] = new Array('스페인', '영국','덴마크','러시아','체코');
	nationArr[3] = new Array('미국', '캐나다'); 
	nationArr[4] = new Array('뉴질랜드','오스트레일리아');

	function init(myform){
		var mbCont = "${mb.continent}";
		var mbNation = "${mb.nation}";
		var flag = false;
		
		for(i=0; i<contArr.length; i++){	
			myform.continent.options[i+1] = new Option(contArr[i]);
			if(contArr[i] == mbCont){
				myform.continent.options[i+1].selected = true;
				flag=true;
			}
		}
		
		c_index = myform.continent.selectedIndex;
		c_value = myform.continent[c_index].value;
		
		if(flag == true){
			for(var i=0; i<nationArr[c_index-1].length; i++){
				myform.nation.options[i+1] = new Option(nationArr[c_index-1][i]);
				if(nationArr[c_index-1][i] == mbNation){
					myform.nation.options[i+1].selected = true;
				}
			}
		}
	}
	
	function ctgChange(myform){
		c_index = myform.continent.selectedIndex;
		c_value = myform.continent[c_index].value;
		//alert(c_index+": "+c_value)
		
		for(i=myform.nation.length; i>0 ;i--){
			myform.nation.options[i] = null;
		}
		
		for(var i=0; i<nationArr[c_index-1].length; i++){
			myform.nation.options[i+1] = new Option(nationArr[c_index-1][i]);
		}
	}

</script>
    
<!-- movieUpdateForm -->

<%
	String[] genreArr = {"액션","스릴러","코미디","판타지","애니메이션"};
	String[] gradeArr = {"19","15","12","7"};
%>

<body onLoad="init(myform)">
<h2>영화 정보 수정 (번호: ${mb.num})</h2>
<form:form name="myform" commandName="mb" action="update.mv" method="post" onSubmit="return writeSave()">
	<input type="hidden" name="num" value="${mb.num}">
	<input type="hidden" name="pageNumber" value="${pageNumber}">
	<p>
		<label>제목: </label>
		<input type="text" name="title" value="${mb.title}">
		<form:errors cssClass="err" path="title"/>
	</p>
	<p>
		<label>대륙: </label>
		<select name="continent" id="continent" onchange="ctgChange(myform)">
			<option value="">대륙을 선택하세요</option>
		</select>
		<form:errors cssClass="err" path="continent"/>
	</p>
	<p>
		<label>나라: </label>
		<select name="nation" id="nation">
			<option value="">나라를 선택하세요</option>
		</select>
		<form:errors cssClass="err" path="nation"/>
	</p>
	<p>
		<label>장르: </label>
		<c:forEach var="genre" items="<%=genreArr%>">
			<input type="checkbox" name="genre" value="${genre}" <c:if test="${mb.genre.contains(genre)}">checked</c:if>>${genre}
		</c:forEach>
		<form:errors cssClass="err" path="genre"/>
	</p>
	<p>
		<label>등급: </label>
		<c:forEach var="grade" items="<%=gradeArr%>">
			<input type="radio" name="grade" value="${grade}" <c:if test="${mb.grade eq grade}">checked</c:if>>${grade}
		</c:forEach>
		<form:errors cssClass="err" path="grade"/>
	</p>
	<p>
		<label>출연배우: </label>
		<input type="text" name="actor" value="${mb.actor}">
	</p>
	<p>
		<input type="submit" value="수정하기">
	</p>
</form:form>
</body>