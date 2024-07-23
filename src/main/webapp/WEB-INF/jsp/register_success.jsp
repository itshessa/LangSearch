<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>LangSearch</title>
</head>

<body>
    <div class="container text-center">
        <h3>You have signed up successfully!</h3>
        <h4><a th:href="/@{/login}">Click here to Login</a></h4>
    </div> 
</body>
</html>