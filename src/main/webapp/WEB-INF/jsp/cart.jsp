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
                <a href="<c:url value='/cart/remove/${c.getKey()}' /> "><image class="delete" src="<spring:url value='/image/redcross.png' />" /></a>
                <div class="cart-line-item">
                    <image class="cart-line-item-image" src="<spring:url value='/image/default.png' />" />
                    <div class="cart-line-item-info">
                        <div class="cart-line-item-info-title">
                            <span>${c.getValue().getInstrument().getName()}</span>
                        </div>
                        <div class="cart-line-item-info-cmudq">
                            <div class="cart-line-item-info-details">
                                <p>Categorie :${c.getValue().getInstrument().getFkCategory()}</p>
                                <p>Marque : ${c.getValue().getInstrument().getBrand().getName()}</p
                                <p>Unit price : ${c.getValue().getInstrument().getPrice()}</p>
                                <a class="btn-details" href="<c:url value="/product/${c.getKey()}" />"><span class="product-page-add-btn-span">More details</span></a>
                            </div>
                            <div class="cart-line-item-btn-quantity">
                                <form:form method="post" modelAttribute="productAdd" action="/wsm/cart/update/${c.getKey()}">
                                    <form:label path="quantity">Quantity</form:label>
                                    <form:input path="quantity" required="required" value="${c.getValue().getQuantity()}"/>
                                    <form:button>Update quantity</form:button>
                                </form:form>
                           </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="cart-paid">
            <h3>Details :</h3>
            <ul>
                <li> Total products : ${totalProduct}</li>
                <li> Total price : ${totalPrice}</li>
            </ul>
            <a class="product-page-add-btn" href="<c:url value='/order' />"><span class="product-page-add-btn-span">Order</span></a>
        </div>
    </div>
</body>
</html>
