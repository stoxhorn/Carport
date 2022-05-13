<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the frontpage
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the frontpage
    </jsp:attribute>

    <jsp:body>

        <p>Test Stuff</p>

        <form action="fc/CRUDCustomerRequestCommand" method="post">
            <input type="hidden" name="command" value="CRUDCustomerRequestCommand"/>
            <input type="hidden" name="next" value="index"/>
            <label for="crudRequest">CRUD: </label>
            <input type="text" id="crudRequest" name="crud"/>

            <label for="customerEmail">customerEmail: </label>
            <input type="text" id="customerEmail" name="customerEmail"/>

            <input type="text" id="carportWidth" name="carportWidth" value="1"/>
            <input type="text" id="carportLength" name="carportLength" value="2"/>
            <input type="text" id="roofType" name="roofType" value="3"/>
            <input type="text" id="roofMaterial" name="roofMaterial" value="4"/>
            <input type="text" id="roofSlope" name="roofSlope" value="5"/>
            <input type="text" id="shedWidth" name="shedWidth" value="6"/>
            <input type="text" id="shedLength" name="shedLength" value="7"/>

            <input type="submit"  value="command request"/>
        </form>
        <br>
        <form action="fc/CRUDMaterials" method="post">
            <input type="hidden" name="command" value="CRUDMaterials"/>
            <input type="hidden" name="next" value="index"/>

            <label for="crudMats">CRUD: </label>
            <input type="text" id="crudMats" name="crud"/>

            <label for="matID">materialsId: </label>
            <input type="text" id="matID" name="materialsId"/>

            <input type="text" id="description" name="description" value="description"/>

            <input type="submit"  value="command Materials"/>

        </form>



    </jsp:body>

</t:pagetemplate>