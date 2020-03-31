<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="css/bootstrap.min.css" >
<title>Insert title here</title>
</head>
<body>


 <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
    <script src="js/bootstrap.min.js" ></script>


 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 <%@page import="classes.*" %>
 <%@page import="java.util.List" %>
 
<%

 List<Contacts> data = Contact_Api.Data();
 Contacts contacts   = data.get(0);
 session.setAttribute("data", contacts);

%>




<div class="list-group  justify-content-center" >




 <ul class="list-group">
 
  
  
   <li class="list-group-item"> 
   
   <ul class="list-group list-group-horizontal-sm ">
   <%for(int i=0;i<data.size();i++){ %>
   <li class="list-group-item"> 
   
    <img src="data:image/jpg;base64,<%=data.get(i).getBass64() %>" width="350" height="380"/>
   
   </li>
    <%} %>
   </ul>
   
   
   </li>
 
 
</ul>







  
    



</div>
    
    
    
   



</body>
</html>