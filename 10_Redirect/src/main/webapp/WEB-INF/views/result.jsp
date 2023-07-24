<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

result.jsp<br><br>

name1: ${param.name} <br>
name2: <%=request.getParameter("name") %> <br>
name3: <%=request.getAttribute("aname") %> <br>
name4: ${redirectMap.mname} <br>