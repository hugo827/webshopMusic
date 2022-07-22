<%--
  Created by IntelliJ IDEA.
  User: Me
  Date: 17/07/2022
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="form">
    <form:form id="form-registration" method="post" action="/wsm/inscription/send" modelAttribute="currentUser" cssClass="Registration-form">
        <div class="registration-under">
            <form:label path="username">Username</form:label>
            <form:input path="username"  required="required" placeholder="Enter username here"/>
            <form:errors path="username" />
            <form:label path="email">Email</form:label>
            <form:input path="email"  required="required" placeholder="Enter your email here"/>
            <form:errors path="email" />
            <form:label path="password">Password</form:label>
            <form:input type="password" path="password" required="required" placeholder="Enter password here"/>
            <form:errors path="password" />
        </div>
        <div class="registration-beside">
        <form:label path="firstname">Firstname</form:label>
        <form:input path="firstname" required="required" placeholder="Enter firstname here"/>
        <form:errors path="firstname" />
        <form:label path="lastname">Lastname</form:label>
        <form:input path="lastname" required="required" placeholder="Enter lastname here"/>
        <form:errors path="lastname" />
        </div>
        <div class="registration-under">
            <form:label path="phone">Phone</form:label>
            <form:input path="phone" placeholder="Enter phone here"/>
            <form:errors path="phone" />
        </div>
       <div class="registration-beside">
           <form:label path="postcode">Post Code</form:label>
           <form:input path="postcode" required="required" placeholder="Enter postcode here"/>
           <form:errors path="postcode" />
           <form:label path="number_house">Number House</form:label>
           <form:input path="number_house" required="required" placeholder="Enter number of your house here"/>
           <form:errors path="number_house" />
       </div>
        <div class="registration-under">
            <form:label path="street">Street</form:label>
            <form:input path="street" required="required" placeholder="Enter address here"/>
            <form:errors path="street" />
            <form:label path="city">City</form:label>
            <form:input path="city" required="required" placeholder="Enter city here"/>
            <form:errors path="city" />
            <form:label path="country">Select your country</form:label>
            <form:input path="country" required="required" placeholder="Enter country here"/>
            <form:errors path="country" />
        </div>
        <form:button>Submit</form:button>
    </form:form>
    <a href="<c:url value='/login' />">Sign In</a>
    <a href="<c:url value='/home' />">Cancel</a>
</div>
</body>
</html>
