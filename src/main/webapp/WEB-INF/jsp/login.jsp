<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login page</title>
	<link rel="stylesheet" href="NotesMain.css">
</head>

<body>

	<div class="login-container">
	<div class="login-form">
    	<form method="POST" action="/login" class="form-signin">
        	<h2 class="form-heading">My Notes</h2>
        	<div class="form-group ">
            	<input name="username" type="text" class="login-field" placeholder="Username"
                   autofocus="true"/>
            	<input name="password" type="password" class="login-field" placeholder="Password"/>
            	<button class="login-button" type="submit">Log In</button>
        	</div>
    	</form>
		
		<div class="login-message">
				<c:if test = "${not empty errorMsg}">
         			<p><c:out value = "${errorMsg}"/><p>
      			</c:if>
				<c:if test = "${not empty msg}">
         			<p><c:out value = "${msg}"/><p>
      			</c:if>
		</div>
		
		<div class="form-links"><a href="registration">Registration</a></div>
  	</div>
		
	
</div>
</html>