<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

member\insertForm.jsp<br>

<!-- model 설정한 값 (= 속성 설정한 값) -->
id1: <%=request.getParameter("id")%> <br>	<!-- null -->
id2: <%=request.getAttribute("id")%> <br>
id3: ${param.id} <br>						<!-- null -->
id4: ${requestScope.id} <br>
id5: ${id} <br><br>

pw1: <%=request.getParameter("pw")%> <br>	<!-- null -->
pw2: <%=request.getAttribute("pw")%> <br>
pw3: ${param.pw} <br>						<!-- null -->
pw4: ${requestScope.pw} <br>
pw5: ${pw} <br><br>
