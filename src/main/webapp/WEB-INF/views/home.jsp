<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title> <spring:message code="welcome"/> </title>
	<jsp:include page="/WEB-INF/views/include/head-include.jsp" /> 
</head>
<body>

<div class="container">
	<div style="float:right; margin-top:-30px">
		<c:choose>
			<c:when test = "${empty loggedInUser.name}">
				<a href = "users?register"><spring:message code="homePage.registerLink"/></a>
				<a href = "login">Login</a>
			</c:when>
			<c:otherwise>
				Hello ${loggedInUser.firstName}! &nbsp;
				<a href = "logout">Logout</a>
			</c:otherwise>
		</c:choose>
	</div>
	<h1><spring:message code = "welcome"/></h1>

	<h2><spring:message code="featuredProducts"/></h2>
	
	<c:forEach var="item" items="${featuredProducts}">
		<c:out value="${item.name}"/> &nbsp; <a href="cart/add/${item.id}">Add to cart</a> <br/>
	</c:forEach>

	<h2> <spring:message code="categories"/> </h2>
	<c:forEach var="category" items="${allCategories}">
		<a href="categories/${category.id}"><c:out value="${category.name}"/></a> <br/>
	</c:forEach>	
		
</div>
</body>
</html>