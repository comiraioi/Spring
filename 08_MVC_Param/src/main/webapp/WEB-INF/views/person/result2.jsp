<%@page import="com.spring.ex.PersonBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

person/input2?id=kim&passwd=1234&addr=seoul 요청 <br>
=> person/result2.jsp<br><br>

id1: <%=request.getParameter("id") %> <br>
id2: ${param.id} <br>
passwd1:  <%=request.getParameter("passwd") %> <br>
passwd2: ${param.passwd} 
<hr>
<% PersonBean pb = (PersonBean)request.getAttribute("pb"); %>
id: <%=pb.getId() %> / ${requestScope.pb.id}<br>
passwd: <%=pb.getPasswd() %> / ${pb.getPasswd()}<br>
addr: <%=pb.getAddr() %> / ${pb.addr}


