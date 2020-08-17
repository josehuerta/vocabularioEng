/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    
     $("#btncerrar").click(cerrarSesion);
});

function cerrarSesion(){
    
    $.ajax({
       
       url:'../cerrarSesion',
       success:function(response){
             location.href ="../VISTAS/index.html";
             
       },
       error: function(){
           console.log("Ha ocurrido un error");
       }
        
    });
}
