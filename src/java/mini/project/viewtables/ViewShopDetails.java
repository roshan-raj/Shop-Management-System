/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.project.viewtables;

import db.connection.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Roshan Raj
 */
public class ViewShopDetails extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            DatabaseConnection db=new DatabaseConnection();
             Statement st=db.con.createStatement();
             int shop_id=Integer.parseInt(request.getParameter("shop_id"));
             String query="select hardware_id,name,stock,price from hardware where shop_id="+shop_id;
             ResultSet rs=st.executeQuery(query);
             List data1=new ArrayList();
             Integer s_id= shop_id;
             while(rs.next())
             {
                 data1.add(rs.getInt("hardware_id"));
                 data1.add(rs.getString("name"));
                 data1.add(rs.getInt("stock"));
                 data1.add(rs.getInt("price"));
             }
             RequestDispatcher rd=request.getRequestDispatcher("shopcontents.jsp");
             HttpSession hs=request.getSession(false);
             hs.setAttribute("shop_id",s_id);
             hs.setAttribute("data1",data1);
             rd.forward(request, response);
              
        }
         catch(Exception e)
         {
             out.println(""+e);
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