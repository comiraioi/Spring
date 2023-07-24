<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

person/input?name=kim&age=20 요청 -> person/result1.jsp<br><br>

name1: <%=request.getParameter("name") %><br>
name2: ${param.name}<br>
name3: ${param['name']}<br>
name4: <%=request.getAttribute("name") %><br><br>  <!-- controller에서 속성 설정해야 attribute로 받을 수 있음 -->

age1: <%=request.getParameter("age") %><br>
age2: ${param.age}<br>
age3: ${param['age']}<br>
age4: <%=request.getAttribute("age") %><br><br>

