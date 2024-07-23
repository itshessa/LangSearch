<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/res/stylesheet.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"><script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script><script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/res/favicon.ico">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LangSearch</title>
</head>
<body>
	<div class="Signout">
        <form action="/logout" method="post">
            <input type="submit" value="Sign Out" class="Sout"/>
        </form>
	</div>
	<div class="container">
 <a href="/home" style="width:15%"><img src="${pageContext.request.contextPath}/res/langsearchsmall.png" style="width:20%" class="img-responsive center-block"/></a>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form:form action="/edit" modelAttribute="user"
			 method="post" class="form-horizontal">
                <div class="form-group">
                    <div class="col-sm-9">
                        <form:input type="text" path="name" placeholder="Name" class="form-control" 
                        required="true"/>
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="col-sm-9">
                        <form:input  type="email" path="email" placeholder="Email" class="form-control" hidden="true"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9">
                        <form:input type="text" path="userName" placeholder="User Name" class="form-control" hidden="true"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9">
                        <form:input type="password" path="password" placeholder="Password" class="form-control" required="true"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9">
						 <form:select path="native_language" class="form-control" hidden="true">
                          	  <form:option value="" label="What language do you speak?"/>
						      <form:option value="Arabic"/>
						      <form:option value="English"/>
						</form:select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9">

						 <form:select path="targeted_language" class="form-control">
                          	  <form:option value="" label="What language do you want to learn?"/>
						      <form:option value="Arabic"/>
						      <form:option value="English"/>
						</form:select>
                    </div>
                </div>
               <div class="form-group">
                    <div class="col-sm-9">
                 		 <form:select path="level" class="form-control">
      						<form:option value="" label="Fluency Level"/>
      						<form:option value="Beginner"/>
      						<form:option value="Intermediate"/>
      						<form:option value="Expert"/>
 						 </form:select>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-9">
                        <button type="submit" class="btn btn-primary btn-block" style="background-color:blue">Edit</button>
                    </div>
                </div>

            </form:form>
        </div>
    </div>
</div>
</body>
</html>