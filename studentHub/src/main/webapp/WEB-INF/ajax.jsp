<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<TITLE>Crunchify - Spring MVC Example with AJAX call</TITLE>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
    function crunchifyAjax() {
        $.ajax({
            url : '/ajaxtest',
            success : function(data) {
                $('#result').html(data);
            }
        });
    }
</script>
 
<script type="text/javascript">
    var intervalId = 0;
    intervalId = setInterval(crunchifyAjax, 3000);
</script>
</head>
 
<body>
    <div align="center">
        <br> <br> ${message} <br> <br>
        <div id="result"></div>
        <br>
        <p>
            by <a href="https://crunchify.com">Crunchify.com</a>
        </p>
    </div>
</body>
</html>