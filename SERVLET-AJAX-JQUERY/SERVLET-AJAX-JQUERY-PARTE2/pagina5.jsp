<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script src="http://d3js.org/d3.v3.min.js"></script>
	

</head>
<body>

<%
String nome = request.getParameter("nome");
String idade = request.getParameter("idade");
response.setContentType("text/html");
response.setStatus(200);
response.getWriter().write("O nome é "+nome+" e a idade é "+idade);
%>
<p>O nome é <%=nome %> e a idade é <%=idade %></p>

</body>
</html>