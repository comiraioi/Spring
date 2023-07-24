<%@page import="com.spring.ex.MusicBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

input2 요청 => result2.jsp<br><br>

<b>param</b><br>
Title: ${param.title} / <%=request.getParameter("title") %><br>
Singer: ${param.singer}	/ <%=request.getParameter("singer") %><br>
price: ${param.price} / <%=request.getParameter("price") %>
<hr>
<b>model</b><br>
<% MusicBean mb = (MusicBean)request.getAttribute("mb"); %>
Title: ${requestScope.mb.title} / <%=mb.getTitle() %><br>
Singer: ${mb.getSinger()} / <%=mb.getSinger() %><br>
price: ${mb.price} / <%=mb.getPrice()%>