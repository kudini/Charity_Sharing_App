<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="user" property="principal" />
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
<header class="header">
<jsp:include page="_misc/panel_header.jsp"/>
</header>

<section class="stats">
    <div class="container container--85">


    </div>
</section>
<section class="help">
    <ul class="help--slides-items">
        <li>
            <div class="col">
                <div class="title">Imię: </div>
            </div>
            <div class="col">
                <div class="title">Nazwisko: </div>
            </div>
            <div class="col">
                <div class="title">Akcje: </div>
            </div>
        </li>
        <c:forEach items="${admins}" var="admin" varStatus="status">
            <li>

                <div class="col">
                    <div class="title">${admin.getFirstName()} </div>
                </div>
                <div class="col">
                    <div class="title">${admin.getLastName()} </div>
                </div>
                <div class="col">
                    <div class="title">
                        <a class="btn" href="/admin/${admin.getId()}/delete">Usuń</a>
                        <a class="btn" href="/admin/${admin.getId()}/edit">Edycja</a>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>


</section>


<jsp:include page="_misc/footer.jsp"/>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
