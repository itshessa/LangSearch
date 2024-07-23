<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
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





<div class="row">
        <div class="col-md-6 col-md-offset-3">
 <a href="/" style="width:15%"><img src="${pageContext.request.contextPath}/res/langsearchsmall.png" style="width:20%" class="img-responsive center-block"/></a>
<form  class="quiz" action = "/Answers_Test" method = "POST" >
	<div class="question">
		<h3> Choose the best word or phrase to complete the sentence.<br>...
			 was a strong wind last night. </h3>
      <input  type="radio" name="q1" value ="There" ><label>There</label><br>
      <input type="radio" name="q1" value ="Here"  ><label >Here</label><br>
      <input type="radio" name="q1" value ="This" ><label>This</label><br>
      <input type = "hidden" name ="correctAnswer1" value ="There">
	</div>
	
      	<div class="question">
      	<h3> Choose the best word or phrase to complete the sentence.<br> A lot of trains ... late today due to the heavy storms. </h3>
      <input type="radio" name="q2" value ="are run"><label>are run</label><br>
      <input type="radio" name="q2" value ="run"  ><label >run</label><br>
      <input type="radio" name="q2" value ="are running"><label>are running</label><br>
      <input type = "hidden" name ="correctAnswer2" value ="are running">
      </div>
      
      	<div class="question">
      	<h3> Some words are often used together, e.g. smelly + socks. Choose a word which is often used with:<br>concrete </h3>
      <input type="radio" name="q3" value ="builder"><label>builder</label><br>
      <input type="radio" name="q3" value ="thrill"  ><label >thrill</label><br>
      <input type="radio" name="q3" value ="proposal"><label>proposal</label><br>
      <input type = "hidden" name ="correctAnswer3" value ="builder">
      </div>
      
      	<div class="question">
      	<h3> Choose the word or phrase which has a similar meaning to:<br> consider </h3>
      <input type="radio" name="q4" value ="think about"><label>think about</label><br>
      <input type="radio" name="q4" value ="seem well"  ><label >seem well</label><br>
      <input type="radio" name="q4" value ="go for"><label>go for</label><br>
      <input type = "hidden" name ="correctAnswer4" value ="think about">
      </div>
      
      	<div class="question">
      	<h3> Choose the best word or phrase to complete the sentence.<br>I ... intending to stop smoking even before I got this bad cough. </h3>
      <input type="radio" name="q5" value ="would have been"><label>would have been</label><br>
      <input type="radio" name="q5" value ="had been"  ><label >had been</label><br>
      <input type="radio" name="q5" value ="have been"><label>have been</label><br>
      <input type = "hidden" name ="correctAnswer5" value ="have been">
      </div>
      
      	<div class="question">
      <h3> Choose the best word or phrase to complete the sentence.<br>I really don’t like this meal. ... money in the world wouldn’t get me to eat it. </h3>
      <input type="radio" name="q6" value ="Whatever"><label>Whatever</label><br>
      <input type="radio" name="q6" value ="Enough"  ><label >Enough</label><br>
      <input type="radio" name="q6" value ="All the"><label>All the</label><br>
      <input type = "hidden" name ="correctAnswer6" value ="All the">
      </div>
      
      	<div class="question">
      	<h3> Choose the best word to complete the sentence.<br>She hit her ... while she was playing football. </h3>
      <input type="radio" name="q7" value ="motor"><label>motor</label><br>
      <input type="radio" name="q7" value ="tail"  ><label >tail</label><br>
      <input type="radio" name="q7" value ="shoulder"><label>shoulder</label><br>
      <input type = "hidden" name ="correctAnswer7" value ="shoulder">
      </div>
      
      	<div class="question">
      	<h3> Choose the best word to complete the sentence.<br>The baby boy saw ... in the mirror and started to cry. </h3>
      <input type="radio" name="q8" value ="itself"><label>itself</label><br>
      <input type="radio" name="q8" value ="herself"  ><label >herself</label><br>
      <input type="radio" name="q8" value ="himself"><label>himself</label><br>
      <input type = "hidden" name ="correctAnswer8" value ="himself">
      </div>
      
      	<div class="question">
      	<h3> Choose the best word or phrase to complete the sentence.<br>
			 You ... clean your teeth twice a day to avoid having problems. </h3>
      <input type="radio" name="q1" value ="can"><label>can</label><br>
      <input type="radio" name="q1" value ="should"  ><label >should</label><br>
      <input type="radio" name="q1" value ="will"><label>will</label><br>
      <input type = "hidden" name ="correctAnswer1" value ="should">
      </div>
      <input type="submit" value ="submit" class="btn btn-primary my-1" style="background-color:blue;">
      </form>
      </div>
      </div>
      
</body>
</html>