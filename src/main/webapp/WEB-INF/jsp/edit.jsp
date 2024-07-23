<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html  xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/res/stylesheet.css" />
<link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/res/favicon.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>LangSearch</title>
</head>
<body>

<div class="inline_tabs">
<a class="take_test" href="/Test">Take a test</a>
		<div class="Profile">
	    <form action="/profile" method="post">
            <input type="submit" value="Profile" class="Prfle"/>
        </form>
		</div>
		
	<div class="Signout">
        <form action="/logout" method="post">
            <input type="submit" value="Sign Out" class="Sout"/>
        </form>
	</div>

</div>

<a href="/home"><img src="${pageContext.request.contextPath}/res/langsearch.png" class="biglogo"/></a>
  <p><br></p>
<h3 class="Successfully" style="text-align: center; color:blue; font-famile: Sans-serif">Your Profile was successfully edited</h3>
<div class="home"><a href="/home" style="display:block; text-align:center; color:blue; font-famile: Sans-serif">Go home</a></div>

</body>
</html>