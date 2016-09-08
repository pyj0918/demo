<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
success
<%=request.getAttribute("time")%><br>
<%=request.getAttribute("names")%><br>
<%=session.getAttribute("names") %>
</body>
</html>
