<%-- 
    Document   : visualizar
    Created on : 2/05/2018, 02:04:41 PM
    Author     : LALO
--%>

<%@page import="controlador.VerbosirregularesJpaController"%>
<%@page import="entidades.Verbosirregulares"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import= "modelo.operacionesVerbos" %> 


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        
        <%
        VerbosirregularesJpaController ControladorVerbos= new VerbosirregularesJpaController();
        operacionesVerbos obj= new operacionesVerbos();
         List <Verbosirregulares> listVerbos= ControladorVerbos.findVerbosirregularesEntities();
        
         for(int i=0; i<listVerbos.size();i++){%>
         
             <p><%=listVerbos.get(i).getEspanol()%> </p>
             <p><%=listVerbos.get(i).getPresente() %> </p>
             <p><%=listVerbos.get(i).getPasado()%> </p>
             <p><%=listVerbos.get(i).getPasadoParticipio()%> </p>
            
            <%
            }
         %>
        
     
    </body>
</html>
