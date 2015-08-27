<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Spring Chocolate Store  
</h1>

<c:forEach var="item" items="${productList} }">
	<c:out value="${item.name}"/> <br/>
</c:forEach>

</body>
</html>
