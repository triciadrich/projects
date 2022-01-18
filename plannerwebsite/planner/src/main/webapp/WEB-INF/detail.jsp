<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
 <script type="text/javascript" src="js/app.js"></script>
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
  </div>  


  <div class="container">
  <img class="detailimg" src="${planner.img}"/>
  <ul>
    <li>${planner.name}</li>
    <li>${planner.type}</li>
    <li>${planner.brand}</li>
    <li>${planner.notes}</li>
    <li>${planner.price}</li>
    <li>${planner.dimensions}</li>
    <li>${planner.description}</li>
 <li><c:choose>
    <c:when test="${user.id == planner.getUser().getId()}">
      <a href="/edit/{id}">Edit</a>
    </c:when>
 </c:choose></li>
  </ul>

  </div>
</div>
  </div>
</body>
</html>