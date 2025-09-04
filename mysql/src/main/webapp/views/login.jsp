<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix ="c" uri = "jakarta.tags.core" %>
<%@ taglib prefix = "fmt" uri = "jakarta.tags.fmt" %>
<%@ taglib prefix = "fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="post">

<c:if test="${alert != null}">
  <h3 class="alert alert-danger">${alert}</h3>
</c:if>

<div class="container">
  <label for="uname"><b>UserName</b></label>
  <input type="text" placeholder="Enter Username" name="uname" required>

  <label for="psw"><b>Password</b></label>
  <input type="password" placeholder="Enter Password" name="psw" required>

  <button type="submit">Login</button>
  <label>
    <input type="checkbox" name="remember"> Remember me
  </label>
</div>

<div class="container" style="background-color:#f1f1f1">
  <button type="button" class="cancelbtn">Cancel</button>
  <span class="psw">Forgot <a href="#">password?</a></span>
</div>
</form>


</body>
</html>