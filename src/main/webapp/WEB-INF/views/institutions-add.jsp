<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <h2>Nazwij instytucję</h2>
    <form:form method="post" modelAttribute="institutionDto">
        <div class="form-group form-group--checkbox">
            <form:input type="number" path="id" placeholder="Id"/>
        </div>
        <div class="form-group">
            <form:input type="text" path="name" placeholder="Nazwa"/>
        </div>
        <div class="form-group">
            <form:textarea name="descript" rows="5" path="description" placeholder="Cel i misja"/>
        </div>
        <div class="form-group form-group--buttons">
            <a href="/institution" class="btn btn--without-border">Wróć</a>
            <form:button class="btn" type="submit">Dodaj</form:button>
        </div>
    </form:form>
</section>

<jsp:include page="_misc/footer.jsp"/>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
