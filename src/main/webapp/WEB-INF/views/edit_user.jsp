<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<sec:authentication var="user" property="principal.user" />

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header>
    <jsp:include page="_misc/panel_header.jsp"/>
</header>
<section class="login-page">
    <h2>Edytuj Profil</h2>
    <form:form method="post" modelAttribute="userDto">
        <div class="form-group">
            <form:input type="number" path="id" placeholder="Id:" disabled="true" />
        </div>
        <div class="form-group">
            <form:input type="email" path="username" placeholder="Email:" value="${user.getUsername()}"/>
        </div>
        <div class="form-group">
            <form:input type="text" path="firstName" placeholder="Imię:" value="${user.getFirstName()}"/>
        </div>
        <div class="form-group">
            <form:input type="text" path="lastName" placeholder="Nazwisko:" value="${user.getLastName()}"/>
        </div>


        <div class="form-group form-group--buttons">
            <form:button class="btn" type="submit">Zapisz Zmiany</form:button>
        </div>
    </form:form>
</section>

<jsp:include page="_misc/footer.jsp"/>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
