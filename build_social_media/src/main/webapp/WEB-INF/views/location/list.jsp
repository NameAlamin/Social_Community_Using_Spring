<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 5/30/2022
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Location List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>

<table class="table table-bordered">
    <thead class="thead">
    <tr>
        <th class="th">Id</th>
        <th class="th">Location Name</th>
    </tr>
    </thead>
    <tbody class="tbody">
    <c:forEach var="location" items="${locationList}">
        <tr>
            <td class="td">${location.getId()}</td>
            <td class="td">${location.getLocationName()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
