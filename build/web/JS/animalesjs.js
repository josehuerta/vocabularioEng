/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    
    cargarElementos();
    
    $("#intentar").click(cargarElementos);
    
    $("#ventanaCalificacion").click(function(){

		$(this).css({display:"none"});
	}); 
    
})
var respuestas=[];
var listaAnimales;

function cargarElementos(){
    
    $.ajax({
       
        url:'../enviarAnimales',
        
        success:function(response){
           
             var respuesta=JSON.parse(response);
             
                listaAnimales=respuesta;
                $("#ventanaCalificacion").hide();
                
                var resp1=$("#respuestas1").children();
                var resp2=$("#respuestas2").children();
                if (resp1.length>1){
                    resp1.remove();
                    resp2.remove(); 
               }
               //     if(imagenes.length>=1){imagenes.remove();}
            
                //indices aleatorios a obtener de la base
                animalaleatorio=numerosAleatorios(8,11);

                //valores aleatorios para acomodar de manera diferente las respuestas  
                acomodaraleatorio=numerosAleatorios(8,8);
               
                //1)obtenemos aleatorios para obtener diferentes animales
                //2)obtenemos aleatorios para acomodar de manera aleatoria lo obtenido de la base
                  
                  
               

                //llenamos los contenedores con lo obtenido de la peticion ajax
                for (var x=0;x<8;x++){

                    $("#cont"+x).css("background-image",'url("../IMG/'
                            +respuesta[animalaleatorio[acomodaraleatorio[x]]].ruta +'")');  
                    respuestas[x]=respuesta[animalaleatorio[acomodaraleatorio[x]]].animalIngles;
                    $("#animal"+x).text("?");
                     $("#animal"+x).css("background-color","rgb(179, 112, 218)");
                }
               
                
                acomodarresp=numerosAleatorios(8,8);
                
                for (var x=0;x<8;x++){
                
                    if(x<4){
                        $("#respuestas1").append('<p id="r'+x+'">'
                                +respuesta[animalaleatorio[acomodarresp[x]]].animalIngles +'</p>');
                    }
                    else{
                         $("#respuestas2").append('<p id="r'+x+'">'
                                +respuesta[animalaleatorio[acomodarresp[x]]].animalIngles +'</p>');
                    }
                
                $("#r"+x).attr("ondragstart","drag(event)");
                $("#r"+x).attr( "draggable","true");
                
                }
                
                console.log(respuestas);
          
                
        },
        
        error: function(jqXHR,estado,error){
            console.log("Ha ocurrido un error:"+error);
        },
        complete:function(jqxhr,estado){
            //complete es para algo que queremos que pase , mientras se ejecute la peticion asi obtengamos un error o un exito(success)
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
     
    //obtenemos el id del elemento que ha sido colocado en algun contenedor de las respuestas
    var id_respuesta = ev.dataTransfer.getData("text");
    var val_respuesta=$("#"+id_respuesta).text();
    
    //id del contenedor en que colocaremos la imagen 
    var id_contenedor=ev.target.id;
    
    $("#"+id_contenedor).text(val_respuesta);
    
    $("#"+id_respuesta).remove();
    
  
}

$(document).ready(function(){
    
   $("#calificar").click(function(){
      
       var calificacion=0;
       
       for(var x=0;x<8;x++){
           
           var hijo=$("#cont"+x).children();
          
           console.log(respuestas[x]);
           if (respuestas[x]==($("#"+hijo.get(0).id).text())){
               $("#"+hijo.get(0).id).css("background-color","orange");
               calificacion++;
           }
           else{
               $("#"+hijo.get(0).id).css("background-color","red");
           }
           
       }
        
       
            $("#numaciertos").text(calificacion+" aciertos");
            $("#numerrores").text(8-calificacion+" errores");
            $("#ventanaCalificacion").toggle("slow");
        
        //colocando calificacion en la base de datos
           
            $.ajax({
               
                url:'../ProcesarCalificacion',
                type:'POST',
                data:{'calificacion':calificacion,
                    'seccion':"animales"},
                success:function(response){
                    console.log(response);
                }
           });
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
    
        $("#btnlistaAnimales").click(function(){
            
         var columnas= $("#tabla").children();
         if(columnas!=null){
             columnas.remove();
         }
       
         $("#tabla").append("<tr>"+
                    "<th>#</th>"+
                    "<th>Español</th>"+
                    "<th>Ingles</th>"+
                "</tr>"
       );
         for (var x=0;x<listaAnimales.length;x++){

            $("#tabla").append('<tr>'+
                             '<td>'+x+'</td>'+
                             '<td>'+listaAnimales[x].animalEspanol +'</td>'+
                             '<td>'+listaAnimales[x].animalIngles +'</td>'+
                             ' </tr>'); 
         }
        
        
        $("#lista").toggle("slow");

     }); 
});