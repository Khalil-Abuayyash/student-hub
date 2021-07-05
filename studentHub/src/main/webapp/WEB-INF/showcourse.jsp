<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<main>
		<header>

			<h1>
				<c:out value="${course.name}" />
			</h1>

			<p>Post what you want about this course:</p>
			<form:form method="post" action="/addPost/${course.id}" modelAttribute="Post">
			
				<form:label path="text">
					<form:input path="text" />
					<form:errors path="text" />

				</form:label>
				<form:button type="submit">Post</form:button>
			</form:form>
			<section>
				<c:forEach items="${post}" var="p">
					<p>Post by</p>
					<p><c:out value="${p.text}"/></p>
					<p>comments:</p>
					<c:forEach items="${p.comments}" var="c">
						<p>${c.text}</p>
						<form:form method="post" action="/addcomment"
							modelAttribute="Comment">
							<form:label path="text">
								<form:input path="text" />
								<form:errors path="text" />

							</form:label>
							<form:button type="submit" value="post" />
						</form:form>
					</c:forEach>
				</c:forEach>




			</section>





		</header>


	</main>



</body>
</html>