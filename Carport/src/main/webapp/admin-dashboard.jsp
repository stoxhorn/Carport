<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Admin dashboard
    </jsp:attribute>

    <jsp:body>

        <c:if test="${sessionScope.containsKey('user')}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>

            <table class="table text-center">
            <thead>
                <tr>
                    <th scope="col">Email</th>
                    <th scope="col">Status</th>
                    <th scope="col">Carport specifikation</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.CustomerRequestList}" var="customerRequest">
                <tr>
                    <td>
                        ${customerRequest.customerUserEmail}
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/fc/updateCustomerRequest?command=updateCustomerRequest&customerEmail=${customerRequest.customerUserEmail}&next=${"admin-dashboard"}">
                            <select disabled class="form-select transition" id="status" aria-label="status" aria-describedby="statusHelp">
                                <c:choose>
                                    <c:when test="${fn:contains(customerRequest.status, 'completed')}">
                                        <option>Sag afsluttet</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option>Kunden afventer</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                            <div id="statusHelp" class="form-text">Klik for at ændre status</div>
                        </a>
                    </td>
                    <td>
                       <form action="${pageContext.request.contextPath}/fc/CRUDCustomerRequest">
                           <fieldset class="d-flex flex-column gap-1" <c:if test="${fn:contains(customerRequest.status, 'completed')}">disabled</c:if>>
                           <input type="hidden" name="command" value="CRUDCustomerRequest"/>
                           <input type="hidden" name="crud" value="update"/>
                           <input type="hidden" name="status" value="${customerRequest.status != null ? customerRequest.status : "pending" }"/>
                           <input type="hidden" name="customerEmail" value="${customerRequest.customerUserEmail}"/>
                           <input type="hidden" name="next" value="admin-dashboard"/>

                           <div class="input-group my-1 col-6">
                               <span class="input-group-text" id="carportWidthHelp">Længde</span>
                               <select class="form-select transition" id="carportWidth" name="carportWidth" aria-label="Carport bredde" aria-describedby="carportWidthHelp">
                                   <c:forEach var="i" begin="240" end="600" step="30">
                                       <option  <c:if test="${customerRequest.requestData.carportWidth == i}">selected</c:if> value="${i}">
                                               ${i} cm
                                       </option>
                                   </c:forEach>
                               </select>
                           </div>

                           <div class="input-group my-1 col-6">
                               <span class="input-group-text" id="carportLengthHelp">Bredde</span>
                               <select class="form-select transition" id="carportLength" name="carportLength" aria-label="Carport længde" aria-describedby="carportLengthHelp">
                                   <option value="">Vælg længde</option>
                                   <c:forEach var="i" begin="240" end="780" step="30">
                                       <option  <c:if test="${customerRequest.requestData.carportLength == i}">selected</c:if> value="${i}">
                                               ${i} cm
                                       </option>
                                   </c:forEach>
                               </select>
                           </div>

                           <div class="input-group my-1 col-6">
                               <span class="input-group-text" id="roofTypeHelp">Tagtype</span>
                               <select class="form-select transition" id="roofType" name="roofType" aria-label="Tag" aria-describedby="roofTypeHelp">
                                   <option value="">Vælg tag til carport</option>
                                   <option <c:if test="${customerRequest.requestData.roofType == 1}">selected</c:if> value="1">Carport med fladt tag</option>
                                   <option <c:if test="${customerRequest.requestData.roofType == 2}">selected</c:if> value="2" disabled aria-disabled="true">Carport med rejsning</option>
                               </select>
                           </div>

                           <div class="input-group my-1 col-6">
                               <span class="input-group-text" id="roofMaterialHelp">Tagmateriale</span>
                               <select class="form-select transition" id="roofMaterial" name="roofMaterial" aria-label="Tag materiale" aria-describedby="roofMaterialHelp">
                                   <option selected value="">Vælg tagtype/farve</option>
                                   <option class="forFlatRoof" <c:if test="${customerRequest.requestData.roofMaterial.equals('Plasttrapezplader')}">selected</c:if> value="Plasttrapezplader">Plasttrapezplader</option>
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
                           </div>

                           <div class="input-group my-1 col-6">
                               <span class="input-group-text" id="roofSlopeHelp">Taghældning</span>
                               <select class="form-select transition" id="roofSlope" name="roofSlope" aria-label="Taghældning" aria-describedby="roofSlopeHelp">
                                <option value="">Ingen hældning</option>
                                   <c:forEach var="i" begin="15" end="45" step="5">
                                       <option  <c:if test="${customerRequest.requestData.roofSlope == i}">selected</c:if> value="${i}">
                                               ${i} grader
                                       </option>
                                   </c:forEach>
                            </select>
                           </div>

                           <div class="input-group my-1 col-6">
                               <span class="input-group-text" id="shedWidthHelp">Redskabsskur bredde</span>
                               <select class="form-select transition" id="shedWidth" name="shedWidth" aria-label="Redskabsrum bredde" aria-describedby="shedWidthHelp">
                                    <option value="">Ingen bredde</option>
                                   <c:forEach var="i" begin="210" end="720" step="30">
                                       <option  <c:if test="${customerRequest.requestData.shedWidth == i}">selected</c:if> value="${i}">
                                               ${i} cm
                                       </option>
                                   </c:forEach>
                                </select>
                           </div>

                           <div class="input-group my-1 col-6">
                               <span class="input-group-text" id="shedLengthHelp">Redskabsskur længde</span>
                               <select class="form-select transition" id="shedLength" name="shedLength" aria-label="Redskabsskur længde" aria-describedby="shedLengthHelp">
                                    <option value="">Ingen længde</option>
                                   <c:forEach var="i" begin="150" end="690" step="30">
                                       <option  <c:if test="${customerRequest.requestData.shedLength == i}">selected</c:if> value="${i}">
                                               ${i} cm
                                       </option>
                                   </c:forEach>
                                </select>
                           </div>
                            <button type="submit" class="btn btn-outline-primary">Opdater</button>
                           </fieldset>
                       </form>
                   </td>
                </tr>
            </c:forEach>
            </tbody>
            </table>
        </c:if>

        <c:if test="${!sessionScope.containsKey('user')}">
            <p>You are not logged in yet. You can do it here: <a
                    href="login.jsp">Login</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>
