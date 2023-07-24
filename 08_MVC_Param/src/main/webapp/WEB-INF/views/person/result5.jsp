<%@page import="com.spring.ex.PersonBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

person/input5 요청 => person/result5.jsp<br><br>

<% PersonBean per = (PersonBean)request.getAttribute("abcd"); %>
id: <%=per.getId() %> / ${requestScope.abcd.id}<br>
passwd: <%=per.getPasswd() %> / ${abcd.getPasswd()}<br>
addr: <%=per.getAddr() %> / ${abcd.addr}


