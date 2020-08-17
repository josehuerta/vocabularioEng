/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LALO
 */

import controlador.VerbosirregularesJpaController;
import entidades.Verbosirregulares;
import java.util.List;

public class operacionesVerbos {
    
    VerbosirregularesJpaController ControladorVerbos= new VerbosirregularesJpaController();

    public List Visualizar()
    {
        List <Verbosirregulares> listVerbos= ControladorVerbos.findVerbosirregularesEntities();
            
        try {
            Object obj[]=null;
            
            for(int i=0; i<listVerbos.size();i++){
                System.out.println(""+listVerbos.get(i).getEspanol()+""+listVerbos.get(i).getPresente()+""+listVerbos.get(i).getPasado()
                        +""+listVerbos.get(i).getPasadoParticipio());
            
            
            }
            
            
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
         return listVerbos;
      
    }

    
    
}



