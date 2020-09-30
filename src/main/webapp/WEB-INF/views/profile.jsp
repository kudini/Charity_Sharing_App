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
<section class="stats">
    <div class="container container--85">
    </div>
</section>
<section class="login-page">
    <h2>Profil użytkownika:</h2>
    <h1>Imię: ${user.getFirstName()}</h1>
    <h1>Nazwisko: ${user.getLastName()}</h1>
    <h1>Email: ${user.getUsername()}</h1>
<h1><a class="btn" href="/profile/edit">Edytuj</a></h1>
</section>

<jsp:include page="_misc/footer.jsp"/>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
