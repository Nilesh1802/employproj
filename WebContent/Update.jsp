<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link href="css/style.css" rel="stylesheet" type="text/css">
<%@ page import="query.Queries" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><br><br><br><br>


<div class="header">
<div class="header-top">
<h1 >Employee Details</h1>
</div>
<img src="images/footnote.gif" class="copyright" alt="http://www.usaonlinecasinos.org"></a>
<!--DO NOT Remove The Footer Links-->

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
String id=(String)request.getParameter("id");
String name=(String)request.getParameter("name");
String salary=(String)request.getParameter("salary");
%><br>
<h3 style="color:#5d5d5d">Row Updated Successfully</h3><br>
<h4 style="color:red"> The Values Updated are</h4> <br>
<table style="color:red">
<tr style="color:red">
<td style="color:red"><%=id%></td>
<td style="color:red"><%=name%></td>
<td style="color:red"><%=salary%></td>
</tr>
</table>
</center>
</div>
</body>
</html>