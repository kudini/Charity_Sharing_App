<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <div class="stats--item">
            <em>${info.getBags()}</em>

            <h3>Oddanych worków</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius est beatae, quod accusamus illum
                tempora!</p>
        </div>

        <div class="stats--item">
            <em>${info.getDonations()}</em>
            <h3>Przekazanych darów</h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laboriosam magnam, sint nihil cupiditate quas
                quam.</p>
        </div>

    </div>
</section>

<section class="help">
    <a name="help"></a>
    <h2>Lista instytucji</h2>

    <!-- SLIDE 1 -->
    <div class="help--slides active" data-id="1">
        <p>Zweryfikowane instytucje z którymi współpracujemy.</p>
        <p>
            <sec:authorize access="hasRole('ADMIN')">
                <a class="btn" href="${pageContext.request.contextPath}/institution/add">Dodaj Fundacje</a>
            </sec:authorize>
        </p>
        <ul class="help--slides-items">

            <c:forEach items="${info.getInstitutions()}" var="institution" varStatus="status">
                <c:if test="${status.count %2 == 1}">
                    <li>
                </c:if>
                <div class="col">
                    <a href="/institution/${institution.getId()}">
                        <div class="title">Fundacja: "${institution.getName()}"</div>
                        <div class="subtitle">Cel i misja: ${institution.getDescription()}</div>
                    </a>
                </div>
                <c:if test="${status.last}">
                    <c:if test="${status.index %2 == 0}">
                        <div class="col last-hide">
                        </div>
                    </c:if>
                </c:if>
                <c:if test="${status.count %2 == 0}">
                    </li>
                </c:if>
            </c:forEach>
        </ul>
    </div>

</section>


<jsp:include page="_misc/footer.jsp"/>

<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
