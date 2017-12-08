<%-- 
    Document   : boucher
    Created on : 28-11-2017, 14:57:34
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
                    <div class="row py-5 justify-content-center">
                        <div class="col-10 bg-white border pt-5 px-4 box-shadow">
                            <div class="d-flex justify-content-between">
                                <h3>BOUCHER N°</h3><h3>${boucher.getIdBoucher()}</h3>
                            </div>
                            <div class="py-4">
                                <table class="table table-sm table-hover table-morado">
                                    <thead>
                                        <tr>
                                            <th scope="col">Estacionamiento</th>
                                            <th scope="col">Monto</th>
                                            <th scope="col">N° Ticket</th>
<!--                                            <th scope="col"></th>-->
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${tickets}" var="ticket">
                                        <tr>
                                            <th>${ticket.getEstacionamiento().getNombreEstacionamiento()}</th>
                                            <td>${ticket.getPrecioTicket()}</td>
                                            <td>${ticket.getIdTicket()}</td>
<!--                                            <td>
                                                <a href="#!"><i class="fa fa-minus-circle" aria-hidden="true"></i></a>
                                            </td>-->
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                            <div class="d-flex justify-content-between">
                                <h4>TOTAL A PAGAR: </h4> <h4>$ ${boucher.getTotalBoucher()}</h4>
                            </div>
                            <div class="d-flex justify-content-between">
                                <h4>OPCIÓN DE ENVÍO: </h4> <h4>${boucher.getEnvio().getNombreEnvio()}</h4>
                            </div>
                            <div class="d-flex justify-content-between py-3 pt-5">
                                <p class="font-italic">Muchas gracias por preferirnos</p>
                            </div>
                        </div>
                    </div>
                </div>

            </main>
        <jsp:include page="_js.jsp"></jsp:include>
    </body>
</html>