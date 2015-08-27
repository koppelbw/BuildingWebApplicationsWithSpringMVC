<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title> <spring:message code="welcome"/> </title>
	<link href="resources/css/core.css" rel="stylesheet"/>
	<jsp:include page="/WEB-INF/views/include/head-include.jsp" /> 
</head>


<body>
<div style="float:right">
	<a href="users?register"> <spring:message code="homePage.registerLink"/> </a>
</div>

<h1>
	<spring:message code="welcome"/>
</h1>

<h2> <spring:message code="featuredProducts"/> </h2>

<c:forEach var="item" items="${featuredProducts}">
	<c:out value="${item.name}"/> <br/>
</c:forEach>

<h2> <spring:message code="categories"/> </h2>
<c:forEach var="category" items="${allCategories}">
	<a href="categories/${category.id}"><c:out value="${category.name}"/> </a><br/>
</c:forEach>

</body>
</html>
