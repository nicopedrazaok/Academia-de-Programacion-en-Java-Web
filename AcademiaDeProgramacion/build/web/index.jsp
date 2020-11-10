<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Iniciar Sesíon</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6 offset-2">
                    <br>
                    <br>
                    <br>
                    <br>
                    <h1>Bienvienido</h1> <br>

                    <h2>Iniciar Sesion</h2>

                    <form action="/AcademiaDeProgramacion/Login" method="POST">
                        <div class="form-group row">
                            <label for="txtUsuario" class="col-6">Usuario: </label>
                            <div class="col-9">
                                <input type="text" name="txtUsuario" id="txtUsuario" placeholder="Escriba el usuario..." class="form-control"/>
                            </div>                           
                        </div>
                        <div class="form-group row">
                            <label for="txtClave" class="col-6">Contraseña: </label>
                            <div class="col-9">
                                <input type="password" name="txtClave" id="txtClave" placeholder="Escriba la contraseña..." class="form-control"/><br>
                            </div>
                        </div>

                        <div class="form-group  container-xl-12">
                            <input type="submit" value="Iniciar Sesion" class="btn btn-success"/>
                        </div> 

                    </form>
                </div>
            </div>
        </div>


    </body>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

</html>
