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
<body>
<div class="inline_tabs">
<a class="take_test" href="/Test">Take a test</a>
<a class="Sign_in" href=/login>Sign In</a>
<a class="Sign_up" href="/registration">Sign Up</a>
</div>
<img src="${pageContext.request.contextPath}/res/langsearch.png" class="biglogo"/>
  <p><br></p>
  <div class="dropdown">
  <form:form method="GET" action="search/page/1" modelAttribute="query" >
  <form:select path="NativeLanguage" class="par-1">
  	  <form:option value="" label="Native Language"/>
      <form:option value="Arabic"/>
      <form:option value="English"/>
  </form:select>

  <form:select path="DesiredLanguage" class="par-2" required="required">
      <form:option value="" label="Desired Language"/>
      <form:option value="Arabic"/>
      <form:option value="English"/>
  </form:select>

  <form:select path="Skill" class="par-3">
      <form:option value="" label="Improve This Skill"/>
      <form:option value="Course"/>
      <form:option value="Listening"/>
      <form:option value="Writing"/>
      <form:option value="Speaking"/>
      <form:option value="Reading"/>
  </form:select>

  <form:select path="Level" class="par-4">
      <form:option value="" label="Fluency Level"/>
      <form:option value="Beginner"/>
      <form:option value="Intermediate"/>
      <form:option value="Expert"/>
  </form:select>
  
  <input type="submit" value="Search" class="par-5">
</form:form>
</div>
</body>
</body>
</html>