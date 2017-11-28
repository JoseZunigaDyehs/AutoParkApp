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
                <div class="container">
                    <div class="row py-4">
                        <form method="post" action="" class="col-12">
                                <h4>Buscar Pagos</h4>
                                <div class="bg-white p-3 border my-3">
                                    <div class="form-group d-flex align-items-center">
                                        <label class="mr-3">Rut: </label>
                                        <input type="text" class="form-control mr-3"  placeholder="Ingresa rut">
                                        <button type="submit" class="px-3 btn btn-primary">Buscar</button>
                                    </div>
                                </div>
                        </form>
                        <div class="col-12">
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
                                    <tr>
                                        <th>1</th>
                                        <td>Mark</td>
                                        <td>
                                            <a href="#!"><i class="fa fa-plus-circle" aria-hidden="true"></i></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>2</th>
                                        <td>Jacob</td>
                                        <td>
                                            <a href="#!"><i class="fa fa-plus-circle" aria-hidden="true"></i></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>1</th>
                                        <td>Mark</td>
                                        <td>
                                            <a href="#!"><i class="fa fa-plus-circle" aria-hidden="true"></i></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>2</th>
                                        <td>Jacob</td>
                                        <td>
                                            <a href="#!"><i class="fa fa-plus-circle" aria-hidden="true"></i></a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>

            </main>
        <jsp:include page="_js.jsp"></jsp:include>
    </body>
</html>
