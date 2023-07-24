<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

list.jsp<br>

<!-- ModelAndView 설정한 값 (= 속성 설정한 값) -->
name1: <%=request.getAttribute("name")%> <br>					
name2: ${requestScope.name} <br>
name3: ${name} <br><br>

age1: <%=request.getAttribute("age")%> <br>
age2: ${requestScope.age} <br>
age3: ${age} <br><br>