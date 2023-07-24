<%@page import="com.spring.ex.MusicBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

input3 요청 => result3.jsp<br><br>

<b>param</b><br>
Title: ${param.title} / <%=request.getParameter("title") %><br>
Singer: ${param.singer}	/ <%=request.getParameter("singer") %><br>
price: ${param.price} / <%=request.getParameter("price") %>
<hr>
<b>command</b><br>
<% MusicBean mb = (MusicBean)request.getAttribute("musicBean"); %>
Title: ${requestScope.musicBean.title} / <%=mb.getTitle() %><br>
Singer: ${musicBean.getSinger()} / <%=mb.getSinger() %><br>
Price: ${musicBean.price} / <%=mb.getPrice()%>