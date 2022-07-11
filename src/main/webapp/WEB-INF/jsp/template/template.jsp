<%--
  Created by IntelliJ IDEA.
  User: Me
  Date: 11/07/2022
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
<head>
    <title>${title}</title>
    <link type="text/css" href="<spring:url value='/css/stylesheet.css' />" rel="stylesheet" >
    <link  type="image/icon" rel="icon" href="<spring:url value='/image/favicon.ico' />" >
</head>
<body>
<div>
    <div class="horizontal-navigation">
        <div class="hn-right">
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