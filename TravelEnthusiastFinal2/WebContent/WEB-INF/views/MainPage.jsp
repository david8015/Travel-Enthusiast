<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.TravelEnthusiast2.Bean.*"%>
<%@page import="com.TravelEnthusiast2.DAO.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>

<style>
.active1 {
	background-color: #4CAF50;
}
</style>

</head>
<body>

	<%-- <h1> Welcome: ${userkey.userName}</h1>  --%>

	<!-- Include the header -->
	<div>
		<%@include file="header.jsp"%>
	</div>

	<!-- Search option by experience title-->
	<form action="search_Exp_By_Title" method="post"
		style="margin-right: 15px;">
		<!--           <div style = "border: 1px solid black; display:block; width: 20%; margin-top: 40px;">
 -->
		<div style="border: 1px solid black; width: 20%; margin-top: 40px;">
			<h4>Search By Experience Title:</h4>
			<div>
				<input type="text" name="title" placeholder="Search for...">
				<input type="submit" name="login" value="GO!">
			</div>
		</div>
	</form>

	<!-- Search option by user name-->
	<form action="search_Exp_By_User" method="post">
		<!--          <div style = "border: 1px solid black; display:block; width: 20%; margin-top: 40px; float: right;"> -->
		<div style="border: 1px solid black; width: 20%; margin-top: 40px;">
			<h4>Search By user name:</h4>
			<div>
				<input type="text" name="username" placeholder="Search for...">
				<input type="submit" name="login" value="GO!">
			</div>
		</div>
	</form>

	<br>
	<!-- If search yields no results print out message -->
	<h3 style="color: red;">${noEventsFound}</h3>
	<h3 style="color: red;">${noExpFound}</h3>
	<br>

    <!--Print entire experience list-->
	<c:forEach items="${expList}" var="s">
		<form action="eventpage" method="post" style="clear: both;">
			<div style="border: 1px solid black; width: 750px;">
				<img src="${s.image}" />
				<div class="card-body">
					<h2 class="card-title">${s.title}</h2>
					<p class="card-text">${s.description}</p>
				</div>
				<div class="card-footer text-muted">
				<h3> Traveled on: ${s.experienceDate}</h3>
					<h3>
						Posted on ${s.posted_date} by <span> ${s.username}</span>
					</h3>
					<a href="eventpage?title=${s.title}">READ MORE</a>
				</div>
			</div>
		</form>
		<br>
	</c:forEach>

    <!--Print experience title-->
	<c:forEach items="${expTitleList}" var="s">

		<div style="border: 1px solid black; width: 750px;">

			<img src="${s.image}" />
			<div class="card-body">
				<h2 class="card-title">${s.title}</h2>
				<p class="card-text">${s.description}</p>
			</div>
			<div class="card-footer text-muted">
				<h3> Traveled on: ${s.experienceDate}</h3>
				<h3>
					Posted on ${s.posted_date} by <span> ${s.username}</span>
				</h3>
					<a href="eventpage?title=${s.title}">READ MORE</a>
				<h1></h1>
			</div>
		</div>
		<br>
	</c:forEach>
 
    <!--Print experience list by user name-->
	<c:forEach items="${expByUser}" var="s">

		<div style="border: 1px solid black; width: 750px;">

			<img src="${s.image}" />
			<div class="card-body">
				<h2 class="card-title">${s.title}</h2>
				<p class="card-text">${s.description}</p>
			</div>
			<div class="card-footer text-muted">
				<h3> Traveled on: ${s.experienceDate}</h3>
				<h3>
					Posted on ${s.posted_date} by <span> ${s.username}</span>
				</h3>
					<a href="eventpage?title=${s.title}">READ MORE</a>
				<h1></h1>
			</div>
		</div>
		<br>
	</c:forEach>

	<%-- <p>${expList.size()}</p>
<p>${expTitleList.size()}</p>
<p>${expByUser.size()}</p> --%>

	<%-- <h2>password: ${userkey.password}</h2> --%>


</body>
</html>