<%--
  Created by IntelliJ IDEA.
  User: Me
  Date: 11/07/2022
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

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
<div>
    <div class="horizontal-navigation">
        <div class="hn-right">
            <div class="language">
                <a href="${localeFR}" >
                    <img  class="img-language"  alt="fr" src='<spring:url value="/image/flagFR.png" />' />
                </a>
                <a href="${localeEN}"  >
                    <img class="img-language" alt="en" src='<spring:url value="/image/flagEN.png" />' />
                </a>
            </div>
            <button class="btn">Inscription</button>
            <button class="btn" >Connexion</button>
        </div>
    </div>
    <div class="vertical-navigation">
        <image class="logo" src="<spring:url value='/image/logo.svg' />" />
    </div>
</div>
<div class="body-content">
    <tiles:insertAttribute name="main-content" />
</div>
</body>
</html>