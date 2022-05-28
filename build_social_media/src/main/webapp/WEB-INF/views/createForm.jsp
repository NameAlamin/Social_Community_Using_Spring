<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 5/20/2022
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>--%>
<%--<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>

<html>
<head>
    <title>Form</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/successMsg" method="post" modelAttribute="student">
    <h2>Create Student Form</h2>
    Name:
    <form:input path="studentName"/><br>
    Section:
    <form:select path="studentSection">
        <form:option value="Select Your Section" selected="true"/>
        <form:options items="${sectionList}"/>
    </form:select><br>
    <button type="submit">Submit</button>
</form:form>
</body>
</html>
