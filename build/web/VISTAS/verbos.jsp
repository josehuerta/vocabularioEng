<%-- 
    Document   : verbos
    Created on : 7/05/2018, 10:05:52 AM
    Author     : LALO
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>




<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script type="text/javascript" src="../JS/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="../JS/jquery-ui.js"></script>
        <script type="text/javascript" src="../JS/verbosjs.js"></script>
        
         <link rel="stylesheet" type="text/css" href="../CSS/estilo_verbos.css"  />
         <link rel="stylesheet" type="text/css" href="../CSS/estilo_tabla.css"  />
        <title>Verbos</title>
    </head>
    <body>
        <div id="menu">
            
        <h2>Verbos Irregulares</h2>
        <button id="calificar"> Calificar</button>
        <button id="intentar"> Intentar de nuevo</button>
        <button id="btnlistaVerbos">Lista de verbos</button>  
                
        </div>
      
        
        <div  class="lista">
            
            <div class="tiempos">
               <p>Español</p>
               <p>Presente</p>
               <p>Pasado</p>
               <p>P.Participio</p>
           
           </div>
                <div id="fila0"> </div>
                <div id="fila1"> </div>
                <div id="fila2"> </div>
                <div id="fila3"> </div>
                <div id="fila4"> </div>
                <div id="fila5"> </div>
                <div id="fila6"> </div>
                <div id="fila7"> </div>
                <div id="fila8"> </div>
                <div id="fila9"> </div>
                

            </div>

       
             <div class="respuestas" id="contenedor_respuestas">

             </div>
     
        
        <div id="modal"  class="modal">
  	
  	<div id="aciertos">
            <img src="../IMG/feliz.png" class="imgcalificacion">
                <p class="rescalificacion" id="numaciertos">:10</p>
  	</div>
  	<div id="errores">
            <img src="../IMG/triste.png" class="imgcalificacion">
                <p class="rescalificacion" id="numerrores">:10</p>
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
