<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
                <form:errors path="user.*"/>
                <form:form class="margin-t" method="POST" action="/registration" modelAttribute="user">

                    <div class="form-group">
                        <form:input class="form-control"  placeholder="Name" path="name"/>
                    </div>
                    <div class="form-group">
                        <form:password class="form-control" placeholder="********" path="password"/>
                    </div>
                    <div class="form-group">
                        <form:password class="form-control" placeholder="********" path="passwordConfirmation"/>
                    </div>
                    <div class="form-group">
                        <form:input type="date" class="form-control" path="birthday"/>
                    </div>
                    <div class="form-group">
                        <form:input type="email" placeholder="student@university.edu" class="form-control" path="email"/>
                    </div>
                    <div class="form-group">
                        <form:input class="form-control" placeholder="student number: 211503245" path="student_number"/>
                    </div>
                    <div class="form-group">
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
    
                    <!-- <a class="text-darkyellow" href="#"><small>Forgot your password?</small></a>
                    <p class="text-whitesmoke text-center"><small>Do not have an account?</small></p> -->
                    <a class="text-darkyellow" href="#"><small>Sign Up</small></a>
                </form:form>
                <p class="margin-t text-whitesmoke"><small> A.G.K.W &copy; 2021</small> </p>
            </div>
        </div>
</body>
</html>