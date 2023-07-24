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

<script type="text/javascript">
	
	var contArr = new Array('아시아','아프리카','유럽','아메리카','오세아니아');
	
	var nationArr = new Array();
	nationArr[0] = new Array('한식','중식','일식','베트남식');
	nationArr[1] = new Array('이집트','케냐');
	nationArr[2] = new Array('스페인','영국','이탈리아','프랑스');
	nationArr[3] = new Array('미국','캐나다','멕시코'); 
	nationArr[4] = new Array('뉴질랜드','오스트레일리아');

	function init(myform){
		for(i=0; i<contArr.length; i++){	
			myform.continent.options[i+1] = new Option(contArr[i]);
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
    
<!-- recipeInsertForm -->

<%
	String[] ingrArr = {"빵","면","밥","고기","해산물","양파","토마토","치즈"};
	String[] ssngArr = {"케찹","고추장","간장","소금"};
%>

<body onLoad="init(myform)">
<h2>레시피 등록</h2>
<form:form name="myform" commandName="rb" action="insert.rc" method="post">
	<p>
		<label>이름: </label>
		<input type="text" name="dish" value="${rb.dish}">
		<form:errors cssClass="err" path="dish"/>
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
		<label>재료: </label>
		<c:forEach var="ingr" items="<%=ingrArr%>">
			<input type="checkbox" name="ingredient" value="${ingr}" <c:if test="${rb.ingredient.contains(ingr)}">checked</c:if>>${ingr}
		</c:forEach>
		<form:errors cssClass="err" path="ingredient"/>
	</p>
	<p>
		<label>양념: </label>
		<c:forEach var="ssng" items="<%=ssngArr%>">
			<input type="radio" name="seasoning" value="${ssng}" <c:if test="${rb.seasoning eq ssng}">checked</c:if>>${ssng}
		</c:forEach>
		<form:errors cssClass="err" path="seasoning"/>
	</p>
	<p>
		<label>칼로리: </label>
		<input type="text" name="calorie" value="${rb.calorie}">
	</p>
	<p>
		<input type="submit" value="추가하기" id="sub">
	</p>
</form:form>
</body>