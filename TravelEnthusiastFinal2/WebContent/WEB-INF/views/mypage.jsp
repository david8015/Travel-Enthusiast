<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>

<style>

.active2 {
    background-color: #4CAF50;
}

h2 a{
float: right;
}

</style>

</head>
<body>

<div>
<%@include file="header.jsp" %>
</div>

<!-- <img src="https://res.cloudinary.com/david8015/image/upload/v1512063955/sample.jpg"> -->


<%-- <h1 style = "margin-top: 30px"> Welcome: ${user.userName}</h1> --%>

<form action="editInfo" method="post">
<h2 style = "margin-top: 35px">My Information: <a href="editInfo"> Edit My Information</a></h2>

<div style = "border: 1px solid black; margin-top: 30px;">
          <h3>First Name: ${userInfo.firstName}</h3>
          <p>
            <h3>Last Name: ${userInfo.lastName}</h3>
          </p>
          <hr>
          <p>Email: ${userInfo.email}</p>                                    
          <p>Country: ${userInfo.country}</p>
   </div>
 </form>
 
 <h2 style = "margin-top: 35px">My Experience List: <a href="addExperience"> Add An Experience</a></h2>
 
 <form action="addEventPage" method="post">
<c:forEach items="${userExpList}" var="s">
	<div style = "border: 1px solid black; margin-top: 30px;">
	
	             <!--Passing experience ID to be included with picture input  -->
          <h3>Title: ${s.title}<a style = "margin: 10px;" href="addEventPage?experienceID=${s.id}&title=${s.title}">Add event to Experience</a></h3>
          <p>
            <h3>Date: ${s.experiencedate}</h3>
          </p>
          <p>Experience: ${s.experiencetype}</p>                                    
          <p>posted On: ${s.posteddate}</p>
          <p>Description: ${s.description}</p>
   </div>
 </c:forEach>
</form>

</body>
</html>