<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Event List</title>
<style>

.active3{
display:none;
}

</style>

</head>
<body>

<div>
<%@include file="header.jsp" %>
</div>

               <!--Events  -->
	<c:forEach items="${eventByExpTitle}" var="s">
		<div style = "border: 1px solid black; margin-top: 30px;">
          <!-- Title -->
          <h1>${s.eventTitle}</h1>
          <!-- Author -->
          <p>
            by
            <h3>${s.userName}</h3>
          </p>
          <hr>
          <!-- Date/Time -->
          <pre>Event date: ${s.eventDate}                                         posted on: ${s.eventPostedDate}</pre>
          <hr>
          <!--Image -->
          <img src="${s.eventImage}" alt="TRAVELES ENTHUSIAST PLACEHOLDER">
          <hr>
          <!--Content -->
          <p>${s.eventDescription}</p>
          <hr>
   </div>
   
          <!-- Comments Form -->
  <form method = post action = "addComment">
          <div style = "border: 1px solid black;">
            <h4>Leave a Comment:</h4>
             <div>
                  <textarea rows="5" maxlength="250" name = "commentsDescription" style = "width: 200px;"></textarea>
                </div>
                <button type="submit">Submit</button>
	         </div>    
  </form>        
             <!-- Comments -->
		<c:forEach items = "${commentsByExpTitle}" var ="s">          
        	<div style = "border: 1px solid black;">
              <h4>Posted By: <span style = "color:green;">${s.userName}</span></h4>
              <h4>On: <span style = "color:green;">${s.postedDate}</span></h4>
              <p style = "color:green;">${s.commentsDescription}</P>
        	</div>
 		</c:forEach> 
 
	</c:forEach>
       

</body>
</html>