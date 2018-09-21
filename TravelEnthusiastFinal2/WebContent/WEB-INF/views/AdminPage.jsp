<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.TravelEnthusiast2.DAO.UserDAO" %>
    <%@page import="com.TravelEnthusiast2.Bean.User" %>
    <%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administration Page</title>
</head>
<body>
<%/* List<User> l = UserDAO.getAllUsers(); */

//out.write("<h1> ALL USERS: </h1>");
/* out.print("<h3 style =\"color:green;\" > USERS: </h3>\r\n");

int count = 1;

for (User s: l){
 out.print("<span style =\"color:red;\">user </span>" + count + ": " + s.getUserName());
 out.print("<br />");
 count++; */
/* } */
%>

<h3> delete a user</h3>
<!--Have to save the userName in a variable then pass it to the function.  -->

<%-- <%
 Boolean a = UserDAO.deleteUser("userName");

if(a){
	out.write("user deleted.");
}

else{
	out.write("user was not found.");
}
%> --%>

<h1> user name: ${userkey.userName}</h1>


</body>
</html>