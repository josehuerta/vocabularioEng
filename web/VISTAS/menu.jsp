<%-- 
    Document   : menu
    Created on : 22/06/2018, 02:56:54 PM
    Author     : LALO
--%>

<%@page import="entidades.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="controlador.UsuarioJpaController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Incio</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <script type="text/javascript" src="../JS/jquery-3.3.1.js"></script>
         <script type="text/javascript" src="../JS/menu.js"></script>
        
        <link rel="stylesheet" type="text/css" href="../CSS/estilo_menu.css"/>
    
    </head>
    <body>
        <%HttpSession s= request.getSession();
        
        UsuarioJpaController user= new UsuarioJpaController();
        List <Usuario> usuarios = user.findUsuarioEntities();
        int numusuario=0;
        try{
            String correo=(String)s.getAttribute("correo");

                

                for(int x=0;x<usuarios.size();x++){

                    if(correo.equals(usuarios.get(x).getCorreo())){
                        numusuario=x;
                        x=usuarios.size();
                    }  
                }
            
        }
        catch(Exception e){
            System.out.println("Ha ocurrido un error");
            response.sendRedirect("../VISTAS/index.html");
        }
            
        int cverbos=(usuarios.get(numusuario).getCalifVerbos())*100/10;
        
        int canimales=(usuarios.get(numusuario).getCalifAnimales())*100/8;
        int cc1=(usuarios.get(numusuario).getCalifCuerpo1())*100/10;
        int cc2=(usuarios.get(numusuario).getCalifCuerpo2())*100/12;
        %>
        <div class="menu">
        <h2>Hola <%=s.getAttribute("nombre") %></h2>
        <button id="btncerrar">Cerrar sesión</button>
        </div>
        
     
        <div id="verbos">
            
            <a href="verbos.jsp">
                <h3>Verbos Irregulares</h3>
                <img src="../IMG/verbos.jpg">
                <div class="progreso">
                         <div class="cantidadProgreso " style="width:<%=cverbos%>% "> 
                             <p><%=cverbos%>%</p>
                         </div>
                </div>
            </a>
        </div>
        
        <div id="animales">
           
                 <a href="animales.jsp"> 
                     <h3>Animales</h3> 
                     <img src="../IMG/animal.jpg" id="imganimales">
                     
                     <div class="progreso">
                         <div class="cantidadProgreso " style="width:<%=canimales%>% "> 
                             <p><%=canimales%>%</p>
                         </div>
                     </div>
                 </a>   
        </div>
        
        <div id="partesCuerpo">
            <h3 id="titulocuerpo">Partes del cuerpo</h3>
            
                <a href="extremidades1.html">
                    <h3>Parte 1</h3>
                    <img src="../IMG/cuerponiño.jpg" class="imgcuerpo">
                    
                    <div class="progreso">
                         <div class="cantidadProgreso " style="width:<%=cc1%>% "> 
                             <p><%=cc1%>%</p>
                         </div>
                     </div>
                    
                </a>  
           
           
            <a  href="extremidades2.html">
                    <h3>Parte 2</h3>
                    <img src="../IMG/cuerponiña.jpg" class="imgcuerpo">
                    
                    <div class="progreso">
                        <div class="cantidadProgreso"  style="width:<%=cc2%>% "> 
                             <p><%=cc2%>%</p>
                         </div>
                    </div>
                         
            </a>         
        </div>
            

    </body>
</html>
