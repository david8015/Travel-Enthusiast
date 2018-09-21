<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add experience</title>
</head>
<body>

      <!--Posted date is set to default. User ID passed from User.  -->
<!-- 	  private String posteddate;
	  private String userID; -->
	 
<div>
	<%@include file="header.jsp" %>
</div>
	  
<form method="post" action="inputExperience">
	<h2 style="color:green; text-align:center; margin-top: 40px;">ADD EXPERIENCE INFORMATION:</h2>
	<table style = "border:1px solid; margin: 0 auto; text-align:center; width: 500px; height: 500px;">
		<tr>
			<td>Title :</td>
			<td><input type="text" name="title" maxlength="100" placeholder="100 character maximum" autofocus required/></td>
		</tr>
		<tr>
			<td>Date of Experience :</td>
			<td><input type="text" name="experiencedate" placeholder="YYYY-MM-DD format" required/></td>
		</tr>
		<tr>
			<td>Type of Experience :</td>
			<td><select name="experiencetype" required/>
			        <option value="Beach - Relaxation">Beach - Relaxation</option>
					<option value="Educational - Historical">Educational - Historical</option>
					<option value="Fun - Partying">Fun - Partying</option>
					<option value="Business">Business</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Description :</td>
			<td><textarea rows="6" maxlength="250" name = "description" placeholder="250 character maximum" style = "width: 250px;"></textarea></td>
			<!-- <td><input type="text" name="description" required/></td> -->
		</tr>
		<tr>
			<td colspan = "2"><input type="submit" name="register" value = "submit"></td>
		</tr>
	</table>
</form>


</body>
</html>