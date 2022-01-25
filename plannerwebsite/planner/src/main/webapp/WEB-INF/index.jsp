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
    <script type="text/javascript" src="js/app.js"></script>
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
        <div class="deep-purple nav-wrapper s12 m6">
          <a href="/" class="brand-logo"><h5 class="flow-text">Solace in Planning</h5> </a>
          
         <ul id="nav-mobile" class="right hide-on-med-and-down">
    
            <li><a href="/account">Account</a></li>
            <li><a href="/loginreg">Login|Register</a></li>
            <li><a href="/logout">Logout</a></li>
            
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
        <div class="container hide-on-med-and-up show-on-medium-and-down">
          <ul id="nav-mobile">
          <li><a href="/account">Account</a></li>
          <li><a href="/loginreg">Login|Register</a></li>
          <li><a href="/logout">Logout</a></li>
          </ul>
        </div>
    </div>
    <div class="featured">
    <h3>Featured Planners</h3>
     <div class="carousel">
    <a class="carousel-item" href="#one!"><img class="show" src ="https://cdn.shopify.com/s/files/1/0288/6729/7366/products/2_6836ca72-f3ae-40a1-88b6-fe01520a8276_large.jpg?v=1641916943"></a>
    <a class="carousel-item" href="#two!"><img src="https://lorempixel.com/250/250/nature/2"></a>
    <a class="carousel-item" href="#three!"><img src="https://lorempixel.com/250/250/nature/3"></a>
    <a class="carousel-item" href="#four!"><img src="https://lorempixel.com/250/250/nature/4"></a>
    <a class="carousel-item" href="#five!"><img src="https://lorempixel.com/250/250/nature/5"></a>
  </div>

    </div>
    <div class="allplanners">
      <c:forEach items="${planners}" var ="planner">
        <div class="display">
        <a href="/details/${planner.id}"><img class= "show" src="${planner.img}"></a>
        <p>${planner.brand} ${planner.name}</p>
        <p>$${planner.price}</p>
        
        </div>
      </c:forEach>

    </div>
    </div>
<!--JavaScript at end of body for optimized loading-->
<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
  </body>
</html>
