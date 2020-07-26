<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>Book List</h1>
<c:if test="${!empty allProduct}">
    <table border="1" cellpadding="5" id="List of products">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allProduct}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>
                    <a href="<c:url value='/edit/${product.id}'/>">Edit</a>
                    <a href="<c:url value='/delete/${product.id}'/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>


</body>
</html>
