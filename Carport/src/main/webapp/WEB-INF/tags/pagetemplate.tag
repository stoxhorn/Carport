<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="da" class="h-100">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><jsp:invoke fragment="header"/></title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/animate.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
</head>
<body class="d-flex flex-column h-100">
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <div class="container">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">
                <img src="${pageContext.request.contextPath}/images/fog-logo1.svg" width="75px" class="img-fluid"/>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link"
                           href=
                            <c:choose>
                                <c:when test="${sessionScope.containsKey('user') && sessionScope.user.role == 'admin' }">
                                   "${pageContext.request.contextPath}/admin-dashboard.jsp">
                                </c:when>
                                <c:otherwise>
                                    "${pageContext.request.contextPath}/index.jsp">
                                </c:otherwise>
                            </c:choose>
                        Forside
                        </a>
                    </li>
                    <c:if test="${!sessionScope.containsKey('user')}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/customer-request.jsp">Quick-byg</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/customer-dashboard.jsp">Find ordre</a>
                    </li>
                    </c:if>
                    <c:if test="${!sessionScope.containsKey('user') && !sessionScope.containsKey('customer')}">
                        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/login.jsp">Medarbejder</a>
                    </c:if>
                    <c:if test="${sessionScope.containsKey('user') || sessionScope.containsKey('customer') }">
                        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/fc/logout?command=logout">Log out</a>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
</header>

<main id="body" class="container mt-4 mb-5">
    <h1 class="text-center mb-5"><jsp:invoke fragment="header"/></h1>
    <jsp:doBody/>
</main>

<!-- Footer -->
<footer class="footer mt-auto py-3 bg-light border-top">
    <div class="container-fluid text-center">
        <div class="row mt-4">
            <div class="col">
                Nørgaardsvej 30<br/>
                2800 Lyngby
            </div>
            <div class="col">
                <jsp:invoke fragment="footer"/><br/>
                <p>&copy; 2022 Cphbusiness</p>
            </div>
            <div class="col">
                Datamatikeruddannelsen<br/>
                2. semester forår 2022
            </div>
        </div>

    </div>
</footer>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>
