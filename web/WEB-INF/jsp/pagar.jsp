<%-- 
    Document   : pagar
    Created on : 27-11-2017, 17:36:14
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
                    <form class="row py-4" method="post" action="">
                        <div class="col-8">
                            <h4>Datos Empresa</h4>
                            <div class="bg-white p-3 border my-3 box-shadow">
                                <div class="form-group d-flex align-items-center">
                                    <label class="w-25">Rut: </label>
                                    <input type="text" class="form-control"  placeholder="Ingresa rut">
                                </div>
                                <div class="form-group d-flex align-items-center">
                                    <label class="w-25">Nombre:</label>
                                    <input type="text" class="form-control" placeholder="Ingresa nombre">
                                </div>
                                <div class="form-group d-flex align-items-center">
                                    <label class="w-25">Teléfono:</label>
                                    <input type="text" class="form-control" placeholder="Ingresa teléfono">
                                </div>
                                <div class="form-group d-flex align-items-center">
                                    <label class="w-25">Email: </label>
                                    <input type="email" class="form-control" placeholder="Ingresa email">
                                </div>
                            </div>
                        </div>
                        <div class="col-4 mt-5">
                            <h4 class="mb-3">Opciones de pago</h4>
                        <c:forEach var="pago" items="${pagos}">
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="radio" name="rbOpcionesPago" value="${pago.getIdPago()}" checked>
                                    ${pago.getNombrePago()}
                                </label>
                            </div>                            
                        </c:forEach>

                        <h4 class="mb-3 mt-3 border-top pt-2">Opciones de envío boleta</h4>
                        <c:forEach var="envio" items="${envios}">
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="radio" name="rbEnvio" value="${envio.getIdEnvio()}" checked>
                                    ${envio.getNombreEnvio()}
                                </label>
                            </div>                            
                        </c:forEach>
                    </div>
                    <div class="col-8">
                        <div>
                            <div class="bg-white p-3 border mb-3  d-flex flex-column box-shadow">
                                <label >Seleccione Estacionamiento, indique la cantidad de dinero que mostró aplicación móvil</label>
                                <div class="form-group d-flex align-items-center w-100 mb-0">
                                    <div class="form-group d-flex flex-column w-75">
                                        <label class="mb-0"><small>Estacionamientos: </small></label>
                                        <select class="custom-select mr-sm-2 mb-sm-0 w-100 mr-2" id="inlineFormCustomSelect">
                                            <option selected>Seleccione...</option>
                                            <option value="1">One</option>
                                            <option value="2">Two</option>
                                            <option value="3">Three</option>
                                        </select>
                                    </div>
                                    <div class="form-group d-flex flex-column w-25 ml-2">
                                        <label class="mb-0"><small>Monto: </small></label>
                                        <input type="text" class="form-control" placeholder="Ingresa monto" name="txtMonto">
                                    </div>

                                </div>
                                <div class="d-flex justify-content-end">
                                    <a href="#!" class="btn btn-secondary"> Agregar</a>
                                </div>

                            </div>
                        </div>
                        <table class="table table-sm table-hover table-morado">
                            <thead>
                                <tr>
                                    <th scope="col">Estacionamiento</th>
                                    <th scope="col">Monto</th>
                                    <th scope="col">N° Ticket</th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th>1</th>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>
                                        <a href="#!"><i class="fa fa-minus-circle" aria-hidden="true"></i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <th>2</th>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>
                                        <a href="#!"><i class="fa fa-minus-circle" aria-hidden="true"></i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <th>3</th>
                                    <td colspan="2">Larry the Bird</td>
                                    <td>
                                        <a href="#!"><i class="fa fa-minus-circle" aria-hidden="true"></i></a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="d-flex justify-content-between px-4">
                            <h5>$ 7.000</h5>
                            <button type="submit" class="btn btn-primary">Pagar</button>
                        </div>


                    </div>
                </form>
            </div>

        </main>
        <jsp:include page="_js.jsp"></jsp:include>
    </body>
</html>