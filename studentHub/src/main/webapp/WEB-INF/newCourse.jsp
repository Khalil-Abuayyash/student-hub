
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
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
                <p class="text-whitesmoke">New Course</p>
            <div class="container-content">
                <form:form class="margin-t" method="POST" action="/courses" modelAttribute="course">
                    
                    <div class="form-group">
                        <form:errors class="text-whitesmoke" path="name"/>
                        <form:input class="form-control"  placeholder="Name" path="name"/>
                    </div>                   
                    <div class="form-group">
                        <form:errors class="text-whitesmoke" path="instructor"/>
                        <form:input class="form-control" placeholder="Instructor" path="instructor"/>
                    </div>
                    <button type="submit" class="form-button button-l margin-b">Create a Course!</button>
                    
                </form:form>
                <p class="margin-t text-whitesmoke"><small> A.G.K.W &copy; 2021</small> </p>
            </div>
        </div>
</body>
</html>