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

<jsp:include page="form_logged.jsp"/>

<section class="form--steps">
    <div class="form--steps-instructions">

        <div class="form--steps-container">

            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>
        <form:form method="post" modelAttribute="donationDto">
        <!-- STEP 1: class .active is switching steps -->
        <div data-step="1" class="active">
            <h3>Zaznacz co chcesz oddać:</h3>
            <c:forEach var="category" items="${donationmodel.getCategoryList()}">

                <div class="form-group form-group--checkbox">
                    <label>
                        <form:checkbox

                                path="categories"
                                value="${category.getId()}"
                        />
                        <span class="checkbox"></span>
                        <span class="description"
                        >${category.getName()}</span
                        >
                    </label>
                </div>

            </c:forEach>
            <div class="form-group form-group--buttons">
                <button type="button" class="btn next-step">Dalej</button>
            </div>
        </div>

        <!-- STEP 2 -->
        <div data-step="2">
            <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

            <div class="form-group form-group--inline">
                <label>
                    Liczba 60l worków:
                    <form:input id="quantity" type="number" path="quantity" step="1" min="1"/>
                </label>
            </div>

            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step">Wstecz</button>
                <button type="button" class="btn next-step">Dalej</button>
            </div>
        </div>


        <!-- STEP 4 -->
        <div data-step="3">
            <h3>Wybierz organizacje, której chcesz pomóc:</h3>

            <c:forEach var="institution" items="${donationmodel.getInstitutions()}">

                <div class="form-group form-group--checkbox" id="institutions">
                    <label>
                        <form:radiobutton path="institution" value="${institution.getId()}" />
                        <span class="checkbox radio"></span>
                        <span class="description">
                            <div class="title">Fundacja: <span id="institution-name">${institution.getName()}</span></div>
                  <div class="subtitle">
                    Cel i misja:  ${institution.getDescription()}
                  </div>
                </span>
                    </label>
                </div>

            </c:forEach>


            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step">Wstecz</button>
                <button type="button" class="btn next-step " >Dalej</button>
            </div>
        </div>

        <!-- STEP 5 -->
        <div data-step="4">
            <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

            <div class="form-section form-section--columns">
                <div class="form-section--column">
                    <h4>Adres odbioru</h4>
                    <div class="form-group form-group--inline">
                        <label> Ulica <form:input type="text" name="address" path="street"/> </label>
                    </div>

                    <div class="form-group form-group--inline">
                        <label> Miasto <form:input type="text" name="city" path="city"/> </label>
                    </div>

                    <div class="form-group form-group--inline">
                        <label>
                            Kod pocztowy <form:input type="text" name="postcode" path="zipCode"/>
                        </label>
                    </div>

                    <div class="form-group form-group--inline">
                        <label>
                            Numer telefonu <form:input type="phone" name="phone" path="phoneNumber" value="+48"/>
                        </label>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Data <form:input type="date" name="data" path="pickUpDate"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Godzina <form:input type="time" name="time" path="pickUpTime"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Uwagi dla kuriera
                                <form:textarea name="more_info" rows="5" path="pickUpComment"/>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>
        </div>
            <!-- STEP 6 -->
            <div data-step="5">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text">
                                    <span id="quantity-summary">0</span> worki <span id="categories--summary"></span> w dobrym stanie dla dzieci</span
                                >
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text "
                                >Dla fundacji "<span id="foundation-summary">Mam marzenie</span>" </span
                                >
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li><span id="address">Prosta 51</span></li>
                                <li><span id="city">Warszawa</span></li>
                                <li><span id="zip-code">Warszawa</span></li>
                                <li><span id="phone-number">Warszawa</span></li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li><span id="date">13/12/2018</span> </li>
                                <li><span id="time"></span></li>
                                <li><span id="comments">Brak uwag</span></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="form-message"></div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>
            </form:form>
        </div>
</section>

<jsp:include page="_misc/footer.jsp"/>

<script src="<c:url value="/resources/js/app.js"/>"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
</body>
</html>
