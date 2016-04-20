/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Q03Produto;

/**
 *
 * @author Maicon
 */
@WebServlet(name = "Q03", urlPatterns = {"/q03"})
public class Q03 extends HttpServlet {
    
    //adicionando um vetor  para guardar as compras
    private static List<Q03Produto> carrinho = new ArrayList<>();

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
        
        String msg = "";
        double total = 0.0;
            
        for(Q03Produto produto : carrinho) {
            msg += produto.getNome()+" quantidade: "+produto.getQuantidade()+
                    " valor: "+produto.getValor()+
                    " total: "+format(produto.total())+
                    "<br>";
            total += produto.total();
        }
            
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado questão 3</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<h3>Compra Finalizada, total a pagar</h3><br>");
            out.println(msg+"<br>");
            out.println("Total a pagar: "+format(total)+"<br>");
            out.println("<a href='q03.html'>Voltar</a>");
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
        String opcao = request.getParameter("op");
        
        if(opcao.equals("iniciar")){
            carrinho.clear();
            response.sendRedirect("q03.html");
            
        }else if(opcao.equals("finalizar")){
            processRequest(request, response);
        }
        
        
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
        String nome = request.getParameter("produto");
        double quantidade = Double.valueOf(request.getParameter("quantidade"));
        double valor = Double.valueOf(request.getParameter("valor"));
        
        Q03Produto item = new Q03Produto();
        item.setNome(nome);
        item.setQuantidade(quantidade);
        item.setValor(valor);
        
        carrinho.add(item);
        
        response.sendRedirect("q03.html");
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

    private String format(double total) {
        return DecimalFormat.getCurrencyInstance().format(total);
    }


}
