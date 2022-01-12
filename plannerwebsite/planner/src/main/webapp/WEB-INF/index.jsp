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
    <title>Planners</title>
  </head>
  <body>
    <div class="wrapper">
    <div class="nav">
      <h1>Solace in Planning</h1>
      <form>
        <label for="search">Search</label>
        <input type="search" id="search" name="search" />
      </form>
      <div>
      <a href="/account">Account/Favorites</a>|
      <a href="/loginreg">Login/Signup</a>
      </div>
    
    </div>
    <div class="featured">
    <h2>Featured Planners</h2>
    <a href="/details/${planner.id}"><img class="featureimg" src="https://cdn.shopify.com/s/files/1/0288/6729/7366/products/4_c4fa2cf5-8833-4b86-8147-291127c9707a_800x800.png?v=1636945711"></a>

    </div>
    </div>

  </body>
</html>
