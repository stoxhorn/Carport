<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Admin dashboard
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the frontpage
    </jsp:attribute>

    <jsp:body>

        <c:if test="${sessionScope.containsKey('user')}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>

            <table class="table">
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
                        <a href="${pageContext.request.contextPath}/fc/updateCustomerRequestStatus?command=updateCustomerRequestStatus&customerEmail=${customerRequest.customerUserEmail}&status=${!fn:contains(customerRequest.status, "pending") ? "pending" : "completed"}">
                            <select disabled class="form-select transition" id="status" aria-label="status" aria-describedby="statusHelp">
                                <c:choose>
                                    <c:when test="${fn:contains(customerRequest.status, 'pending')}">
                                        <option>Kunden afventer</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option>Sag afsluttet</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                            <div id="statusHelp" class="form-text">Klik for at ændre status</div>
                        </a>
                    </td>
                    <td colspan="5">
                       <form class="d-flex flex-column" action="${pageContext.request.contextPath}/fc/CRUDCustomerRequest">
                           <div class="input-group my-1 col-6">
                               <span class="input-group-text" id="carportWidthHelp">carportWidthHelp</span>
                               <input type="text" class="form-control" id="carportWidth" aria-describedby="carportWidthHelp" value="${customerRequest.requestData.carportWidth}">
                           </div>

                           <div class="input-group my-1 col-6">
                               <span class="input-group-text" id="carportLengthHelp">carportLengthHelp</span>
                               <input type="text" class="form-control" id="carportLength" aria-describedby="carportLengthHelp" value="${customerRequest.requestData.carportLength}">
                           </div>

                           <div class="input-group my-1 col-6">
                               <span class="input-group-text" id="roofTypeHelp">roofTypeHelp</span>
                               <input type="text" class="form-control" id="roofType" aria-describedby="roofTypeHelp" value="${customerRequest.requestData.roofType}">
                           </div>

                           <div class="input-group my-1 col-6">
                               <span class="input-group-text" id="roofMaterialHelp">roofMaterialHelp</span>
                               <input type="text" class="form-control" id="roofMaterial" aria-describedby="roofMaterialHelp" value="${customerRequest.requestData.roofMaterial}">
                           </div>

                           <div class="input-group my-1 col-6">
                               <span class="input-group-text" id="roofSlopeHelp">roofSlopeHelp</span>
                               <input type="text" class="form-control" id="roofSlope" aria-describedby="roofSlopeHelp" value="${customerRequest.requestData.roofSlope}">
                           </div>

                           <div class="input-group my-1 col-6">
                               <span class="input-group-text" id="shedWidthHelp">shedWidthHelp</span>
                               <input type="text" class="form-control" id="shedWidth" aria-describedby="shedWidthHelp" value="${customerRequest.requestData.shedWidth}">
                           </div>

                           <div class="input-group my-1 col-6">
                               <span class="input-group-text" id="shedLengthHelp">shedLengthHelp</span>
                               <input type="text" class="form-control" id="shedLength" aria-describedby="shedLengthHelp" value="${customerRequest.requestData.shedLength}">
                           </div>
                            <button type="submit" class="btn btn-primary">Opdater</button>
                       </form>
                   </td>
                </tr>
            </c:forEach>
            </tbody>
            </table>
            <ul>
            <c:forEach items="${sessionScope.CustomerRequestList}" var="customerRequest">
                <li>
                    ${customerRequest}
                </li>
            </c:forEach>
            </ul>

        </c:if>

        <c:if test="${!sessionScope.containsKey('user')}">
            <p>You are not logged in yet. You can do it here: <a
                    href="login.jsp">Login</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>
