<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addPicToExp</title>

<style>

.display{
display: none;
} 

</style>
</head>
<body>

<div>
	<%@include file="header.jsp" %>
</div>

<!-- title image picture_of photo_date landmark description experience_id  -->

<form method="post" action="inputPictureInfo">
	<h2 style="color:green; text-align:center; margin-top: 40px;">ADD PICTURE INFORMATION:</h2>
	<table style = "border:1px solid; margin: 0 auto; text-align:center; width: 500px; height: 500px;">
		<tr>
			<td>Title :</td>
			<td><input type="text" name="title" maxlength="100" placeholder="100 character maximum" autofocus required/></td>
		</tr>
		<tr>
			<td>Enter Image location :</td>
			<td><input type="text" name="image" placeholder="location of image" required/></td>
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
			<td>Description :</td>
			<td><textarea rows="6" maxlength="100" name = "description" placeholder="100 character maximum" style = "width: 250px;"></textarea></td>
			<!-- <td><input type="text" name="description" required/></td> -->
		</tr>
		<tr>
			<td class = "display" name = "experience_id">${expPrimaryID}</td>
		</tr>
		
		<tr>
			<td colspan = "2"><input type="submit" name="register" value = "submit"></td>
		</tr>
	</table>
</form>






<p>${expPrimaryID}</p>
</body>
</html>