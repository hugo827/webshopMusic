<%--
  Created by IntelliJ IDEA.
  User: Me
  Date: 17/07/2022
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<sec:authorize access="isAuthenticated()">
    <html>
    <head>
        <title>Title</title>
    </head>
    <body>
    <p> you are authenticated : ${user.getUsername()}</p>
    <p>${pageContext.request.userPrincipal.principal.username}</p>
    <sec:authorize access="hasRole('ADMIN')"><a href="<spring:url value="/admin" />"> Go to admin page</a></sec:authorize>
    </body>
    </html>
</sec:authorize>