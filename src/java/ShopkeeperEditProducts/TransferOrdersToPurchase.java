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
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author doodl
 */
public class TransferOrdersToPurchase extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            /* TODO output your page here. You may use following sample code. */
            DatabaseConnection db=new DatabaseConnection();
            db.con.setAutoCommit(false);
            db.con.commit();
            String customerid=request.getParameter("customerid");
            int orderid=Integer.parseInt(request.getParameter("orderid"));
            int hardwareid=Integer.parseInt(request.getParameter("hardwareid"));
            String email=request.getParameter("email");
            int phoneno=Integer.parseInt(request.getParameter("phoneno"));
            int shopid=Integer.parseInt(request.getParameter("shopid"));
            int quantity=Integer.parseInt(request.getParameter("quantity"));
            float amount=Float.parseFloat(request.getParameter("amount"));
            //out.println(request.getParameter("orderid")+"/////"+request.getParameter("customerid")+"///////"+request.getParameter("hardwareid")+"/////"+request.getParameter("email")+"/////"+request.getParameter("phoneno")+"//////"+request.getParameter("shopid")+"/////"+request.getParameter("quantity")+"//////"+request.getParameter("amount"));
            Date cdate=new Date();
            String day=new SimpleDateFormat("dd").format(cdate);
            String month=new SimpleDateFormat("MMM").format(cdate);
            String year=new SimpleDateFormat("yyyy").format(cdate);
            String date=day+"-"+month+"-"+year;
            //out.println(""+date);
            PreparedStatement ps=db.con.prepareStatement("insert into purchase values(purchase_ids.nextval,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,date);
            ps.setString(2,customerid);
            ps.setInt(3,hardwareid);
            ps.setInt(4, shopid);
            ps.setString(5,email);
            ps.setInt(6,phoneno);
            ps.setInt(7,orderid);
            ps.setInt(8, quantity);
            ps.setFloat(9,amount);
            //Savepoint s1=db.con.setSavepoint();
            Statement st=db.con.createStatement();
            String getstock="select stock from hardware where hardware_id="+hardwareid;
            ResultSet rs=st.executeQuery(getstock);
            int stock=0;
            if(rs.next())
                stock=rs.getInt("stock");
            stock-=quantity;
            PreparedStatement ps1=db.con.prepareStatement("update hardware set stock=stock-? where hardware_id=?");
            ps1.setInt(1,quantity);
            ps1.setInt(2,hardwareid);
            PreparedStatement ps2=db.con.prepareStatement("delete from orders where order_id=?");
            ps2.setInt(1,orderid);
            ps.execute();
            ps.close();
            ps1.execute();
            ps1.close();
            ps2.execute();
            ps2.close();
                if(stock>=0)
                {
                    
                    out.println("<script type='text/javascript'>alert('Purchase Table Updated!')</script>\"");
                    db.con.commit();
                }
                else
                {
                    out.println("This action cannot be done as the stock available is less than the required quantity");
                    //db.con.rollback(s1);
                }
            
            
            
        }
        
        catch(SQLException se)
        {
            out.println("This action cannot be done as the stock available is less than the required quantity");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransferOrdersToPurchase.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransferOrdersToPurchase.class.getName()).log(Level.SEVERE, null, ex);
        }
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
