<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

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
 <script>
  $(document).ready(function() {
     $('select').material_select();
  });
</script>
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
<h3>Welcome, ${user.userName}</h3>
<h4>Add a Planner</h4>
    
    <form:form method="POST" action="/addPlanner" modelAttribute="planner">
        <p>
        	<form:label path="name">Name</form:label>
        	<form:errors path="name"/>  
          <form:input type="text" path="name"/>
        	
        </p>
        <p>
        	<form:label path="notes">Notes pages</form:label>
        	<form:errors path="notes"/>
          <form:input type="text" path="notes"/>
        	
        </p>
        <p>
        	<form:label path="price">Price</form:label>
        	<form:errors path="price"/>
          <form:input type="text" path="price"/>
        	
        </p>
      

           <select class="browser-default" path ="type">
             <option value="" disabled selected>Choose a type</option>
             <option value ="daily">Daily</option>
             <option value ="weekly">Weekly</option>
             <option value ="monthly">Monthly</option>
             <option value ="all">All in one</option>
             <option value ="digital">Digital</option>
             <option value ="other">other</option>
            </select>
        <label>Type</label>
      
        <p>
        	<form:label path="dimensions">Dimensions</form:label>
        	<form:errors path="dimensions"/>
          <form:input type="text" path="dimensions"/>
        	
        </p>
        <p>
        	<form:label path="brand">Brand</form:label>
        	<form:errors path="brand"/>
          <form:input type="text" path="brand"/>
        	
        </p>
        <p>
        	<form:label path="img">Image Url</form:label>
        	<form:errors path="img"/>
          <form:input type="text" path="img"/>
        	
        </p>
        <p>
        	<form:label path="link">Link to planner</form:label>
        	<form:errors path="link"/>
          <form:input type="text" path="link"/>
        	
        </p>
        <p>
            <form:label path="description">Description</form:label>
            <form:errors path="description"/>
            <form:input type="text" path="description"/>
        </p>

        <button class="deep-purple btn waves-effect waves-light" type="submit" name="action">Submit
          <i class="material-icons right">send</i>
    </form:form>
  


</div>
</body>
</html>