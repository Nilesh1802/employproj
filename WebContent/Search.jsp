<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="query.Queries" %>
     <%@ taglib prefix="db" uri="/WEB-INF/message.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
<br><center><br><br><br>

    <% 
    int id=(Integer)request.getAttribute("id");
    pageContext.setAttribute("id",id);
    %> 
    <center><br><br><br>
   	<h3 style="color:#5d5d5d"> The Value Searched is </h3><br>
   	<db:SearchTag/> 
 <br><br><br>
</body>
</html>