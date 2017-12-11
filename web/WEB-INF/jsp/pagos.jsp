<%-- 
    Document   : pagos
    Created on : 28-11-2017, 12:15:29
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
                <c:if test="${not empty errores}">
                    <div class="bg-danger py-2 text-center mb-0">
                    <c:forEach items="${errores}" var="err">
                        <h6 class="text-white mb-0">${err}</h6>
                    </c:forEach>
                        </div>
                </c:if>
                <c:if test="${not empty error}">
                    <h5 class="bg-warning py-2 text-center mb-0">${error}</h5>
                </c:if>
                <div class="container">
                    <div class="row py-4 justify-content-center">
                        <form method="post" action="" class="col-10">
                                <h4>Buscar Pagos</h4>
                                <div class="bg-white p-3 border my-3 box-shadow">
                                    <div class="form-group d-flex align-items-center">
                                        <label class="mr-3">Rut: </label>
                                        <input type="text" class="form-control mr-3"  placeholder="Ingresa rut" name="txtRut">
                                        <button type="submit" class="px-3 btn btn-primary">Buscar</button>
                                    </div>
                                </div>
                        </form>
                    <c:if test="${not empty bouchers}">
                        <div class="col-10">
                            <h4 class="mb-3">Pagos encontrados:</h4>
                            <table class="table table-sm table-hover table-morado">
                                <thead>
                                    <tr>
                                        <th scope="col">Estacionamiento</th>
                                        <th scope="col">Total</th>
                                        <th scope="col">Pedir</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${bouchers}" var="boucher">
                                    <tr>
                                        <th>
                                            <c:forEach items="${tickets}" var="ticket">
                                                <c:if test="${ticket.getIdBoucher() == boucher.getIdBoucher()}">
                                                    ${ticket.getEstacionamiento().getNombreEstacionamiento()} - 
                                                </c:if>
                                            </c:forEach>
                                            
                                        </th>
                                        <td>$ ${boucher.getTotalBoucher()}</td>
                                        <td>
                                            <a href="boucher.htm?boucher=${boucher.getIdBoucher()}"><i class="fa fa-plus-circle" aria-hidden="true"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        
                    </c:if>
                       
                    </div>

                </div>

            </main>
        <jsp:include page="_js.jsp"></jsp:include>
    </body>
</html>
