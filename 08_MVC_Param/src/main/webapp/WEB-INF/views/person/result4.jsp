<%@page import="com.spring.ex.PersonBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

person/input4 요청 => person/result4.jsp<br><br>

<% PersonBean per = (PersonBean)request.getAttribute("personBean"); %>
id: <%=per.getId() %> / ${requestScope.personBean.id}<br>
passwd: <%=per.getPasswd() %> / ${personBean.getPasswd()}<br>
addr: <%=per.getAddr() %> / ${personBean.addr}


