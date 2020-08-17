/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.UsuarioJpaController;
import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LALO
 */
public class registrarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        
        try{
         //obtenemos todos los usuarios para ver si el nuevo ya existe
             UsuarioJpaController user= new UsuarioJpaController();
             List <Usuario> usuarios = user.findUsuarioEntities();
           
            String correo=request.getParameter("correo");
            boolean existe=false;
           
            for(int x=0;x<usuarios.size();x++){
    
                if(correo.equals(usuarios.get(x).getCorreo())){
                    existe=true;
                    x=usuarios.size();
                }  
            }
            
            
            if (existe==false){
                String nombre=request.getParameter("nombre");
                String apellido=request.getParameter("apellido");
                String password=request.getParameter("password");
                
                Usuario nuevo=new Usuario();
                nuevo.setNombre(nombre);
                nuevo.setApellidos(apellido);
                nuevo.setCorreo(correo);
                nuevo.setPassword(password);
                nuevo.setCalifVerbos(0);
                nuevo.setCalifAnimales(0);
                nuevo.setCalifCuerpo1(0);
                nuevo.setCalifCuerpo2(0);
                nuevo.setCalifColores(0);
                nuevo.setIdUsuario( (int) (Math.random() * 100) + 1);
                user.create(nuevo);
                
                HttpSession s= request.getSession();
                s.setAttribute("nombre",nombre);
                s.setAttribute("correo", correo);
                
                response.getWriter().write("registrado");
            }
            
            else{
            response.getWriter().write("noregistrado");
            }
            
        } catch (Exception ex) {
            
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
