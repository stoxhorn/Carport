<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Login
    </jsp:attribute>

    <jsp:attribute name="footer">
            Login
    </jsp:attribute>

    <jsp:body>

       <div class="row justify-content-center align-content-center <c:if test="${!requestScope.containsKey('error')}">animate__animated animate__flipInX</c:if> ">
          <div class="col-6 p-5 border bg-light">
              <h6>Medarbejdere kan logge på her</h6>

              <form class="d-flex flex-column gap-3" action="fc/login" method="post">
                  <input type="hidden" name="command" value="login"/>

                  <div class="form-floating">
                      <input class="form-control <c:if test="${requestScope.containsKey('error')}">is-invalid animate__animated animate__shakeX</c:if>" type="email" id="email" name="email" placeholder="Email"/>
                      <label class="form-label" for="email">Email</label>
                      <c:if test="${requestScope.containsKey('error')}">
                          <div class="invalid-feedback animate__animated animate__fadeIn">
                              ${requestScope.error}
                          </div>
                      </c:if>
                  </div>

                  <div class="form-floating">
                      <input class="form-control <c:if test="${requestScope.containsKey('error')}">is-invalid animate__animated animate__shakeX</c:if>" type="password" id="password" name="password" placeholder="Kodeord"/>
                      <label class="form-label" for="password">Kodeord</label>
                      <c:if test="${requestScope.containsKey('error') }">
                          <div class="invalid-feedback animate__animated animate__fadeIn">
                              ${requestScope.error}
                          </div>
                      </c:if>
                  </div>

                  <input type="submit" class="btn btn-primary btn-lg" value="Log in"/>
              </form>
          </div>
       </div>

    </jsp:body>
</t:pagetemplate>
