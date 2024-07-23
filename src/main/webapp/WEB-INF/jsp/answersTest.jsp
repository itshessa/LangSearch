<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Random"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/res/stylesheet.css" />
<link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/res/favicon.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LangSearch</title>
</head>
<body>
<a href="/home"><img src="${pageContext.request.contextPath}/res/langsearch.png" style="width:70%; display: block; margin-left: auto; margin-right: auto;"/></a>
<h1 style="font-size:200; text-align:center">Your Level is</h1>
<% int score=0; %>


<%if(request.getParameter("q1").equals(request.getParameter("correctAnswer1")))
		score++;
%>

<%if(request.getParameter("q2").equals(request.getParameter("correctAnswer2")))
	score++;
%>

<%if(request.getParameter("q3").equals(request.getParameter("correctAnswer3")))
	score++;
%>

<%if(request.getParameter("q4").equals(request.getParameter("correctAnswer4")))
	score++;
%>

<%if(request.getParameter("q5").equals(request.getParameter("correctAnswer5")))
	score++;
%>

<%if(request.getParameter("q6").equals(request.getParameter("correctAnswer6")))
	score++;
%>

<%if(request.getParameter("q7").equals(request.getParameter("correctAnswer7")))
	score++;
%>

<%if(request.getParameter("q7").equals(request.getParameter("correctAnswer7")))
	score++;
%>

<%if(request.getParameter("q8").equals(request.getParameter("correctAnswer8")))
	score++;
%>

<% if (score <= 3){%>
<h2 style="color:#1E90FF; size:100; text-align:center">Beginner</h2>
<%
	} else if (score >= 4 && score <= 7){%>
<h2 style="color:#1E90FF; size:100; text-align:center">Intermediate</h2>
<%
} else if (score >= 8){%>
<h2 style="color:#1E90FF; size:100; text-align:center">Expert</h2>

<%}%>




</body>
</html>