<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <th>Email</th>
                    <th>Status</th>
                    <th>Carport specifikation</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.CustomerRequestList}" var="customerRequest">
                <tr>
                    <td>${customerRequest.customerUserEmail}</td>
                    <td>
                        <select class="form-select transition" id="shedWanted" aria-label="status" aria-describedby="shedWantedHelp">
                            <option <c:if test="${customerRequest.status.equals('pending')}">selected</c:if> value="pending">Kunden afventer</option>
                            <option <c:if test="${customerRequest.status.equals('completed')}">selected</c:if> value="completed">Sag afsluttet</option>
                        </select>
                    </td>
                   <td>
                       <div class="d-flex">
                           <ul>
                               ${customerRequest.requestData}
                           </ul>
                           <a href="customer-request.jsp">
                               Ændre ordre
                           </a>
                       </div>
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
