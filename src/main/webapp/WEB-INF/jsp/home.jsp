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

<img src="${pageContext.request.contextPath}/res/langsearch.png" class="biglogo" />
  <p><br></p>
  <div class="dropdown">
  <form:form method="GET" action="searchu/page/1" modelAttribute="query" >
	<form:hidden path = "NativeLanguage" value = "${user.getNative_language()}"/>
	<form:hidden path = "DesiredLanguage" value = "${user.getTargeted_language()}"/>

  
  <form:select path="skill" class="par-3">
      <form:option value="" label="Improve This Skill"/>
      <form:option value="Course"/>
      <form:option value="Listening"/>
      <form:option value="Writing"/>
      <form:option value="Speaking"/>
      <form:option value="Reading"/>
  </form:select>
 <form:hidden path = "Level" value = "${user.getLevel()}"/>
 

  
  <input type="submit" value="Search" class="par-5">
</form:form>
</div>

</body>
</html>