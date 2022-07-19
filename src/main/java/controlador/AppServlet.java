/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Modelo;
import modelo.Nota;

/**
 *
 * @author Matias
 */
@WebServlet(name = "AppServlet", urlPatterns = {"/"})
public class AppServlet extends HttpServlet {
    
    private Modelo model;
    private final String URI_LIST = "newjsp.jsp";
        
    @Override
    public void init() throws ServletException {
        try {
            this.model = (Modelo) Class.forName("modelo.ModeloMySQL").getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            Logger.getLogger(AppServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setAttribute("listaNotas", model.getNotas());
        request.getRequestDispatcher(URI_LIST).forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Nota nota;
        String accion = request.getParameter("accion");
        accion = accion == null ? "" : accion;
        int id;
        switch (accion) {
            case "add":
                nota = new Nota();
                nota.setDescripcion(request.getParameter("descripcion"));
                model.addNota(nota);
                break;
            case "update":
                System.out.println("EL PARAMETRO ID ES: " + request.getParameter("id"));
                System.out.println("EL PARAMETRO DESCRIPCION ES: " + request.getParameter("descripcion"));
                id = Integer.parseInt(request.getParameter("id"));
                nota = model.getNota(id);
                nota.setDescripcion(request.getParameter("descripcion"));
                model.updateNota(nota);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                model.removeNota(id);
                break;
        }
        doGet(request, response);
    }

}

