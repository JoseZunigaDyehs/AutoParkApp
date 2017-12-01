<%-- 
    Document   : estacionamientos
    Created on : 28-11-2017, 13:19:01
    Author     : jose.zuniga
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Auto Park</title>
        <jsp:include page="_css.jsp"></jsp:include>
        </head>

        <body class="d-flex">
        <jsp:include page="_header.jsp"></jsp:include>
            <main class="w-80">
                <div class="container">
                    <div class="row py-4 justify-content-center">
                        <div class="col-10">
                            <h4 class="mb-3">Estacionamientos:</h4>
                            <table class="table table-sm table-hover table-morado">
                                <thead>
                                    <tr>
                                        <th scope="col">Estacionamiento</th>
                                        <th scope="col"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="estacionamiento" items="${estacionamientos}">
                                    <tr>
                                        <th>
                                            ${estacionamiento.getNombreEstacionamiento()}
                                        </th>
                                        <td>
                                            <a href="https://www.google.cl/maps/@${estacionamiento.getLongitudEstacionamiento()},${estacionamiento.getLatitudEstacionamiento()}">Ver Más</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>

            </main>
        <jsp:include page="_js.jsp"></jsp:include>
    </body>
</html>