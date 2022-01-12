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
  <title>Document</title>
</head>
<body>
  <h1>Welcome ${user.userName}</h1>
<h1>Add a planner</h1>
    
    <form:form method="POST" action="/addPlanner" modelAttribute="planner">
        <p>
        	<form:label path="name">Name</form:label>
        	<form:errors path="name"/>
          <form:input type="name" path="name"/>
        	
        </p>
        <p>
        	<form:label path="notes">Notes pages</form:label>
        	<form:errors path="notes"/>
          <form:input type="notes" path="notes"/>
        	
        </p>
        <p>
        	<form:label path="price">Price</form:label>
        	<form:errors path="price"/>
          <form:input type="price" path="price"/>
        	
        </p>
        <p> Planner type
           <form:select path="type">
             <option value ="daily">Daily</option>
             <option value ="weekly">Weekly</option>
             <option value ="monthly">Monthly</option>
             <option value ="all">All in one</option>
             <option value ="digital">Digital</option>
             <option value ="other">other</option>
            </form:select>
        
        </p>
        <p>
        	<form:label path="dimensions">Dimensions</form:label>
        	<form:errors path="dimensions"/>
          <form:input type="dimensions" path="dimensions"/>
        	
        </p>
        <p>
        	<form:label path="brand">Brand</form:label>
        	<form:errors path="brand"/>
          <form:input type="brand" path="brand"/>
        	
        </p>
        <p>
        	<form:label path="img">Image Url</form:label>
        	<form:errors path="img"/>
          <form:input type="img" path="img"/>
        	
        </p>
        <p>
        	<form:label path="link">Link to planner</form:label>
        	<form:errors path="link"/>
          <form:input type="link" path="link"/>
        	
        </p>
        <p>
            <form:label path="desc">Description</form:label>
            <form:errors path="desc"/>
            <form:input type="desc" path="desc"/>
        </p>

        <input type="submit" value="Submit"/>
    </form:form>



  
</body>
</html>