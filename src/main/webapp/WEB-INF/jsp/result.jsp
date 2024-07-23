<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@page import="java.util.*, com.example.demo.model.Metadata" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/res/stylesheet.css" />
<link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/res/favicon.ico">
<script src="https://cdn.jsdelivr.net/npm/handlebars@latest/dist/handlebars.js"></script>
<script src="${pageContext.request.contextPath}/WEB-INF/jsp/pagination.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LangSearch</title>
</head>
<body>

<div class="inline_tabs"><!-- 
<a class="take_test" href="/Test">Take a test</a> -->
<a class="Sign_in" href=/login>Sign In</a>
<a class="Sign_up" href="/registration">Sign Up</a>
</div>
<div class="form-inline">
<a href="/" style="width:15%"><img src="${pageContext.request.contextPath}/res/langsearchsmall.png" style="width:100%"/></a>

  <form:form  method="GET" action="1" modelAttribute="query">
  
  <form:select path="NativeLanguage" class="paar-2">
  	  <form:option value="" label="Native Language"/>
      <form:option value="Arabic"/>
      <form:option value="English"/>
  </form:select>


  <form:select path="DesiredLanguage" class="paar-3" required="required">
      <form:option value="" label="Desired Language"/>
      <form:option value="Arabic"/>
      <form:option value="English"/>
  </form:select>


  <form:select path="Skill" class="paar-4">
      <form:option value="" label="Improve This Skill"/>
      <form:option value="Course"/>
      <form:option value="Listening"/>
      <form:option value="Writing"/>
      <form:option value="Speaking"/>
      <form:option value="Reading"/>
  </form:select>


  
  <form:select path="Level" class="paar-5">
      <form:option value="" label="Fluency Level"/>
      <form:option value="Beginner"/>
      <form:option value="Intermediate"/>
      <form:option value="Expert"/>
  </form:select>


  <input type="submit" value="Search" class="paar-6">
 
</form:form>
</div>



<div class="container_" style="width: 100%">
    <!-- Table structure here -->
        <div id="table-body">
<div class="search-result-box">




<%List<Metadata>results=(LinkedList<Metadata>)request.getAttribute("searchresults");
for(Metadata m:results){%>

<div class="search-item">
<h4 class="mb-1"><a href=<%=m.getLink()%>><%=m.getTitle()%></a></h4>
<div class="font-13 text-success mb-3"><%=m.getLink()%></div>
 <p class="mb-0 text-muted"><%=m.getSnippet()%></p>
</div>

<%}%>

</div>
        </div>
</div>

<div class="container_" style="width: 100%">
    <div id="pagination-wrapper">
<%--     <%String q=request.getQueryString(); %> --%>
<nav aria-label="Search results pages">
  <ul class="pagination">
	<c:forEach var="i" begin="1" end="${totalPages}">	
		<li class="page-item"><a href="${i}?NativeLanguage=${NativeLanguage}&DesiredLanguage=${DesiredLanguage}&Skill=${Skill}&Level=${Level}" class="page-link">${i}</a></li>    	<!-- Displaying Page No -->
	</c:forEach>
  </ul>
</nav>
	</div>
    </div>


</body>
</html>