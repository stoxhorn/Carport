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

       <div class="row justify-content-center align-content-center">
          <div class="col-6 p-5 border bg-light">
              <h6>Medarbejdere kan logge på her</h6>

              <form class="d-flex flex-column gap-3" action="fc/login" method="post">
                  <input type="hidden" name="command" value="login"/>

                  <div class="form-floating">
                      <input class="form-control" type="email" id="email" name="email" placeholder="Email"/>
                      <label class="form-label" for="email">Email</label>
                  </div>

                  <div class="form-floating">
                      <input class="form-control" type="password" id="password" name="password" placeholder="Password"/>
                      <label class="form-label" for="password">Password</label>
                  </div>

                  <input type="submit" class="btn btn-primary btn-lg" value="Log in"/>
              </form>
          </div>
       </div>

    </jsp:body>
</t:pagetemplate>
