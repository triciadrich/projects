<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="css/style.css">
     <!-- Compiled and minified CSS -->
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

     <!-- Compiled and minified JavaScript -->
     <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Planners</title>
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
    <div class="featured">
    <h3>Featured Planners</h3>
    <a href="/details/${planner.id}"><img class="featureimg" src=></a>

    </div>
    <div class="allplanners">
      <c:forEach items="${planners}" var ="planner">
        <a href="/details/${planner.id}"><img class= "show" src="${planner.img}"></a>
      </c:forEach>

    </div>
    </div>
<!--JavaScript at end of body for optimized loading-->
<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
  </body>
</html>
