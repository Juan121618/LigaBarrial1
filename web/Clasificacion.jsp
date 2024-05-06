<%-- 
    Document   : Clasificacion
    Created on : 5 may. 2024, 19:08:55
    Author     : Juan
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Clasificacion"%>
<%@page import="DAO.ClasificacionDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/2.0.6/css/dataTables.bootstrap5.css">
    </head>
    <body>
        <table id="example" class="table table-striped" style="width:100%">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Usuario</th>
                <th>Contraseña</th>
            </tr>
        </thead>
        <%
        ClasificacionDAO dao = new ClasificacionDAO();
        List<Clasificacion> list=dao.listarclasificacion();
        Iterator<Clasificacion> iter=list.iterator();
        Clasificacion per=null;
        while(iter.hasNext()){
            per = iter.next();
            
           

        
        %>
        <tbody>
            <tr>
                <td><%=per.getId()%></td>
                <td><%=per.getNombre()%></td>
                <td><%=per.getUsuario()%></td>
                <td><%=per.getContrasena()%></td>
            </tr>
           <%}%>
        </tbody>
        
    </table> 
    </body>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"></script>
    <script>
        $(document).ready(function (){
            $('#example').DataTable();
        });
    </script>
    
    	

</html>
