<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value=""/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Registration</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="NotesMain.css">
</head>

<body>



	<div class="login-container">
	<div class="login-form">
    <form method="POST" action="/registration" class="form-signin">
        <h2 class="form-heading">My Notes, create account please.</h2>

        <div class="form-group ">
            <span></span>
            <input name="username" type="text" class="login-field" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="login-field" placeholder="Password"/>
            <input name="passwordrepeat" type="password" class="login-field" placeholder="Password repeat"/>
            <input name="role" value="ROLE_USER" type="text" style="display: none;"/>
            <span></span>

            <button class="login-button" type="submit">Log In</button>
        </div>
<div class="login-message">
		<c:if test = "${not empty result}">
         <p><c:out value = "${result}"/><p>
      </c:if>




    </form>

  		</div>

	
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script></body>
</html>