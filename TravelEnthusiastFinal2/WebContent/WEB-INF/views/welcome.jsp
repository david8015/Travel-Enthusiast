<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Travel Enthusiast2</title>
</head>
<body>
<h3 style="text-align:center; color:green;">${success}</h3>
<h3 style="text-align:center; color:red;">${incorrectInfo}</h3>

<form method="post" action="login_info">
	<h2 style="color:green; text-align:center;">Login</h2>
	<table style = "border:1px solid; margin: 0 auto; text-align:center;">
		<tr>
			<td>user name :</td>
			<td><input type="text" name="userName" autofocus required/></td>
		</tr>
		<tr>
			<td>password :</td>
			<td><input type="password" name="password" required/></td>
		</tr>
		<tr>
			<td><input type="submit" name="login" value = "login"></td>
			<td><button><a style= "text-decoration: none; " href="registerPage">Register</a></button></td>
			
			
			<!-- <td><input type="button" name="register" value="register"></td> -->
			
			<!-- worked -->
			<!-- <td><a href="register">Register</a></td> -->
			
			<!-- <td><input type="submit" name="register" value="register"></td> -->
			<!-- <td><a href="login.jsp">Register</a></td> -->
			
		</tr>
	</table>
</form>
</body>
</html>