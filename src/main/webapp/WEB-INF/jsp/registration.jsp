<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration</title>
    <link rel="stylesheet" href="NotesMain.css">
</head>

<body>

<div class="login-container">
	<div class="login-form">
    	<form method="POST" action="/registration" class="form-signin">
        	<h2 class="form-heading">Create account please.</h2>

        	<div class="form-group ">
            
            	<input name="username" type="text" class="login-field" placeholder="Username"
                   autofocus="true"/>
            	<input name="password" type="password" class="login-field" placeholder="Password"/>
            	<input name="passwordrepeat" type="password" class="login-field" placeholder="Password repeat"/>
            	<input name="role" value="ROLE_USER" type="text" style="display: none;"/>
            	<button class="login-button" type="submit">Create</button>
        	</div>
			<div class="login-message">
				<c:if test = "${not empty result}">
         			<p><c:out value = "${result}"/><p>
      			</c:if>
			</div>
	
			<div class="form-links"><a href="login">Login</a></div>

    	</form>

  	</div>

	
</div>

</html>