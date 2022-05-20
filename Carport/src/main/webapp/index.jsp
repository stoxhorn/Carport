<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Johannes Fog Quick-byg tilbud
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the frontpage
    </jsp:attribute>

    <jsp:body>



            <div class="row justify-content-center ">
                <div class="col-md-8 mb-3 animate__animated animate__fadeIn">
                    <p>
                        Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på en carport
                        indenfor vores standardprogram, der tilpasses dine specifikke ønsker.
                        <br>
                        <br>
                        Tilbud og skitsetegning fremsendes med post hurtigst muligt.
                        Ved bestilling medfølger standardbyggevejledning.
                    </p>
                </div>
                <div class="col-md-10 text-center text-uppercase d-flex justify-content-evenly">
                    <c:if test="${sessionScope.user == null }">
                    <a href="customer-request.jsp">
                        <div class="wrapper bg-light animate__animated animate__fadeInLeft animate__delay-05s">
                            <h3>
                                Design din Carport
                            </h3>
                            <img class="img-fluid mt-auto" src="images/home-garage.svg" alt="">
                        </div>
                    </a>
                    </c:if>
                    <a href="customer-dashboard.jsp">
                        <div class="wrapper bg-light animate__animated animate__fadeInRight animate__delay-05s">
                            <h3>
                                Find din ordre
                            </h3>
                            <img class="img-fluid mt-auto" src="images/find-request.svg" alt="">
                        </div>
                    </a>
                </div>

            </div>

    </jsp:body>

</t:pagetemplate>
