<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/res/stylesheet.css" />
<link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/res/favicon.ico">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LangSearch</title>
</head>
<body>

 <div class="container">
 <a href="/" style="width:15%"><img src="${pageContext.request.contextPath}/res/langsearchsmall.png" style="width:20%" class="img-responsive center-block"/></a>
 
    <form action="/login" method="POST" class="form-signin">
        <h3 class="form-signin-heading"></h3>
        <br/>

        <input type="email" id="email" name="email" placeholder="E-mail"
               class="form-control"/> <br/>
        <input type="password" placeholder="Password"
               id="password" name="password" class="form-control"/> <br/>
        <button class="btn btn-lg btn-primary btn-block" name="Submit" value="Login" type="Submit" style="background-color: blue">Login</button>
    </form>
</div>

</body>
</html>