<!DOCTYPE html>
<html>
    <head>
            <meta charset="UTF-8">
    <title>Document</title>
    <!--BOOSTRAP 4-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <!--SCROLL REVEAL-->
    <script src="https://unpkg.com/scrollreveal"></script>
    <!--FONTS-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <!--CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    </head>
    <body>
            <!--HEADER-->
    <div class="container">
        <div class="container p-3 my-3 bg-dark text-white"><div class="container-fluid">
            <h3 id="notas">Notas</h3>
        </div></div>
    </div>
    <div class="container mt-5">


      <!--template nota-->
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <c:forEach items="${listaNotas}" var="nota"> 
        <form action="${pageContext.request.contextPath}/app?accion=update" method="post">
          <input value="${nota.id}" id="${nota.id}" name="id" type="text" readonly>
          <input name="descripcion" type="text">
          <button type="submit">Editar</button>
        </form>

        <div class="card mb-4 shadow-sm col-md-4">
            <div class="card-body">
                <p class="card-text">${nota.descripcion}</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">

                  <form action="${pageContext.request.contextPath}/app?accion=delete" method="post">
                    <button id="borrar" value="${nota.id}" name="id" type="submit" class="btn btn-sm btn-outline-secondary" onclick="borrar()">Borrar</button>
                  </form>

                  <!--<button id="editar" type="button" class="btn btn-sm btn-outline-secondary" onclick="editar()">Editar</button>-->
                </div>
              </div>
            </div>
          </div>
        </c:forEach>
      <!--template nota-->

          <form action="${pageContext.request.contextPath}/app?accion=add" method="post"><input name="descripcion" type="text">

          <!--<button class="agregar" onclick="agregar()">+</button>-->
        </form>
    </div>





    <!--MI SCRIPS-->
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
    <script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
    <!-- CSS -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
    <!-- Default theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>

    <!--BOOSTRAP 4 SCRIPS-->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
    </body>
</html>
