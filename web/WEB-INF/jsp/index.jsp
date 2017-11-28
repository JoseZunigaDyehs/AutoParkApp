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

        <body class="d-flex index align-items-center w-100 flex-column">

            <div class="d-flex justify-content-center w-100 align-items-center ">
                <div class="titulo-head d-flex flex-column align-items-center justify-content-center my-4">
                    <i class="fa fa-car" aria-hidden="true"></i>
                    <h6>AutoPark</h6>
                </div>
            </div>
            <form class="py-4 w-50">
                <div class="w-100 px-3">
                    <h4 class="text-light">Login</h4>
                    <div class="bg-white p-3 border my-3">
                        <div class="form-group d-flex align-items-center">
                            <label class="w-25">Nombre usuario: </label>
                            <input type="text" class="form-control"  placeholder="Ingresa rut">
                        </div>
                        <div class="form-group d-flex align-items-center">
                            <label class="w-25">Password:</label>
                            <input type="password" class="form-control" placeholder="Ingresa nombre">
                        </div>
                        <button type="submit" class="btn btn-primary float-right">Login</button>
                    </div>
                </div>
            </form>
        <jsp:include page="_js.jsp"></jsp:include>
    </body>
</html>
