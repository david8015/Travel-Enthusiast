<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add experience</title>
</head>
<body>

<div>
	<%@include file="header.jsp" %>
</div>
	  
<form method="post" action="inputExperience">
	<h2 style="color:green; text-align:center; margin-top: 40px;">ADD AN EXPERIENCE:</h2>
	<table style = "border:1px solid; margin: 0 auto; text-align:center; width: 600px; height: 100%">
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
		</tr>

		<tr>
			<td>Picture Title :</td>
			<td><input type="text" name="pictureTitle" maxlength="100" placeholder="100 character maximum" required/></td>
		</tr>
		<tr>
			<td>Enter Image source location :</td>
			<td><input type="text" name="image" placeholder="source location" required/></td>
		</tr>
		
		<tr>
			<td>Photo of :</td>
			<td><select name="picture_of" required/>
			        <option value="Beach">Beach</option>
					<option value="Park">Park</option>
					<option value="Building(s)">Buildings(s)</option>
					<option value="Event">Event</option>
					<option value="People">People</option>
					<option value="Hotel">Hotel</option>
					<option value="Other">Other</option>
				</select>
			</td>
		</tr>
		
		<tr>
			<td>Photo Date :</td>
			<td><input type="text" name="photo_date" placeholder="YYYY-MM-DD format" required/></td>
		</tr>
		
		<tr>
			<td>Landmark :</td>
			<td><select name= "landmark" required/>
			<option value="True">True</option>
			<option value="False">False</option></td>
		</tr>

		<tr>
			<td>Photo Description :</td>
			<td><textarea rows="6" maxlength="100" name = "pictureDescription" placeholder="100 character maximum" style = "width: 250px;"></textarea></td>
			<!-- <td><input type="text" name="description" required/></td> -->
		</tr>
		
		<tr>
			<td colspan = "2"><input type="submit" name="register" value = "submit"></td>
		</tr>
	</table>
</form>


</body>
</html>