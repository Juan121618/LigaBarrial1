<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        Usuario: <input type="text" name="usuario"><br>
        Contraseña: <input type="password" name="contrasena"><br>
        <input type="submit" value="Iniciar Sesión">
    </form>
</body>
</html>
