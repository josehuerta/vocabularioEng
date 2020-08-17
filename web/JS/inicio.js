/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    
    $("#btnIngresar").click(function(){
        
        if($("#ventanaInicioSesion").is(":visible"))
       {
           $("#ventanaInicioSesion").hide();
       }
        else{
            $("#ventanaRegistro").hide();
            $("#ventanaInicioSesion").show();
        }
    });
    
    $("#btnNuevousuario").click( function(){
       if($("#ventanaRegistro").is(":visible"))
       {
           $("#ventanaRegistro").hide();
       }
       else{
            $("#ventanaInicioSesion").hide();
            $("#ventanaRegistro").show();
        }

    });
    
    //botones de las ventanas de registro e inicio de sesion
    $("#btnRegistrar").click( function(e){		  
      
       registrarUsuario();
        e.preventDefault();
    });
    $("#btnIniciarsesion").click( function(e){		  
        e.preventDefault();
        inicioSesion();
       
    });
    $("#ventanaError").click(function(){
        
       $(this).css({display:"none"});
    });
   
});


function registrarUsuario(){
    
    var nombre=$("#nombreRegistro").val();
    var apellido=$("#apeRegistro").val();
    var correo=$("#correoRegistro").val();
    var password=$("#passRegistro").val();
    var arraycorreo=correo.split("");
    var arraypass=password.split("");
     
    if (nombre!="" && apellido!="" && correo!="" && password !="" && arraypass.length>=6){
                

                
                var valarroba=0;
                    for (x=0;x<arraycorreo.length;x++){

                        if (arraycorreo[x]=="@"){
                            valarroba=1;
                            x=arraycorreo.length;
                        }
                    }
                    var numeros=[0,1,2,3,4,5,6,7,8,9];
                    var valpass=0;
                    for (x=0;x<arraypass.length;x++){
                        
                        for(y=0;y<10;y++){
                            if(arraypass[x]=y){
                            valpass=1;
                             x=arraypass.length;
                            }
                        }
                        
                    }
                
                
                var suma=valarroba+valpass;
                console.log(suma);
                if (suma==2){
                                $.ajax({
                            url:'../registrarUsuario',
                            type:'POST',
                            data:{'nombre':nombre,
                                  'apellido':apellido,
                                  'correo':correo,
                                  'password':password},
                           success: function(response){
                               console.log(response);
                               if (response=="registrado"){
                                    limpiarRegistro();
                                     location.href="../VISTAS/menu.jsp";
                               }
                               else{
                                    $("#ventanaError").show();
                               }
                           }
                        });
                }
                else{
                    $("#ventanaError").show();
                }
                
    }
    else{
        $("#ventanaError").show();
    }
    
    
    
}
function inicioSesion(){
    
    var correo=$("#correoUsuario").val();
    var password=$("#passUsuario").val();
    if (correo!="" && password !=""){
        

                $.ajax({
                url: '../iniciarSesion',
                type:'POST',
                data:{
                      'correo':correo,
                      'password':password},
                success: function(response){
                    if(response=="existe"){
                        limpiarInicioSesion();
                        location.href="../VISTAS/menu.jsp";
                    }
                    else{

                       $("#ventanaError").show();
                    }
                }



            });
    
    }
    else{
      $("#ventanaError").show();  
    }
    
    

    
   
    
}
function limpiarRegistro(){
    
    $("#nombreRegistro").val("");
    $("#apeRegistro").val("");
    $("#correoRegistro").val("");
    $("#passRegistro").val("");
}
function limpiarInicioSesion(){
    $("#correoUsuario").val("");
    $("#passUsuario").val("");
}