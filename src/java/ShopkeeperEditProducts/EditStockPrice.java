/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShopkeeperEditProducts;

import db.connection.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
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
 * @author doodl
 */
public class EditStockPrice extends HttpServlet {

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
         PrintWriter out = response.getWriter();
        try
        {
            /* TODO output your page here. You may use following sample code. */
            DatabaseConnection db=new DatabaseConnection();
            Statement st=db.con.createStatement();
            List ls=new ArrayList();
            HttpSession hs=request.getSession(false);
            int shop_id=(Integer)hs.getAttribute("s_id");
            String query="select stock,name,hardware_id from hardware where shop_id="+shop_id+"order by hardware_id";
            String query1="select price,name,hardware_id from hardware where shop_id="+shop_id+"order by hardware_id";
            ResultSet rs=null;
            RequestDispatcher rd=request.getRequestDispatcher("viewitemstobeedited.jsp");
            if(Integer.parseInt(request.getParameter("edit"))==1)
            {
                rs=st.executeQuery(query);
                while(rs.next())
                {
                    ls.add(rs.getInt("stock"));
                    ls.add(rs.getString("name"));
                    ls.add(rs.getInt("hardware_id"));
                }
                request.setAttribute("list",ls);
                hs.setAttribute("status", 1);
                db.con.close();
                st.close();
                rs.close();
                rd.forward(request, response);
            }
            else if(Integer.parseInt(request.getParameter("edit"))==2)
            {
              rs=st.executeQuery(query1);
                while(rs.next())
                {
                    ls.add(rs.getInt("price"));
                    ls.add(rs.getString("name"));
                    ls.add(rs.getInt("hardware_id"));
                }
                request.setAttribute("list",ls);
                hs.setAttribute("status", 2);
                db.con.close();
                st.close();
                rs.close();
                rd.forward(request, response);
            }
            
        }
        catch(Exception e)
        {
            out.println(e);
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
