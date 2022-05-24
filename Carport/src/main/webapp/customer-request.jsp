<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
        <c:choose>
            <c:when test="${sessionScope.containsKey('customer')}">
                Opdater din ordre
            </c:when>
            <c:otherwise>
                Design din Carport
            </c:otherwise>
        </c:choose>
    </jsp:attribute>


    <jsp:body>

        <div class="row justify-content-center border bg-light animate__animated animate__fadeInUp">
            <div class="col-10 col-lg-8 col-xl-6 col-xxl-6 ">
                <form class="p-5 d-flex flex-column gap-4" action="${sessionScope.containsKey('customer') ? 'fc/CRUDCustomerRequest' : 'fc/createCustomer'}" method="post">
                    <h2 class="text-center">Oplysninger om carport</h2>
                    <input type="hidden" name="crud" value="${sessionScope.containsKey('customer') ? 'update' : 'create'}"/>
                    <input type="hidden" name="command" value="${sessionScope.containsKey('customer') ? 'CRUDCustomerRequest' : 'createCustomer'}"/>
                    <input type="hidden" name="next" value="customer-dashboard"/>
                    <input type="hidden" value="${sessionScope.containsKey('customer') ? 'update' : 'create'}" id="crudRequest" name="crud"/>
                    <input type="hidden" name="status" value="${sessionScope.containsKey('customerRequest') ? sessionScope.customerRequest.status : 'pending'}"/>

                    <div class="form-floating">
                        <select class="form-select transition" id="carportWidth" name="carportWidth" aria-label="Carport bredde" aria-describedby="carportWidthHelp">
                            <option value="">Vælg bredde</option>
                            <c:forEach var="i" begin="240" end="600" step="30">
                                <option  <c:if test="${sessionScope.containsKey('customerRequest') && sessionScope.customerRequest.requestData.carportWidth == i}">selected</c:if> value="${i}">
                                        ${i} cm
                                </option>
                            </c:forEach>
                        </select>
                        <label for="carportWidth">Carport bredde</label>
                        <div id="carportWidthHelp" class="form-text">Vælg den ønskede bredde til din carport</div>
                    </div>

                    <div class="form-floating">
                        <select class="form-select transition" id="carportLength" name="carportLength" aria-label="Carport længde" aria-describedby="carportLengthHelp">
                            <option value="">Vælg længde</option>
                            <c:forEach var="i" begin="240" end="780" step="30">
                                <option  <c:if test="${sessionScope.containsKey('customerRequest') && sessionScope.customerRequest.requestData.carportLength == i}">selected</c:if> value="${i}">
                                        ${i} cm
                                </option>
                            </c:forEach>
                        </select>
                        <label for="carportLength">Carport længde</label>
                        <div id="carportLengthHelp" class="form-text">Vælg den ønskede længde til din carport</div>
                    </div>

                    <div class="form-floating">
                        <select class="form-select transition" id="roofType" name="roofType" aria-label="Tag" aria-describedby="roofTypeHelp">
                            <option value="">Vælg tag til carport</option>
                            <option <c:if test="${sessionScope.containsKey('customerRequest') && sessionScope.customerRequest.requestData.roofType == 1}">selected</c:if> value="1">Carport med fladt tag</option>
                            <option <c:if test="${sessionScope.containsKey('customerRequest') && sessionScope.customerRequest.requestData.roofType == 2}">selected</c:if> value="2" disabled aria-disabled="true">Carport med rejsning</option>
                        </select>
                        <label for="roofType">Tag</label>
                        <div id="roofTypeHelp" class="form-text">Vælg den ønskede type tag til din carport</div>
                    </div>

                    <div class="collapse <c:if test="${sessionScope.containsKey('customerRequest') && sessionScope.customerRequest.requestData.roofType == 1}">show</c:if>">
                        <div class="form-floating">
                            <select class="form-select transition" id="roofMaterial" name="roofMaterial" aria-label="Tag materiale" aria-describedby="roofMaterialHelp">
                                <option selected value="">Vælg tagtype/farve</option>
                                <option class="forFlatRoof" <c:if test="${sessionScope.containsKey('customerRequest') && sessionScope.customerRequest.requestData.roofMaterial.equals('Plasttrapezplader')}">selected</c:if> value="Plasttrapezplader">Plasttrapezplader</option>
                                <option class="forSlopedRoof" value="Betontagsten - Rød">Betontagsten - Rød</option>
                                <option class="forSlopedRoof" value="Betontagsten - Teglrød">Betontagsten - Teglrød</option>
                                <option class="forSlopedRoof" value="Betontagsten - Brun">Betontagsten - Brun</option>
                                <option class="forSlopedRoof" value="Betontagsten - Sort">Betontagsten - Sort</option>
                                <option class="forSlopedRoof" value="Eternittag B6 - Grå">Eternittag B6 - Grå</option>
                                <option class="forSlopedRoof" value="Eternittag B6 - Sort">Eternittag B6 - Sort</option>
                                <option class="forSlopedRoof" value="Eternittag B6 - Mokka (brun)">Eternittag B6 - Mokka (brun)</option>
                                <option class="forSlopedRoof" value="Eternittag B6 - Rødbrun">Eternittag B6 - Rødbrun</option>
                                <option class="forSlopedRoof" value="Eternittag B6 - Teglrød">Eternittag B6 - Teglrød</option>
                                <option class="forSlopedRoof" value="Eternittag B7 - Grå">Eternittag B7 - Grå</option>
                                <option class="forSlopedRoof" value="Eternittag B7 - Sort">Eternittag B7 - Sort</option>
                                <option class="forSlopedRoof" value="Eternittag B7 - Mokka (brun)">Eternittag B7 - Mokka (brun)</option>
                                <option class="forSlopedRoof" value="Eternittag B7 - Rødbrun">Eternittag B7 - Rødbrun</option>
                                <option class="forSlopedRoof" value="Eternittag B7 - Teglrød">Eternittag B7 - Teglrød</option>
                                <option class="forSlopedRoof" value="Eternittag B7 - Rødflammet">Eternittag B7 - Rødflammet</option>
                            </select>
                            <label for="roofType">Tag materiale</label>
                            <div id="roofMaterialHelp" class="form-text">Vælg den ønskede type tag til din carport</div>
                        </div>
                    </div>

                    <div class="collapse">
                        <div class="form-floating">
                            <select class="form-select transition" id="roofSlope" name="roofSlope" aria-label="Taghældning" aria-describedby="roofSlopeHelp">
                                <option value="">Vælg hældning på taget</option>
                                <option value="15">15 grader</option>
                                <option value="20">20 grader</option>
                                <option value="25">25 grader</option>
                                <option value="30">30 grader</option>
                                <option value="35">35 grader</option>
                                <option value="40">40 grader</option>
                                <option value="45">45 grader</option>
                            </select>
                            <label for="roofSlope">Taghældning</label>
                            <div id="roofSlopeHelp" class="form-text">Vælg den ønskede hældning på taget til din carport</div>
                        </div>
                    </div>

                    <div class="form-floating">
                        <select class="form-select transition" id="shedWanted" aria-label="Ønskes skur?" aria-describedby="shedWantedHelp">
                            <option value="1">Ja</option>
                            <option selected value="0">Nej</option>
                        </select>
                        <label for="shedWanted">Ønskes redskabsskur?</label>
                        <div id="shed-options" class="flex-column gap-3 collapse">

                            <div id="shedWantedHelp" class="form-text">NB! Der skal beregnes 15 cm tagudhæng på hver side af redskabsrummet</div>

                            <div class="form-floating mt-4 mb-4">
                                <select class="form-select transition" id="shedWidth" name="shedWidth" aria-label="Redskabsrum bredde" aria-describedby="shedWidthHelp">
                                    <option value="">Vælg bredde</option>
                                    <option value="210">210 cm</option>
                                    <option value="240">240 cm</option>
                                    <option value="270">270 cm</option>
                                    <option value="300">300 cm</option>
                                    <option value="330">330 cm</option>
                                    <option value="360">360 cm</option>
                                    <option value="390">390 cm</option>
                                    <option value="420">420 cm</option>
                                    <option value="450">450 cm</option>
                                    <option value="480">480 cm</option>
                                    <option value="510">510 cm</option>
                                    <option value="540">540 cm</option>
                                    <option value="570">570 cm</option>
                                    <option value="600">600 cm</option>
                                    <option value="630">630 cm</option>
                                    <option value="660">660 cm</option>
                                    <option value="690">690 cm</option>
                                    <option value="720">720 cm</option>
                                </select>
                                <label for="shedWidth">Redskabsrum bredde</label>
                                <div id="shedWidthHelp" class="form-text">Vælg den ønskede bredde til redskabsskuret</div>
                            </div>

                            <div class="form-floating">
                                <select class="form-select transition" id="shedLength" name="shedLength" aria-label="Redskabsskur længde" aria-describedby="shedLengthHelp">
                                    <option value="">Vælg længde</option>
                                    <option value="150">150 cm</option>
                                    <option value="180">180 cm</option>
                                    <option value="210">210 cm</option>
                                    <option value="240">240 cm</option>
                                    <option value="270">270 cm</option>
                                    <option value="300">300 cm</option>
                                    <option value="330">330 cm</option>
                                    <option value="360">360 cm</option>
                                    <option value="390">390 cm</option>
                                    <option value="420">420 cm</option>
                                    <option value="450">450 cm</option>
                                    <option value="480">480 cm</option>
                                    <option value="510">510 cm</option>
                                    <option value="540">540 cm</option>
                                    <option value="570">570 cm</option>
                                    <option value="600">600 cm</option>
                                    <option value="630">630 cm</option>
                                    <option value="660">660 cm</option>
                                    <option value="690">690 cm</option>
                                </select>
                                <label for="shedLength">Redskabsskur længde</label>
                                <div id="shedLengthHelp" class="form-text">Vælg den ønskede længde til redskabsskuret</div>
                            </div>
                        </div>
                    </div>

                    <hr>

                    <h2 class="text-center">Oplysninger om dig</h2>

                    <div class="form-floating">
                        <input class="form-control" type="email" id="customerEmail" name="customerEmail" aria-describedby="emailHelp" ${!sessionScope.containsKey('customer') ? "required" : "disabled" } <c:if test="${sessionScope.containsKey('customer')}">value="${sessionScope.customer.email}"</c:if> placeholder="Email" />
                        <label class="form-label" for="customerEmail">Email </label>
                        <div id="emailHelp" class="form-text">Du skal bruge denne email til at finde din ordre</div>
                    </div>

                    <div class="form-floating">
                        <input class="form-control" type="text" id="firstName" name="firstName" required placeholder="Fornavn(e)" <c:if test="${sessionScope.containsKey('customer')}">value="${sessionScope.customer.firstName}"</c:if> />
                        <label class="form-label" for="firstName">Fornavn(e)</label>
                    </div>

                    <div class="form-floating">
                        <input class="form-control" type="text" id="lastName" name="lastName" required placeholder="Efternavn" <c:if test="${sessionScope.containsKey('customer')}">value="${sessionScope.customer.lastName}"</c:if> />
                        <label class="form-label" for="lastName">Efternavn</label>
                    </div>

                    <div class="form-floating">
                        <input class="form-control" type="text" id="phoneNumber" name="phoneNumber" required placeholder="Telefon nummer" <c:if test="${sessionScope.containsKey('customer')}">value="${sessionScope.customer.phoneNumber}"</c:if> />
                        <label class="form-label" for="phoneNumber">Telefon nummer</label>
                    </div>

                    <div class="form-floating">
                        <input class="form-control" type="text" id="address" name="address" required placeholder="Adresse" <c:if test="${sessionScope.containsKey('customer')}">value="${sessionScope.customer.address}"</c:if> />
                        <label class="form-label" for="address">Adresse</label>
                    </div>

                    <div class="form-floating">
                        <input class="form-control" type="text" id="zipCode" name="zipCode" required placeholder="Postnummer" <c:if test="${sessionScope.containsKey('customer')}">value="${sessionScope.customer.zipCode}"</c:if> />
                        <label class="form-label" for="zipCode">Postnummer</label>
                    </div>

                    <div class="form-floating">
                        <input class="form-control" type="text" id="city" name="city" required placeholder="By" <c:if test="${sessionScope.containsKey('customer')}">value="${sessionScope.customer.city}"</c:if> />
                        <label class="form-label" for="city">By</label>
                    </div>

                    <input class="btn btn-primary btn-lg" type="submit"/>
                </form>
            </div>
        </div>

        <script>
            document.addEventListener("DOMContentLoaded", function() {
                let shedSelect = document.getElementById('shedWanted');
                let shedOptions = document.getElementById('shed-options')
                let roofType = document.getElementById('roofType')
                let roofSlope = document.getElementById('roofSlope')
                let roofMaterials = document.getElementById('roofMaterial')

                shedSelect.addEventListener('change', (e) => {
                    new bootstrap.Collapse(shedOptions)

                })

                roofType.addEventListener('change', (e) => {
                    let collapseRoofMaterials = bootstrap.Collapse.getOrCreateInstance(roofMaterials.closest('.collapse'), { toggle: false})
                    let collapseRoofSlope = bootstrap.Collapse.getOrCreateInstance(roofSlope.closest('.collapse'), { toggle: false})
                    let className = null;

                    if (e.target.value === "2") {
                        //hældning
                        className = 'forSlopedRoof';
                        if (!collapseRoofMaterials._element.classList.contains('show'))
                            collapseRoofMaterials.show()

                        if (!collapseRoofSlope._element.classList.contains('show'))
                            collapseRoofSlope.show()
                    } else if (e.target.value === "1") {
                        //fladt tag
                        className = 'forFlatRoof';
                        if (!collapseRoofMaterials._element.classList.contains('show'))
                            collapseRoofMaterials.show()

                        if (collapseRoofSlope._element.classList.contains('show'))
                            collapseRoofSlope.hide()
                    } else {
                        if (collapseRoofSlope._element.classList.contains('show'))
                            collapseRoofSlope.hide()

                        if (collapseRoofMaterials._element.classList.contains('show'))
                            collapseRoofMaterials.hide()
                    }

                    Array.from(roofMaterials.children).filter((option) => {
                        if (className !== null) {
                            if (!option.classList.contains(className)) {
                                option.classList.add('d-none')
                            } else {
                                option.classList.remove('d-none')
                            }
                        } else {
                            option.classList.add('d-none')
                        }
                    })

                })

            })
        </script>

    </jsp:body>

</t:pagetemplate>
