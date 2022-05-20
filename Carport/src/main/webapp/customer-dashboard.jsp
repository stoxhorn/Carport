<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         ${sessionScope.customer != null ? "Her er din oversigt "+sessionScope.customer.firstName : "Find din ordre"}
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the frontpage
    </jsp:attribute>

    <jsp:body>

        <c:choose>
            <c:when test="${sessionScope.customer != null}">

            </c:when>
            <c:when test="${sessionScope.customer == null}">
                    <div class="row border p-5 bg-light">
                        <form class="d-flex justify-content-center align-content-center p-3" action="fc/CRUDCustomerRequest" method="post">
                            <div class="col-4 d-flex flex-column gap-3">
                                <h5 class="-text">Du kan søge efter din ordre ved at indtaste din mail</h5>
                                <div class="form-floating">
                                    <input class="form-control" type="email" id="customerEmail" name="customerEmail" placeholder="Email" required/>
                                    <label class="form-label" for="customerEmail">Email</label>
                                    <input type="hidden" name="crud" value="read"/>
                                    <input type="hidden" name="command" value="CRUDCustomerRequest"/>
                                    <input type="hidden" name="next" value="customer-dashboard"/>
                                    <input type="hidden" value="read" id="crudRequest" name="crud"/>
                                </div>
                                <button type="submit" class="btn btn-lg btn-primary">Søg</button>
                            </div>
                        </form>
                    </div>
            </c:when>
        </c:choose>

    </jsp:body>

</t:pagetemplate>
