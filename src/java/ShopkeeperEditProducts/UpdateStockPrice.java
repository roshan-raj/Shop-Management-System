/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShopkeeperEditProducts;

import db.connection.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author doodl
 */
public class UpdateStockPrice extends HttpServlet {

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
        PrintWriter out = response.getWriter() ;
        try {
            /* TODO output your page here. You may use following sample code. */
            DatabaseConnection db=new DatabaseConnection();
            String update_stock="{CALL update_stock(?,?)}";
            String update_price="{CALL update_price(?,?)}";
            HttpSession hs=request.getSession(false);
            if((Integer)hs.getAttribute("status")==1)
            {
                int stock=Integer.parseInt(request.getParameter("stockorprice"));
                int hardware_id=Integer.parseInt(request.getParameter("hardware_id"));
                CallableStatement cs=db.con.prepareCall(update_stock);
                cs.setInt(1, stock);
                cs.setInt(2,hardware_id);
                int rows_updated=cs.executeUpdate();
                //db.con.close();
                if(rows_updated>0)
                    out.println("<script type='text/javascript'>alert('Stock Updated!');</script>\"");
            }
          if((Integer)hs.getAttribute("status")==2)
                    {
                        int price=Integer.parseInt(request.getParameter("stockorprice"));
                        int hardware_id=Integer.parseInt(request.getParameter("hardware_id"));
                        CallableStatement cs1=db.con.prepareCall(update_price);
                        cs1.setInt(1,price);
                        cs1.setInt(2,hardware_id);
                        int rows_updated=cs1.executeUpdate();
                        //db.con.close();
                        if(rows_updated>0)
                            out.println("<script type='text/javascript'>alert('Price Updated!');</script>\"");
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
