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
        <br>
        <form action="fc/createCustomer" method="post">
            <input type="hidden" name="command" value="createCustomer"/>
            <input type="hidden" name="next" value="index"/>

            <label for="crudRequest2">CRUD: </label>
            <input type="text" id="crudRequest2" name="crud"/>

            <label for="customerEmail2">customerEmail: </label>
            <input type="text" id="customerEmail2" name="customerEmail"/>


            <input type="text" id="firstName" name="firstName" value="mads"/>
            <input type="text" id="lastName" name="lastName" value="keinicke"/>
            <input type="text" id="address" name="address" value="rønnevangshusene 124"/>
            <input type="text" id="zipCode" name="zipCode" value="2630"/>
            <input type="text" id="city" name="city" value="taastrup"/>
            <input type="text" id="phone" name="phone" value="61668891"/>
            <input type="text" id="carportWidth2" name="carportWidth" value="1"/>
            <input type="text" id="carportLength2" name="carportLength" value="2"/>
            <input type="text" id="roofType2" name="roofType" value="3"/>
            <input type="text" id="roofMaterial2" name="roofMaterial" value="4"/>
            <input type="text" id="roofSlope2" name="roofSlope" value="5"/>
            <input type="text" id="shedWidth2" name="shedWidth" value="6"/>
            <input type="text" id="shedLength2" name="shedLength" value="7"/>

            <input type="submit"  value="command request"/>
        </form>
    </jsp:body>

</t:pagetemplate>
