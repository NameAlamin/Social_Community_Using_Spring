<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 5/30/2022
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-9">
            <form:form action="${pageContext.request.contextPath}/location/store" method="post" modelAttribute="locationDto">

                Location:
                <form:input cssClass="form-control" path="locationName"/>
                <br/>

                <button type="submit" class="btn btn-primary">Create</button>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
