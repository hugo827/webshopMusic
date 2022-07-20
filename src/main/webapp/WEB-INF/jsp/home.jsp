<%--
  Created by IntelliJ IDEA.
  User: Me
  Date: 11/07/2022
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <div class="categories">
        <a href="#" class="category">All</a>
        <c:forEach items="${listCategories}" var="u" >
            <a href="#" class="category">${u.getName()}</a>
        </c:forEach>
    </div>


</body>
</html>
