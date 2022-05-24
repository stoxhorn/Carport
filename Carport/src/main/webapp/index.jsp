<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Johannes Fog Quick-byg tilbud
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
                    <c:if test="${!sessionScope.containsKey('user')}">
                    <a href="${pageContext.request.contextPath}/customer-request.jsp">
                        <div class="transition wrapper bg-light animate__animated animate__fadeInLeft animate__delay-05s">
                            <h3 class="fs-4 transition">
                                Design din Carport
                            </h3>
                            <svg class="h-100 mt-auto transition" viewBox="0 0 512 512">
                                <g class="" transform="translate(0,0)" style="">
                                    <path class="transition" d="M256 44.158L19.76 165.816 32 173.937l224-112 224 112 12.24-8.12L256 44.157zm0 37.904l-215 107.5V495h30V203h370v292h30V189.562l-215-107.5zM92 223v18h328v-18H92zm0 36v18h328v-18H92zm100 36c-8.5 0-14.393 5.524-18.95 11.6-4.556 6.075-8.276 13.701-11.478 22.24-4.27 11.389-7.54 24.334-9.248 36.887-8.722-2.235-22.048-4.431-24.324 2.273-2.354 6.934 7.344 13.583 16.668 18.217-.32 1.067-.63 2.17-.906 3.344C141.969 397.18 141 406.6 141 416c0 9.4.969 18.82 2.762 26.44 1.272 5.406 3.108 9.766 4.744 12.56h214.988c1.636-2.794 3.472-7.154 4.744-12.56C370.031 434.82 371 425.4 371 416c0-9.4-.969-18.82-2.762-26.44a56.768 56.768 0 0 0-.906-3.343c9.324-4.634 19.022-11.283 16.668-18.217-2.276-6.704-15.602-4.508-24.324-2.273-1.707-12.553-4.977-25.498-9.248-36.887-3.202-8.539-6.922-16.165-11.479-22.24C334.393 300.524 328.5 295 320 295H192zm0 18h128c-.5 0 1.607.476 4.55 4.4 2.944 3.925 6.224 10.299 9.022 17.76 3.673 9.795 6.488 21.437 8.028 32.414C318.195 361.125 292.18 361 256 361c-36.18 0-62.195.125-85.6 6.574 1.54-10.977 4.355-22.62 8.028-32.414 2.798-7.461 6.078-13.835 9.021-17.76 2.944-3.924 5.051-4.4 4.551-4.4zm-16 87a16 16 0 0 1 16 16 16 16 0 0 1-16 16 16 16 0 0 1-16-16 16 16 0 0 1 16-16zm160 0a16 16 0 0 1 16 16 16 16 0 0 1-16 16 16 16 0 0 1-16-16 16 16 0 0 1 16-16zm-183 73v22h30v-22h-30zm176 0v22h30v-22h-30z"
                                          fill="#003590" fill-opacity="1"></path>
                                </g>
                            </svg>
                        </div>
                    </a>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/customer-dashboard.jsp">
                        <div class="transition wrapper bg-light animate__animated animate__fadeIn<c:if test="${!sessionScope.containsKey('user')}">Right</c:if> animate__delay-05s">
                            <h3 class="fs-4 transition">
                                Find din ordre
                            </h3>
                            <svg class="h-100 my-auto transition" viewBox="0 0 211 211" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path class="transition" d="M141.766 64.2891V54.3984C141.766 53.4918 141.024 52.75 140.117 52.75H60.9922C60.0855 52.75 59.3438 53.4918 59.3438 54.3984V64.2891C59.3438 65.1957 60.0855 65.9375 60.9922 65.9375H140.117C141.024 65.9375 141.766 65.1957 141.766 64.2891ZM60.9922 82.4219C60.0855 82.4219 59.3438 83.1637 59.3438 84.0703V93.9609C59.3438 94.8676 60.0855 95.6094 60.9922 95.6094H98.9062C99.8129 95.6094 100.555 94.8676 100.555 93.9609V84.0703C100.555 83.1637 99.8129 82.4219 98.9062 82.4219H60.9922ZM90.6641 175.559H42.8594V30.4961H158.25V101.379C158.25 102.286 158.992 103.027 159.898 103.027H171.438C172.344 103.027 173.086 102.286 173.086 101.379V22.2539C173.086 18.6067 170.139 15.6602 166.492 15.6602H34.6172C30.97 15.6602 28.0234 18.6067 28.0234 22.2539V183.801C28.0234 187.448 30.97 190.395 34.6172 190.395H90.6641C91.5707 190.395 92.3125 189.653 92.3125 188.746V177.207C92.3125 176.3 91.5707 175.559 90.6641 175.559ZM182.503 186.17L163.278 166.946C167.873 160.867 170.613 153.284 170.613 145.062C170.613 125.034 154.376 108.797 134.348 108.797C114.319 108.797 98.082 125.034 98.082 145.062C98.082 165.091 114.319 181.328 134.348 181.328C141.724 181.328 148.565 179.123 154.294 175.353L173.807 194.866C174.137 195.196 174.549 195.34 174.961 195.34C175.373 195.34 175.806 195.175 176.115 194.866L182.503 188.478C182.655 188.327 182.775 188.147 182.858 187.949C182.94 187.751 182.982 187.539 182.982 187.324C182.982 187.11 182.94 186.898 182.858 186.7C182.775 186.501 182.655 186.322 182.503 186.17V186.17ZM134.348 168.141C121.593 168.141 111.27 157.817 111.27 145.062C111.27 132.308 121.593 121.984 134.348 121.984C147.102 121.984 157.426 132.308 157.426 145.062C157.426 157.817 147.102 168.141 134.348 168.141Z" fill="#003590"/>
                            </svg>
                        </div>
                    </a>
                </div>

            </div>

        <script>
            const animated = document.querySelectorAll('.animate__animated');
            console.log(animated)
            animated.forEach((element) => {
                element.addEventListener('animationend', () => {
                    element.classList.remove('animate__animated')
                })
            });
        </script>

    </jsp:body>

</t:pagetemplate>
