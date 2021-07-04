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
                <p class="text-whitesmoke">Sign up</p>
            <div class="container-content">
                <form:form class="margin-t" method="POST" action="/registration" modelAttribute="user">

                    <div class="form-group">
                        <form:errors class="text-whitesmoke" path="name"/>
                        <form:input class="form-control"  placeholder="Name" path="name"/>
                    </div>
                    <div class="form-group">
                        <form:errors class="text-whitesmoke" path="email"/>
                        <form:input type="email" placeholder="student@university.edu" class="form-control" path="email"/>
                    </div>
                    <div class="form-group">
                        <form:errors class="text-whitesmoke" path="password"/>
                        <form:password class="form-control" placeholder="********" path="password"/>
                    </div>
                    <div class="form-group">
                        <form:errors class="text-whitesmoke" path="passwordConfirmation"/>
                        <form:password class="form-control" placeholder="********" path="passwordConfirmation"/>
                    </div>
                    <div class="form-group">
                        <form:errors class="text-whitesmoke" path="birthday"/>
                        <form:input type="date" class="form-control" path="birthday"/>
                    </div>
                    <div class="form-group">
                        <form:errors class="text-whitesmoke" path="student_number"/>
                        <form:input class="form-control" placeholder="student number: 211503245" path="student_number"/>
                    </div>
                    <div class="form-group">
                        <form:errors class="text-whitesmoke" path="gender"/>
                        <form:select class="form-control" path="gender">
                            <form:option value="MALE">
                                Male
                            </form:option>
                            <form:option value="FEMALE">
                                Female
                            </form:option>
                        </form:select>
                    </div>

                    <button type="submit" class="form-button button-l margin-b">Register!</button>
                    <p class="text-whitesmoke text-center">
                        <small>Already have an account?</small>
                        <a class="text-darkyellow" href="/login"><small>Sign in</small></a>
                    </p>
                    
                </form:form>
                <p class="margin-t text-whitesmoke"><small> A.G.K.W &copy; 2021</small> </p>
            </div>
        </div>
</body>
</html>