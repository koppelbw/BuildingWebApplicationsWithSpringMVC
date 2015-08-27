<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/WEB-INF/views/include/head-include.jsp" /> 
<title>Register</title>
</head>
<body>

	<form:form name="input" method="post" action="users" modelAttribute="user">
	<form:errors path="name" />
	Username: <form:input type="text" path="name"/><br/>
	<form:errors path="password" />
	Password: <form:input type="text" path="password"/><br/>
	<form:errors path="email" />
	Email: <form:input type="text" path="email"/><br/>
	<form:errors path="firstName" />
	First Name: <form:input type="text" path="firstName"/><br/>
	<form:errors path="lastName" />
	Last Name: <form:input type="text" path="lastName"/><br/>
	
	<input type="submit" value="Submit">
	</form:form>
</body>
</html>