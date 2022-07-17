<%--
  Created by IntelliJ IDEA.
  User: Me
  Date: 17/07/2022
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="login">
    <form:form method="post" action="" modelAttribute="userModel" cssClass="login-form">
        <form:label path="username">Username</form:label>
        <form:input path="username" />
        <form:errors path="username" />
        <form:label path="password">Password</form:label>
        <form:input path="password" />
        <form:errors path="password" />
        <form:button>Submit</form:button>
    </form:form>
</div>
</body>
</html>
