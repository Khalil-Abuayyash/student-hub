<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="/css/login.css">
</head>
<body class="main-bg">
    <div class="login-container text-c animated flipInX">
            <div>
                <h1 class="logo-badge text-whitesmoke"><span class="fa fa-user-circle"></span></h1>
            </div>
                <h3 class="text-whitesmoke">Student-Hub</h3>
                <p class="text-whitesmoke">Sign In</p>
            <div class="container-content">
                <c:if test="${logoutMessage != null}">
                    <c:out value="${logoutMessage}"></c:out>
                </c:if>
                <h1>Login</h1>
                <c:if test="${errorMessage != null}">
                    <c:out value="${errorMessage}"></c:out>
                </c:if>
                <form class="margin-t" method="POST" action="/login">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Username" required="" name="username">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="*****" required="" name="password">
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit" class="form-button button-l margin-b">Sign In</button>
    
                    <a class="text-darkyellow" href="#"><small>Forgot your password?</small></a>
                    <p class="text-whitesmoke text-center">
                        <small>Do not have an account?</small>
                        <a class="text-darkyellow" href="/registration"><small>Sign Up</small></a>
                    </p>
                    
                </form>
                <p class="margin-t text-whitesmoke"><small> Your Name &copy; 2018</small> </p>
            </div>
        </div>
</body>
</html>