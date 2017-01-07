<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="query.Queries" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><br><br><br><br>
<div class="page-in">
<div class="page">
<div class="main">
<div class="header">
<div class="header-top">
<h1 >Employee Details</h1>
</div>
<img src="images/footnote.gif" class="copyright" alt="http://www.usaonlinecasinos.org"></a>
<!--DO NOT Remove The Footer Links-->
</div>
 <div class="topmenu">
<ul>
  <li><a href="insert.html"><span>Insert&nbsp;</span></a></li>
  <li><a href="update.html"><span>Update&nbsp;</span></a></li>
  <li><a href="delete.html"><span>Delete</span></a></li>
  <li><a href="search.html"><span>Search</span></a></li>
  <li><a href="viewall.jsp"><span>View All</span></a></li>
</ul>
<br><center>
<% 

int rows=(Integer)request.getAttribute("numberofrows");
if(rows>0)
{
%>
<br><br><br> 
<h2 style="color:5d5d5d"> Row inserted Successfully</h2><br>
<table>
	<tr style="color:red;"><th>Id</th><th>Name</th><th>Salary</th></tr>
	<tr style="color:red;"><td><%=request.getParameter("id") %></td><td><%=request.getParameter("name") %></td><td><%=request.getParameter("salary") %></td></tr>
	
</table>
<%
}
%>
</center>
</body>
</html>