<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Multiple Events</title>
</head>
<body>

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
          <p>${s.eventPostedDate}</p>
          <hr>
          <!--Image -->
          <img src="${s.eventImage}" alt="TRAVELES ENTHUSIAST PLACEHOLDER">
          <hr>
          <!--Content -->
          <p>${s.eventDescription}</p>
          <hr>
   </div>
</c:forEach>
</body>
</html>