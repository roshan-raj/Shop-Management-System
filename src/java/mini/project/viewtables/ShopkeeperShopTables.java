/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.project.viewtables;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author doodl
 */
public class ShopkeeperShopTables extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=response.getWriter();
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","root","root");
        String s_id=(String)request.getParameter("shop_id"); 
        int shop_id=Integer.parseInt(s_id);
        Integer shopid=shop_id;
        String sql="select * from hardware where shop_id="+shop_id+"order by Hardware_id";  
        Statement ps=con.createStatement();
        PreparedStatement ps1=null;
        
        List datalist=new ArrayList();
        ResultSet rs=ps.executeQuery(sql);
        RequestDispatcher rd=request.getRequestDispatcher("viewtables.jsp");
        while(rs.next())
        {
            datalist.add(rs.getInt("hardware_id"));
            datalist.add(rs.getString("name"));
            datalist.add(rs.getInt("stock"));
            datalist.add(rs.getInt("price"));
        }
        if(request.getAttribute("delete")!=null)
        {
            String tools[]=request.getParameterValues("submit");
            ps1=con.prepareStatement("delete from hardware where hardware_id=?");
            for(int i=1;i<=tools.length;i++)
            {
                ps1.setString(i,tools[i]);
                ps1.executeUpdate();
            }
            request.setAttribute("tools", tools);
        }
        else if(request.getAttribute("update")!=null)
        {
            String hard_id=request.getParameter("hardware_id");
            int hardware_id=Integer.parseInt(hard_id);
            String stock_string=request.getParameter("stock");
            String price_string=request.getParameter("price");
            int stock=Integer.parseInt(stock_string);
            int price=Integer.parseInt(price_string);
            ps1=con.prepareStatement("update hardware set stock=? and price=? where hardware_id=?");
            ps1.setInt(1,stock);
            ps1.setInt(2, price);
            ps1.setInt(3,hardware_id);
            ResultSet rs1=ps1.executeQuery();
            request.setAttribute("updated_list",rs1);
        }
        request.setAttribute("temp",s_id);
        request.setAttribute("query",datalist);
        request.setAttribute("shop_id",shopid);
        rd.forward(request, response);
        }
        catch(SQLException e)
        {
            pw.println("Error at database side: "+e);
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
            Logger.getLogger(ShopkeeperShopTables.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ShopkeeperShopTables.class.getName()).log(Level.SEVERE, null, ex);
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
