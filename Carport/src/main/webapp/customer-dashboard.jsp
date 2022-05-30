<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
       <c:choose>
            <c:when test="${sessionScope.containsKey('customer')}">
                Oversigt
            </c:when>
            <c:when test="${!sessionScope.containsKey('customer')}">
                Find din ordre
            </c:when>
        </c:choose>
    </jsp:attribute>


    <jsp:body>

        <c:choose>
            <c:when test="${sessionScope.containsKey('customer') && sessionScope.containsKey('customerRequest') && sessionScope.customerRequest.status == 'pending'}">
                <div class="row border">
                    <div class="col-6 offset-3 p-3 text-center">
                        <p class="fs-5  ">Vi er stadig i gang med at behandle din ordre</p>
                        <p class="fs-5  ">Vi vender tilbage når vi har behandlet og er klar til at udgive stykliste og tegning</p>

                        <div class="d-flex justify-content-center">
                            <lottie-player src="https://assets1.lottiefiles.com/packages/lf20_wfkmlpuy.json"  background="transparent"  speed="1"  style="width: 400px; height: 400px;"  loop autoplay></lottie-player>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:when test="${sessionScope.containsKey('customer') && sessionScope.containsKey('customerRequest') && sessionScope.customerRequest.status == 'completed'}">
                <div class="row border p-3 bg-light">
                    <div class="col-6 border-end border">
                        <h3>Stykliste</h3>
                        <c:forEach items="${sessionScope.materialList}" var="line" varStatus="i">
                            <p>${line}</p>
                        </c:forEach>
                    </div>
                    <div class="col-6">
                        <h3>Skitse set oppefra</h3>
                        <div class="w-100 h-100 p-5 pt-0 d-flex justify-content-center">
                            <svg>
                                    ${sessionScope.svg}
                            </svg>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                    <div class="row border p-5 bg-light animate__animated animate__flipInX">
                        <form class="d-flex justify-content-center align-content-center p-3" action="fc/CRUDCustomerRequest" method="post">
                            <div class="col-4 d-flex flex-column gap-3">
                                <h5 class="-text">Du kan søge efter din ordre ved at indtaste din mail</h5>
                                <div class="form-floating">
                                    <input class="form-control <c:if test="${requestScope.containsKey('error')}">is-invalid</c:if>" type="email" id="customerEmail" name="customerEmail" placeholder="Email" required/>
                                    <label class="form-label" for="customerEmail">Email</label>
                                    <c:if test="${requestScope.containsKey('error') }">
                                      <div class="invalid-feedback animate__animated animate__fadeIn">
                                          ${requestScope.error}
                                      </div>
                                    </c:if>

                                    <input type="hidden" name="crud" value="read"/>
                                    <input type="hidden" name="command" value="CRUDCustomerRequest"/>
                                    <input type="hidden" name="next" value="customer-dashboard"/>
                                    <input type="hidden" value="read" id="crudRequest" name="crud"/>
                                </div>
                                <button type="submit" class="btn btn-lg btn-primary">Søg</button>
                            </div>
                        </form>
                    </div>
            </c:otherwise>
        </c:choose>

    </jsp:body>

</t:pagetemplate>
