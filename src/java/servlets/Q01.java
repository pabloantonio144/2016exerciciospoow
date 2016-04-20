/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maicon
 */
@WebServlet(name = "Q01", urlPatterns = {"/q01"})
public class Q01 extends HttpServlet {

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
        
        //valores fixos
        double comissaoFixaPorCarroVendido = 150.0;
        double salarioMinimo = 873.0;
        double percentualDeFaturamento = 0.002;
        
        //dados do formulario
        int qtdCarrosVendidos = Integer.valueOf(request.getParameter("carrosvendidos"));
        double faturamentoMensalEmpresa = Double.valueOf(request.getParameter("faturamentomensal"));
        
        //calculo do salário do funcionario
        double salarioDoMes = (salarioMinimo * 2) + 
                (qtdCarrosVendidos * comissaoFixaPorCarroVendido) + 
                (percentualDeFaturamento * faturamentoMensalEmpresa);
        //o método format da clase NumberFormat apresenta o valor conforme a moeda
        // corrente no sistema operacional do usuário
        String msg = "<h3>O salário deste mês será: "+DecimalFormat.getCurrencyInstance().format(salarioDoMes)+"</h3>";
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado Q01</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div>"+msg+"<br>");
            out.println("<a href='q01.html'>Voltar</a>");
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
