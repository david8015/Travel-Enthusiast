<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Event</title>
</head>
<body>
<form method="post" action="inputEvent">
	<h2 style="color:green; text-align:center; margin-top: 40px;">ADD AN EVENT TO "EXPERIENCE TITLE"</h2>
	<table style = "border:1px solid; margin: 0 auto; text-align:center; width: 600px; height: 100%">
		<tr>
			<td>Title :</td>
			<td><input type="text" name="eventTitle" maxlength="100" placeholder="100 character maximum" autofocus required/></td>
		</tr>
		<tr>
			<td>Event Type :</td>
			<td><select name="eventType" required/>
			        <option value="Beach - Park">Beach - Park</option>
					<option value="Club - Concert">Club - Concert</option>
					<option value="Cultural - Educational">Cultural - Educational</option>
					<option value="Family - Friends">Family - Friends</option>
					<option value="Food">Food</option>
					<option value="Hotel">Hotel</option>
				</select>
				</select>
				</td>
		</tr>
		
		<tr>
			<td>Airline : </td>
			<td><input type="text" name="eventTitle" maxlength="100" placeholder="100 character maximum"/></td>
			
		</tr>
		
		
		

		<tr>
			<td>Event Date :</td>
			<td><input type="text" name="eventDate" placeholder="YYYY-MM-DD format" required/></td>
		</tr>


		<tr>
			<td>Event Description :</td>
			<td><textarea rows="6" maxlength="250" name = "eventDescription" placeholder="250 character maximum" style = "width: 250px;"></textarea></td>
			<!-- <td><input type="text" name="description" required/></td> -->
		</tr>
<!-- 		<tr>
			<td colspan = "2"><input type="submit" name="register" value = "submit"></td>
		</tr> -->
<!-- 	</table>
</form>

<form method="post" action="inputPictureInfo">
	<h2 style="color:green; text-align:center; margin-top: 40px;">ADD PICTURE INFORMATION:</h2>
	<table style = "border:1px solid; margin: 0 auto; text-align:center; width: 500px; height: 500px;"> -->
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