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
                    <c:if test="${c.getValue().getInstrument().getDiscount() != null}"><div class="promotion"><span>-</span> ${c.getValue().getInstrument().getDiscount().getPercentageDiscount() * 100}%</div></c:if>
                    <image class="cart-line-item-image" src="<spring:url value='/image/default.png' />" />
                    <div class="cart-line-item-info">
                        <div class="cart-line-item-info-title">
                            <span>${c.getValue().getInstrument().getName()}</span>
                        </div>
                        <div class="cart-line-item-info-cmudq">
                            <div class="cart-line-item-info-details">
                                <p><spring:message code="categoryLabel" /> :${c.getValue().getInstrument().getFkCategory()}</p>
                                <p><spring:message code="brandLabel" /> ${c.getValue().getInstrument().getBrand().getName()}</p
                                <p><spring:message code="unitPriceLabel" /> : <c:choose>
                                    <c:when test="${c.getValue().getInstrument().getDiscount() == null}">
                                        ${c.getValue().getInstrument().getPrice()}
                                    </c:when>
                                    <c:otherwise>
                                        <span class="reduc-price"> ${c.getValue().getInstrument().getPrice()} €</span> <span class="reduc-price-calc"> ${c.getValue().getInstrument().getPrice() * (1-c.getValue().getInstrument().getDiscount().getPercentageDiscount())} €</span>
                                    </c:otherwise>
                                </c:choose></p>
                                <a class="btn-details" href="<c:url value="/product/${c.getKey()}" />"><span class="product-page-add-btn-span">More details</span></a>
                            </div>
                            <div class="cart-line-item-btn-quantity">
                                <form:form method="post" modelAttribute="productAdd" action="/wsm/cart/update/${c.getKey()}">
                                    <form:label path="quantity"><spring:message code="quantityLabel" /></form:label>
                                    <form:input path="quantity" required="required" value="${c.getValue().getQuantity()}"/>
                                    <form:button><spring:message code="quantityUpdateButton" /></form:button>
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
                <li> <spring:message code="totalproduct" /> : ${totalProduct}</li>
                <li> <spring:message code="totalprice" /> ${totalPrice}</li>
                <li> <spring:message code="totalReduc" /> ${totalReduc}</li>
                <li> Total a payer : ${total}</li>
            </ul>
            <a class="product-page-add-btn" href="<c:url value='/order' />"><span class="product-page-add-btn-span">Order</span></a>
        </div>
    </div>
</body>
</html>
