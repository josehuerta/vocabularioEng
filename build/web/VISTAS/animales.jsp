<%-- 
    Document   : animales
    Created on : 7/05/2018, 10:06:28 AM
    Author     : LALO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        
        <script type="text/javascript" src="../JS/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="../JS/animalesjs.js"></script>
        
        <link rel="stylesheet" type="text/css" href="../CSS/estilo_animales.css"  />
        <link rel="stylesheet" type="text/css" href="../CSS/estilo_tabla.css"  />
        <title>Animales</title>
    </head>
    <body>
        
       
        
        <div id="menu">
        <h2>Animales</h2>
        
         
        <button id="calificar"> Calificar</button>
        <button id="intentar"> Intentar de nuevo</button>
        <button id="btnlistaAnimales">Lista de animales</button>  
                
        </div>
        
        <div id="respuestas1" class="respuestas">
           
            
        </div>
        
        <div class="imagenes" id="imagenes" >
            
            <div id="cont0" class="contenedores"><p id="animal0" ondragover="allowDrop(event)" ondrop="drop(event)">?</p></div>
            <div id="cont1" class="contenedores"><p id="animal1" ondragover="allowDrop(event)" ondrop="drop(event)">?</p></div>
            <div id="cont2" class="contenedores"><p id="animal2" ondragover="allowDrop(event)" ondrop="drop(event)">?</p></div>
            <div id="cont3" class="contenedores"><p id="animal3" ondragover="allowDrop(event)" ondrop="drop(event)">?</p></div>
            <div id="cont4" class="contenedores"><p id="animal4" ondragover="allowDrop(event)" ondrop="drop(event)">?</p></div>
            <div id="cont5" class="contenedores"><p id="animal5" ondragover="allowDrop(event)" ondrop="drop(event)">?</p></div>
            <div id="cont6" class="contenedores"><p id="animal6" ondragover="allowDrop(event)" ondrop="drop(event)">?</p></div>
            <div id="cont7" class="contenedores"><p id="animal7" ondragover="allowDrop(event)" ondrop="drop(event)">?</p></div> 
            
        </div>
        
        
        <div class="respuestas" id="respuestas2">
                
                                                
            
        </div>
       
        <div id="ventanaCalificacion"  class="ventanaCalificacion">
  	
            <div id="aciertos">
                <img src="../IMG/feliz.png" class="imgcalificacion">
                    <p class="rescalificacion" id="numaciertos"></p>
            </div>
            <div id="errores">
                <img src="../IMG/triste.png" class="imgcalificacion">
                    <p class="rescalificacion" id="numerrores"></p>
            </div>

       </div>
       
         <div id="lista">
            
            <div id="contenedortabla">
                
                <table id="tabla">  
                
                </table>
            </div>
            
        </div>
      
        
    </body>
</html>
