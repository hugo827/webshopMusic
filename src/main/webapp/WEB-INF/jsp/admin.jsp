<%--
  Created by IntelliJ IDEA.
  User: Me
  Date: 17/07/2022
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<sec:authorize access="hasRole('ADMIN')">
    <html>
    <head>
        <title>Title</title>
    </head>
    <body>
    <p> you are admin</p>
    </body>
    </html>
</sec:authorize>