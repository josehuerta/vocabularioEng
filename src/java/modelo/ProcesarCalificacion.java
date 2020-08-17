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
public class ProcesarCalificacion extends HttpServlet {

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
            throws ServletException, IOException{
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            UsuarioJpaController user= new UsuarioJpaController();
            List <Usuario> usuarios = user.findUsuarioEntities();
            
            HttpSession s= request.getSession();
            String correo=(String) s.getAttribute("correo");
            int numeroUsuario=0;
            
            for(int x=0;x<usuarios.size();x++){
                
                if(correo.equals(usuarios.get(x).getCorreo())){
                    numeroUsuario=x;
                    x=usuarios.size();
                }  
            }
            
            
            int calificacion= Integer.parseInt(request.getParameter("calificacion"));
            
            String seccion=request.getParameter("seccion");
            
            if (seccion.equals("verbos")){
                usuarios.get(numeroUsuario).setCalifVerbos(calificacion);
                
            }
            else if (seccion.equals("cuerpo1")){
                usuarios.get(numeroUsuario).setCalifCuerpo1(calificacion);
            }
            else if(seccion.equals("cuerpo2")){
                usuarios.get(numeroUsuario).setCalifCuerpo2(calificacion);
            }
            else{
                usuarios.get(numeroUsuario).setCalifAnimales(calificacion);
            }
            
            user.edit(usuarios.get(numeroUsuario));
            response.getWriter().write("calificado");
            
       
        } catch (Exception ex) {
            Logger.getLogger(ProcesarCalificacion.class.getName()).log(Level.SEVERE, null, ex);
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
