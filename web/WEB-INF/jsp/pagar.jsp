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
                <c:if test="${not empty error}">
                    <h5 class="bg-warning py-2 text-center mb-0">${error}</h5>
                </c:if>
                <c:if test="${not empty exito}">
                    <h5 class="bg-success py-2 text-center mb-0 text-white">${exito}</h5>
                </c:if>
                <div class="container">
                    <form class="row py-4" method="post" action="">
                        <div class="col-8">
                            <h4>Datos Empresa</h4>
                            <div class="bg-white p-3 border my-3 box-shadow">
                                <div class="form-group d-flex align-items-center">
                                    <label class="w-25">Rut: </label>
                                    <input type="text" class="form-control"  placeholder="Ingresa rut" name="txtRut" value="${cliente.getRutCliente()}">
                                </div>
                                <div class="form-group d-flex align-items-center">
                                    <label class="w-25">Nombre:</label>
                                    <input type="text" class="form-control" placeholder="Ingresa nombre"  name="txtNombre" value="${cliente.getNombreCliente()}">
                                </div>
                                <div class="form-group d-flex align-items-center">
                                    <label class="w-25">Teléfono:</label>
                                    <input type="text" class="form-control" placeholder="Ingresa teléfono"  name="txtTelefono" value="${cliente.getTelefonoCliente()}">
                                </div>
                                <div class="form-group d-flex align-items-center">
                                    <label class="w-25">Email: </label>
                                    <input type="email" class="form-control" placeholder="Ingresa email"  name="txtEmail" value="${cliente.getEmailCliente()}">
                                </div>
                            </div>
                        </div>
                        <div class="col-4 mt-5">
                            <h4 class="mb-3">Opciones de pago</h4>
                        <c:forEach var="pago" items="${pagos}">
                            <c:choose>
                                <c:when test="${pago.getIdPago()==idOpcionPago}">
                                    <div class="form-check">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="radio" name="rbOpcionesPago" value="${pago.getIdPago()}" selected="true" checked>
                                            ${pago.getNombrePago()}
                                        </label>
                                    </div>
                                </c:when>
                                <c:when test="${pago.getIdPago()!=idOpcionPago}">
                                    <div class="form-check">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="radio" name="rbOpcionesPago" value="${pago.getIdPago()}">
                                            ${pago.getNombrePago()}
                                        </label>
                                    </div>  
                                </c:when>
                            </c:choose>      
                        </c:forEach>

                        <h4 class="mb-3 mt-3 border-top pt-2">Opciones de envío boleta</h4>
                        <c:forEach var="envio" items="${envios}">
                            <c:choose>
                                <c:when test="${envio.getIdEnvio()==idEnvio}">
                                    <div class="form-check">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="radio" name="rbEnvio" value="${envio.getIdEnvio()}" selected="true" checked>
                                            ${envio.getNombreEnvio()}
                                        </label>
                                    </div>  
                                </c:when>
                                <c:when test="${envio.getIdEnvio()!=idEnvio}">
                                    <div class="form-check">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="radio" name="rbEnvio" value="${envio.getIdEnvio()}">
                                            ${envio.getNombreEnvio()}
                                        </label>
                                    </div>  
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </div>
                    <div class="col-8">
                        <div>
                            <div class="bg-white p-3 border mb-3  d-flex flex-column box-shadow">
                                <label >Seleccione Estacionamiento, indique la cantidad de dinero que mostró aplicación móvil</label>
                                <div class="form-group d-flex align-items-center w-100 mb-0">
                                    <div class="form-group d-flex flex-column w-75">
                                        <label class="mb-0"><small>Estacionamientos: </small></label>
                                        <select class="custom-select mr-sm-2 mb-sm-0 w-100 mr-2" name="slcEstacionamiento">
                                            <option selected>Seleccione...</option>
                                        <c:forEach var="estacionamiento" items="${estacionamientos}">
                                            <option value="${estacionamiento.getIdEstacionamiento()}">${estacionamiento.getNombreEstacionamiento()}</option>
                                        </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group d-flex flex-column w-25 ml-2">
                                        <label class="mb-0"><small>Monto: </small></label>
                                        <input type="text" class="form-control" placeholder="Ingresa monto" name="txtMonto">
                                    </div>

                                </div>
                                <div class="d-flex justify-content-end">
                                    <button class="btn btn-secondary" type="submit" name="boton" value="agregar">Agregar</button>
                                </div>

                            </div>
                        </div>
                        <c:if test="${not empty estacionamientosTicket}">
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
                                <c:forEach items="${estacionamientosTicket}" var="ticket">
                                <tr>
                                    <th>${ticket.getEstacionamiento().getNombreEstacionamiento()}</th>
                                    <td>${ticket.getPrecioTicket()}</td>
                                    <td>${ticket.getIdTicket()}</td>
                                    <td>
                                        <input type="hidden" name="estacionamientoEliminar" value="${ticket.getIdTicket()}">
                                        <input type="hidden" name="rutEliminar" value="${cliente.getRutCliente()}0">
                                        <button type="submit" class=""  name="boton" value="eliminar"><i class="fa fa-minus-circle" aria-hidden="true"></i></button>

                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div class="d-flex justify-content-between px-4">
                            <h5>$ ${precioTotal}</h5>
                            <button type="submit" class="btn btn-primary" name="boton" value="">Pagar</button>
                        </div>
                        </c:if>

                    </div>
                </form>
            </div>

        </main>
        <jsp:include page="_js.jsp"></jsp:include>
    </body>
</html>