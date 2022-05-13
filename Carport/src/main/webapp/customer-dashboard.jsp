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
            <c:when test="${sessionScope.user == null}">
                    <div class="row border p-5 bg-light">
                        <form class="d-flex justify-content-center align-content-center p-3" action="/findCustomerRequest" method="post">
                            <div class="col-4">
                                <h6 class="-text">Du kan finde din ordre ved at indtaste din mail her</h6>
                                <div class="form-floating">
                                    <input class="form-control" type="email" id="customerEmail" name="customerEmail" placeholder="Email" required/>
                                    <label class="form-label" for="customerEmail">Email</label>
                                </div>
                            </div>
                        </form>
                    </div>
            </c:when>
        </c:choose>

    </jsp:body>

</t:pagetemplate>
