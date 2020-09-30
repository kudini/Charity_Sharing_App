<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="user" property="principal" />
<ul class="nav--actions">
    <li class="logged-user">
        Witaj ${user.getUser().getFirstName()}
        <ul class="dropdown">
            <li><a href="${pageContext.request.contextPath}/profile/${user.getUser().getId()}">Profil</a></li>
            <li><a href="${pageContext.request.contextPath}/donations/${user.getUser().getId()}">Moje zbiórki</a></li>
            <li><a href="${pageContext.request.contextPath}/donate">Oddaj Rzeczy</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Wyloguj</a></li>
        </ul>
    </li>
</ul>