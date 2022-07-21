<%--
  Created by IntelliJ IDEA.
  User: Me
  Date: 17/07/2022
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="cart">
        <div class="cart-line">
            <c:forEach items="${cartList}" var="c" >
                <div class="cart-line-item">
                    <image class="cart-line-item-image" src="<spring:url value='/image/default.png' />" />
                    <div class="cart-line-item-info">
                        <p>${c.getValue().getInstrument().getName()}</p>
                        <p>Categorie :${c.getValue().getInstrument().getFkCategory()}</p>
                        <p>Marque : ${c.getValue().getInstrument().getBrand().getName()}</p>
                        <div class="cart-line-item-btn">
                            <div class="cart-line-item-btn-details">
                                <a class="product-page-add-btn" href="<c:url value="/product/${c.getKey()}" />"><span class="product-page-add-btn-span">More details</span></a>
                            </div>
                            <div class="cart-line-item-btn-quantity">
                                     <span>Quantity : ${c.getValue().getQuantity()}</span>
                                    <a class="product-page-add-btn" href="<c:url value="/product/${c.getKey()}" />"><span class="product-page-add-btn-span">Update quantity</span></a>
                               </div>
                           </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="cart-paid">
            <h3>Details :</h3>
            <ul>
                <li> Total products : XXX</li>
                <li> Total price : XXX</li>
            </ul>

            <a class="product-page-add-btn" href="/"><span class="product-page-add-btn-span">Order</span></a>
        </div>
    </div>
</body>
</html>
