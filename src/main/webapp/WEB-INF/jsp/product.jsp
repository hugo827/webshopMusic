<%--
  Created by IntelliJ IDEA.
  User: Me
  Date: 17/07/2022
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="product-page">
        <div class="product-page-left">
            <div class="product-page-left-top">
                <image class="product-page-left-top-image" src="<spring:url value='/image/default.png' />" />
                <div class="product-page-left-top-info">
                    <span>${product.getName()}</span>
                    <span> Price : ${product.getPrice()} €</span>
                    <span> Marque : ${product.getBrand().getName()}</span>
                    <span> Category : ${product.getFkCategory()}</span>
                </div>
            </div>
            <div class="product-page-left-bottom">
                <h3>Details</h3>
                <p>${product.getDescription()}</p>
                <p>
                    Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum
                </p>
            </div>
        </div>
        <div class="product-page-right">
            <input placeholder="Enter number product"/>
            <a class="product-page-add-btn" href="/"><span class="product-page-add-btn-span">Add product</span></a>
        </div>
    </div>
</body>
</html>
