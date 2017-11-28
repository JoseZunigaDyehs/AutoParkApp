<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Auto Park</title>
        <jsp:include page="_css.jsp"></jsp:include>
        </head>

        <body class="d-flex index align-items-center w-100 flex-column ">

            <div class="d-flex justify-content-center w-100 align-items-center h-100 flex-column">
                
                <div class="titulo-head d-flex flex-column align-items-center justify-content-center mb-4">
                    <i class="fa fa-car" aria-hidden="true"></i>
                    <h6>AutoPark</h6>
                </div>
                
                <div class="nav-home mt-4">
                    <a href="index.htm">Inicio</a>
                    <a href="pagar.htm">Pagar</a>
                    <a href="verPagos.htm">Ver Pagos</a>
                    <a href="estacionamientos.htm">Ver Estacionamientos</a>
                </div>
                
            </div>

        <jsp:include page="_js.jsp"></jsp:include>
    </body>
</html>
