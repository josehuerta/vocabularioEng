/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(cargarElementos);
$(document).ready(function () {
   $(".modal").click(function(){

		$(this).css({display:"none"});
	}); 
});

var listaCuerpo;
function cargarElementos(){
    
    
    
    $.ajax({
        url:'../enviarPartesCuerpo',
        success:function(response){
          
            var respuesta=JSON.parse(response);
            //parteCuerpoespanol/ingles
            listaCuerpo=respuesta;
            
             $("#numaciertos").text("");
             $("#numerrores").text("");
            $("#modal").hide();
            var txt=[];
            var num = [0,1,2,3,4,5,6,7,8,9];
            
              //obtenemos aleatorios para no colocar de manera continua las respuestas
             for (var i=0;i<10;i++){
                 
                var indice = Math.floor(Math.random()*num.length);
                var number = num[indice];
                 txt[i]=num.splice(indice, 1);
             }
           
            if ($("#txt1").length){
                
                for (var i=0;i<10;i++){
                    
                    $("#txt"+i).remove();
                    $("#r"+i).remove();
                }
                
            }
                
               
                //colocamos los valores obtenidos de la peticion ajax
                    for(var x=0;x<10;x++){

                        var rand=Math.floor(Math.random()*2);

                        if (x<5){

                            
                            $("#contenedor1").append('<p id="txt'+x+'">'+respuesta[x].parteCuerpoespanol+'</p>');
                        }
                        else{

                            $("#contenedor2").append('<p id="txt'+x+'">'+respuesta[x].parteCuerpoespanol+'</p>');                         
                        }
                        
                        

                         $("#txt"+x).attr("ondragover","allowDrop(event)");
                         $("#txt"+x).attr("ondrop","drop(event)");
                         //$("#txt"+x).css("background-color", "yellow")

                    }
                    
                    for(var x=0;x<10;x++){
                        
                        
                        if (x<5){
                                  
                                        $("#respuestas1").append('<p id="r'+x+'">'+respuesta[txt[x]].parteCuerpoingles+'</p>');
                                
                        }
                        else{
                            
                                        $("#respuestas2").append('<p id="r'+x+'">'+respuesta[txt[x]].parteCuerpoingles+'</p>');
                        }
                        
                        $("#r"+x).attr( "ondragstart","drag(event)");
                       $("#r"+x).attr( "draggable","true");
                        
                        
                    }

             
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
    
    var data = ev.dataTransfer.getData("text");
    
    val_resp=$("#"+data).text();
    val_idresp=$("#"+data).attr("id");
    
   
    //quitamos el elemento arrastrado
     $("#"+data).remove();
    
    $("#"+ev.target.id).text(val_resp);
    $("#"+ev.target.id).css("background"," rgb(179, 112, 218) 4px");
    
    //ev.target.appendChild(document.getElementById(data));
  
}
$(document).ready(function(){
    $("#intentar").click(cargarElementos);
});

$(document).ready(function(){
    
    $("#calificar").click(function(){
       var calificacion=0;
       var tamcontresp=($("#respuestas1").children().length)+($("#respuestas2").children().length);
       //obtenemos los contenedores respuesta 1 y 2 para saber si estan vacios o no
        $.ajax({
            
            url:'../enviarPartesCuerpo',
            success:function(response){  
                

        
            var respuesta=JSON.parse(response);
                for (var i=0;i<10;i++){
                    if(($("#txt"+i).text())==respuesta[i].parteCuerpoingles )
                    
                    {
                        calificacion++;
                        $("#txt"+i).css("background", "orange");
                    }
                    else{
                        $("#txt"+i).css("background", " red");
                    }
                }
                //console.log("calificacion:"+calificacion+" de 10");
             
           
            if (tamcontresp!=0){
             calificacion=10-(tamcontresp+(10-tamcontresp-calificacion));
             }
             
              $("#numaciertos").text(calificacion+" aciertos");
              $("#numerrores").text(10-calificacion+" errores");
              
             $("#modal").toggle("slow");
            
           //colocando calificacion en la base de datos
           
            $.ajax({
               
                url:'../ProcesarCalificacion',
                type:'POST',
                data:{'calificacion':calificacion,
                    'seccion':"cuerpo1"},
                success:function(response){
                    console.log(response);
                }
           });
           
            }

        });
          
    });
});


$(document).ready(function(){
    
        $("#btnlistaC1").click(function(){
            
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
         for (var x=0;x<10;x++){

            $("#tabla").append('<tr>'+
                             '<td>'+x+'</td>'+
                             '<td>'+listaCuerpo[x].parteCuerpoespanol +'</td>'+
                             '<td>'+listaCuerpo[x].parteCuerpoingles +'</td>'+
                             ' </tr>'); 
         }
        
        
        $("#lista").toggle("slow");

     }); 
});