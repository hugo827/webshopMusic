<%--
  Created by IntelliJ IDEA.
  User: Me
  Date: 11/07/2022
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/importTags.jsp" %>

<html>
<head>
    <title>${title}</title>
    <link type="text/css" href="<spring:url value='/css/stylesheet.css' />" rel="stylesheet" >
    <link  type="image/icon" rel="icon" href="<spring:url value='/image/favicon.ico' />" >
    <spring:url var="localeFR"  value="">
        <spring:param name="locale" value="fr" />
    </spring:url>
    <spring:url var="localeEN"  value="">
        <spring:param name="locale" value="en" />
    </spring:url>
</head>
<body>
<div class="horizontal-navigation">
        <div class="hn-left">
            <a href="<c:url value='/home' />"><image class="logo" src="<spring:url value='/image/logo.svg' />" /></a>
             <div class="div-name-website"><a href="<c:url value='/home' />" class="name-website">WebShop Music</a></div>
        </div>
        <div class="hn-center">
            <ul>
                <a href = "<c:url value='/home'/>"> <li><spring:message code="homeLabel" /></li></a>
                <a href = "<c:url value='/aboutus'/>"> <li><spring:message code="aboutLabel" /></li></a>
            </ul>
        </div>
        <div class="hn-right">
            <div class="language">
                <a href="${localeFR}" >
                    <img  class="img-language"  alt="fr" src='<spring:url value="/image/flagFR.png" />' />
                </a>
                <a href="${localeEN}"  >
                    <img class="img-language" alt="en" src='<spring:url value="/image/flagEN.png" />' />
                </a>
            </div>
            <a href = "<c:url value="/cart"/>"><image class="logo" src="<spring:url value='/image/shopping-cart.png' />" /></a>
            <sec:authorize access="!isAuthenticated()">
            <a href = "<c:url value="/inscription"/>" class="btn"><spring:message code="signup" /></a>
            <a href = "<c:url value="/login"/>" class="btn"> <spring:message code="signin" /></a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <div class="connected">
                    <span>Bonjour ${pageContext.request.userPrincipal.principal.firstname} ${pageContext.request.userPrincipal.principal.lastname}</span>
                    <div class="connected-btn">
                        <a href = "<c:url value="/profile"/>" class="btn"> Profile</a>
                        <a href = "<c:url value="/logout"/>" class="btn"> Logout</a>
                    </div>
                </div>
            </sec:authorize>
        </div>
</div>


<div class="body-content">
    <tiles:insertAttribute name="main-content" />
</div>
</body>
</html>