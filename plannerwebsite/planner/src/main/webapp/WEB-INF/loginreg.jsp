<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="css/style.css">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
   <!--Import Google Icon Font-->
   <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <title>Document</title>
</head>
<body>
  <div class="wrapper">
  <nav>
    <div class="deep-purple nav-wrapper">
      <a href="/" class="brand-logo">Solace in Planning </a>
      
      <ul id="nav-mobile" class="right hide-on-med-and-down">

        <li><a href="/account">Account</a></li>
        <li><a href="/loginreg">Login|Register</a></li>
        
      </ul>
    </div>
  </nav>
  <div class="nav-wrapper">
    <form>
      <div class="input-field">
        <input id="search" type="search" required>
        <label class="label-icon" for="search"><i class="material-icons">search</i></label>
        <i class="material-icons">close</i>
      </div>
    </form>
    <div class="loginreg">
  <div>
  <h3>Register</h3>
  <p><form:errors path="user.*"/></p>
    
    <form:form method="POST" action="/registration" modelAttribute="user">
        <p>
        	<form:label path="userName">Name:</form:label>
            <form:input type="text" path="userName"/>
        	
        </p>
        
        <p>
            <form:label path="email">Email:</form:label>
            <form:input type="email" path="email"/>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation"/>
        </p>
        <button class="deep-purple btn waves-effect waves-light" type="submit" name="action">Register
          <i class="material-icons right">send</i>
        </button>
    </form:form>
    </div>
    <div>
    <h3>Login</h3>
    <p>${error}</p>
    <form method="post" action="/login">
    
        <p>
            <label type="email" for="email">Email</label>
            <input type="text" id="email" name="email"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <button class="deep-purple btn waves-effect waves-light" type="submit" name="action">Login
          <i class="material-icons right">send</i>
        </button>
    </form>
    </div>   
    </div> 
    </div>
</body>
</html>