<%--
  Created by IntelliJ IDEA.
  User: Me
  Date: 22/07/2022
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="identy-card">
        <p><span>Name : </span>${pageContext.request.userPrincipal.principal.firstname} ${pageContext.request.userPrincipal.principal.lastname}</p>
        <p><span>Phone :</span>${pageContext.request.userPrincipal.principal.phone}</p>
        <div><span> Address : </span>
            <ul>
                <li>${pageContext.request.userPrincipal.principal.postcode} - >${pageContext.request.userPrincipal.principal.city}</li>
                <li>${pageContext.request.userPrincipal.principal.country}</li>
                <li>${pageContext.request.userPrincipal.principal.number_house} - ${pageContext.request.userPrincipal.principal.street}</li>
            </ul>
        </div>
    </div>
    <div class="btn-ordeer">
        <a class="product-page-add-btn" href="<c:url value="/order/send" />" ><span class="product-page-add-btn-span">Confirm Order</span></a>
        <button>Modify profile</button>
    </div>
</body>
</html>
