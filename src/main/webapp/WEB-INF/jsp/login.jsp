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
<div class="form">
    <form:form method="post" modelAttribute="userModel" cssClass="login-form">
        <form:label path="username" value="${usernameInscription}"><spring:message code="loginLabel" /></form:label>
        <form:input path="username" cssClass="login-input" required="required" placeholder="Enter username here"/>
        <form:errors path="username" />
        <form:label path="password"><spring:message code="passwordLabel" /></form:label>
        <form:input type="password" cssClass="login-input" path="password" required="required" placeholder="Enter password here"/>
        <form:errors path="password" />
        <form:button>Submit</form:button>
    </form:form>
    <a href="<c:url value='/inscription' />">Sign Up</a>
    <a href="<c:url value='/home' />">Cancel</a>
</div>
</body>
</html>
