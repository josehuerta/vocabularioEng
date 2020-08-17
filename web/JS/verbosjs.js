/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var listaVerbos;

$(document).ready(obtenerVerbos);

function procesoCalificar (){
        
     var calificacion=0;
     var tamcontresp=$("#contenedor_respuestas").length;
         for (var i=0;i<10;i++){

            var dad=$("#fila"+i).children();
            
           
            var idres="resp"+i;
                for(var x=0;x<4;x++){

                   var idopc=dad.get(x).id;

                   if(idopc.charAt(0)=="r"){
                       
                       
                       if(idopc==idres){
                                $("#"+dad.get(0).id).css("background-color", "orange");
                                $("#"+dad.get(1).id).css("background-color", "orange");
                                $("#"+dad.get(2).id).css("background-color", "orange");
                                $("#"+dad.get(3).id).css("background-color", "orange");
                            calificacion++;

                       }
                       else{
                                $("#"+dad.get(0).id).css("background-color", "red");
                                $("#"+dad.get(1).id).css("background-color", "red");
                                $("#"+dad.get(2).id).css("background-color", "red");
                                $("#"+dad.get(3).id).css("background-color", "red");
                             
                       }
                   }

                }

        }
        
        
        if (tamcontresp!=0){
           calificacion=10-(tamcontresp+(10-tamcontresp-calificacion));
        }
        
        $("#numaciertos").text(calificacion+" aciertos");
        $("#numerrores").text(10-calificacion+" errores");
        
        
                for (var i=0;i<10;i++){

                    var dad=$("#fila"+i).children();


                    var idres="resp"+i;
                    
                        for(var x=0;x<4;x++){

                           if (($("#"+dad.get(x).id).text()=="?")){
                                $("#"+dad.get(0).id).css("background-color", "red");
                                $("#"+dad.get(1).id).css("background-color", "red");
                                $("#"+dad.get(2).id).css("background-color", "red");
                                $("#"+dad.get(3).id).css("background-color", "red");
                                x=3;
                               
                           }

                    }

                }
        
        
        $(".modal").toggle("slow");

        
        //colocando calificacion en la base de datos
           
            $.ajax({
               
                url:'../ProcesarCalificacion',
                type:'POST',
                data:{'calificacion':calificacion,
                    'seccion':"verbos"},
                success:function(response){
                    console.log(response);
                }
           });
     }

function obtenerVerbos(){
         //peticion ajax , para obtener los verbos de la base de datos
       $.ajax({
                    url:'../enviarVerbos',
                    success: function (response){
                     
                     //obtenemos un string de esa peticion, y la convertimos en un objeto JSON
                    var respuesta=JSON.parse(response);
                    listaVerbos=respuesta;
                   
                  
                    // alert(respuesta[0].espanol);
                    //console.log(respuesta);
                   
               //Iniciamos la calificacion con cero
                $("#numaciertos").text("");
                $("#numerrores").text("");
		$("#modal").hide();
                $("#lista").hide();
               
              //obtenemos aleatorios para no colocar de manera continua las respuestas
              
                   
                      var txt=numerosAleatorios(10,184);
                    
                                    var valor_respuesta=[];
                                    
                                    var tiempos=["espanol","presente","pasado","pasadoParticipio"];
                                    
                                    //removemos los elementos para que al recargar la pagina
                                    //sean diferentes 
                                    for (var i=0;i<10;i++){
                                        
                                        var fila =document.getElementById("fila"+i);
                                        if(fila != null){
                                            while (fila.hasChildNodes()){
                                                fila.removeChild(fila.lastChild);
                                            }
                                        }
                                    }
                                    
                                    var respuestas=document.getElementById("contenedor_respuestas");
                                        if(respuestas != null){
                                            while (respuestas.hasChildNodes()){
                                                respuestas.removeChild(respuestas.lastChild);
                                       }
                                   }
                                    
                                   for (x=0;x<10;x++){

                                       var rand=Math.round(Math.random()*3);


                                           for (y=0;y<4;y++){
                                              

                                               if (y == rand){

                                                    switch (rand){

                                                       case 0:
                                                           $("#fila"+x).append(' <p id="'+tiempos[y]+x+'">?</p>');
                                                           valor_respuesta[x]=respuesta[txt[x]].espanol;
                                                       break;

                                                       case 1:
                                                           $("#fila"+x).append(' <p id="'+tiempos[y]+x+'">?</p>');
                                                           valor_respuesta[x]=respuesta[txt[x]].presente;
                                                       break;

                                                       case 2:
                                                           $("#fila"+x).append(' <p id="'+tiempos[y]+x+'">?</p>');
                                                           valor_respuesta[x]=respuesta[txt[x]].pasado;
                                                       break;

                                                       case 3:

                                                           $("#fila"+x).append(' <p id="'+tiempos[y]+x+'">?</p>');
                                                           valor_respuesta[x]=respuesta[txt[x]].pasadoParticipio;
                                                       break;
                                                       }

                                                      $("#"+tiempos[y]+x).attr("ondragover","allowDrop(event)");
                                                      $("#"+tiempos[y]+x).attr("ondrop","drop(event)");
                                                      $("#"+tiempos[y]+x).css("background-color", "rgb(179, 112, 218)");
                                               }
                                               else{
                                                  
                               
                                                        switch (y){

                                                         case 0:
                                                             $("#fila"+x).append(' <p id="'+tiempos[y]+x+'">'+respuesta[txt[x]].espanol+'</p>');
                                                         break;

                                                         case 1:
                                                             $("#fila"+x).append(' <p id="'+tiempos[y]+x+'">'+respuesta[txt[x]].presente+'</p>');
                                                         break;

                                                         case 2:
                                                             $("#fila"+x).append(' <p id="'+tiempos[y]+x+'">'+respuesta[txt[x]].pasado+'</p>');
                                                         break;

                                                         case 3:

                                                             $("#fila"+x).append(' <p id="'+tiempos[y]+x+'">'+respuesta[txt[x]].pasadoParticipio+'</p>');
                                                         break;
                                                         }
                                               
                                                }

                                           }

                                       

                                   }
                                   
                          
                           
                         var numaleatorios=numerosAleatorios(10,10);
                       
                           for (var x=0;x<10;x++){
                               
                               $("#contenedor_respuestas").append('<p id=resp'+numaleatorios[x]
                                       +'>'+valor_respuesta[numaleatorios[x]]+'</p>');

                                       $("#resp"+numaleatorios[x]).attr( "ondragstart","drag(event)");
                                       $("#resp"+numaleatorios[x]).attr( "draggable","true");
                           }        
                                   
                                   

                    },
                    error: function(jqXHR,estado,error){
                        console.log("Ha ocurrido un error:"+error);
                    }
                            ,
                    complete: function (xhr,estado){
                      //alert("hola");
                    }
                  });
    
}
function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev) {
    ev.preventDefault();
    
    var data = ev.dataTransfer.getData("text");
    
    val_resp=$("#"+data).text();
    val_idresp=$("#"+data).attr("id");
    
   
    //quitamos el elemento arrastrado
     $("#"+data).remove();
    
    $("#"+ev.target.id).text(val_resp);
    $("#"+ev.target.id).attr("id",val_idresp);
    
    //ev.target.appendChild(document.getElementById(data));
  
}
$(document).ready(function(){
    
    $("#calificar").click(procesoCalificar);
    
    $("#intentar").click(obtenerVerbos); 
   
    $(".modal").click(function(){

		$(this).css({display:"none"});
	});
});



function numerosAleatorios( cantidadaleatorios, limsuperior ){
    
    //cantidadaleatorios debe ser menor o igual a limsuperior ya que se retornan
    //aleatorios diferentes
    
    //obtenemos aleatorios a partir de 0 
    var arrayAleatorios=[];
    var numeros=[];
    
    for(var x=0;x<limsuperior;x++){
        numeros[x]=x;
    }
    
    
    for (var i=0;i<cantidadaleatorios;i++){

                var indice = Math.floor(Math.random()*numeros.length);
                
                arrayAleatorios[i]=numeros.splice(indice, 1);
     }
      
    return arrayAleatorios;
    
}


$(document).ready(function(){
    
        $("#btnlistaVerbos").click(function(){
            
         var columnas= $("#tablaVerbos").children();
         if(columnas!=null){
             columnas.remove();
         }
       
         $("#tabla").append("<tr>"+
                    "<th>#</th>"+
                    "<th>Español</th>"+
                    "<th>Presente</th>"+
                    "<th>Pasado</th>"+
                    "<th>P.Participio</th>"+
                "</tr>"
       );
         for (var x=0;x<listaVerbos.length;x++){

            $("#tabla").append('<tr>'+
                             '<td>'+x+'</td>'+
                             '<td>'+listaVerbos[x].espanol +'</td>'+
                             '<td>'+listaVerbos[x].presente +'</td>'+
                             '<td>'+listaVerbos[x].pasado +'</td>'+
                             '<td>'+listaVerbos[x].pasadoParticipio +'</td>'
                             +' </tr>'); 
         }
        
        
        $("#lista").toggle("slow");

     }); 
});


