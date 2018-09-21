<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>

<style>

li a:hover {
    background-color: #F00;
}

</style>


</head>
<body>

<ul style = "list-style-type:none; margin:0; padding: 0; overflow: hidden; background-color: #333; width: 100%; position: fixed;">
  <li class = "active1" style = "float:left;"><a style = "display:block; color:white; padding: 14px 16px; text-decoration: none;" href="home">Travel Enthusiast</a></li>
  <li class = "active2" style = "float:left;"><a style = "display:block; color:white; padding: 14px 16px; text-decoration: none;" href="mypage">${userkey.userName}</a></li>
<!--   <li class = "active3" style = "float:left;"><a class = "active3" style = "display:block; color:white; padding: 14px 16px; text-decoration: none;" href="sortby">Sort By:</a></li>
 -->  <li class = "active4" style = "float:left;"><a style = "display:block; color:white; padding: 14px 16px; text-decoration: none;" href="contact">Contact</a></li>
  <li class = "active5" style = "float:left;"><a style = "display:block; color:white; padding: 14px 16px; text-decoration: none;" href="about">About</a></li>
  <li class = "active6" style = "float:left;"><a style = "display:block; color:white; padding: 14px 16px; text-decoration: none;" href="logout">Log Out</a></li>
</ul>

<br>
</body>
</html>