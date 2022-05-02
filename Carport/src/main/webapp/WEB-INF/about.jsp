<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             About
    </jsp:attribute>

    <jsp:attribute name="footer">
            About
    </jsp:attribute>

    <jsp:body>

        <h3>Her kan der stå lidt om dig</h3>

        <p><a href="../index.jsp">Til forsiden</a></p>

    </jsp:body>
</t:pagetemplate>