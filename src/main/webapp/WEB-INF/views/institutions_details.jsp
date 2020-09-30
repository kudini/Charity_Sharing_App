<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
    <a name="help"></a>
    <h2>Informacje o instytucji</h2>

    <!-- SLIDE 1 -->
    <div class="help--slides active" data-id="1">
        <p>Dodatkowe informacje</p>

        <ul class="help--slides-items">


            <li>
                <div class="col">
                    <div class="title">Fundacja: "${institution.getName()}"</div>
                    <div class="subtitle">Cel i misja: ${institution.getDescription()}</div>
                </div>
                <sec:authorize access="hasRole('ADMIN')">
                <div class="col">
                    <div class="title">
                            <a href="/institution/${institution.getId()}/edit">Edytuj</a>
                            <a href="/institution/${institution.getId()}/delete">Usuń</a>
                    </div>
                </div>
                </sec:authorize>

            </li>
        </ul>
    </div>

</section>


<jsp:include page="_misc/footer.jsp"/>

<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
