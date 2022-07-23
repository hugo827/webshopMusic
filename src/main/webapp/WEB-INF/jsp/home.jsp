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
    <spring:url var="categoryAll"  value="">
        <spring:param name="category" value="all" />
    </spring:url>

</head>
<body>

    <div class="categories">
        <a href="<c:url value='/home/all'/>" class="category"><spring:message code="categoryAll" /></a>
        <c:forEach items="${listCategories}" var="u" >
            <a href="<c:url value='/home/${u.getFk_category().toLowerCase()}'/>" class="category">${u.getName()}</a>
        </c:forEach>
    </div>
    <div class="product-list">
        <c:forEach items="${listInstruments}" var="var" >
            <a href="<c:url value='/product/${var.getId()}' />" class="product-list-a">
                <div class="product-show">
                    <!-- <spring:url value='/image/${var.getName().toLowerCase()}.jpg' /> -->
                    <image class="product-show-image" src="<spring:url value='/image/default.png' />" />
                    <span class="product-show-name"> ${var.getName()}</span>
                    <span class="product-show-brand"> ${var.getBrand().getName()}</span>
                    <span class="product-show-price"> ${var.getPrice()} €</span>
                </div>
            </a>
        </c:forEach>

    </div>

</body>
</html>
