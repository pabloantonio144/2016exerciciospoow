/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Q02ConverterTemperatura;

/**
 *
 * @author Maicon
 */
@WebServlet(name = "Q02", urlPatterns = {"/q02"})
public class Q02 extends HttpServlet {

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
        
        double valorParaConverter = Double.valueOf(request.getParameter("valor"));
        int opcao = Integer.valueOf(request.getParameter("opcao"));
        System.out.println("valor da opcao"+opcao);
        String msg = "<h3>";

        switch(opcao){
            case 1:
                msg += valorParaConverter+"° Celsius é "+Q02ConverterTemperatura.celsiusToFahrenheit(valorParaConverter)+"° Fahrenheit";
                System.out.println(msg);
                break;
            case 2:
                msg += valorParaConverter+"° Fahrenheit é "+Q02ConverterTemperatura.fahrenheitToCelsius(valorParaConverter)+"° Celsius";
                break;
            case 3:
                msg += valorParaConverter+"° Celsius é "+Q02ConverterTemperatura.celsiusToKelvin(valorParaConverter)+"° Kelvin";
                break;
            case 4:
                msg += valorParaConverter+"° Kelvin é "+Q02ConverterTemperatura.kelvinToCelsius(valorParaConverter)+"° Celsius";
                break;
            default:
                response.sendRedirect("q02.html");
        }
        
        msg += "</h3>";
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado questão 2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div>"+msg+"<br>");
            out.println("<a href='q02.html'>Voltar</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
