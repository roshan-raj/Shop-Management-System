/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.project.viewtables;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author doodl
 */
public class AddedHardware extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","root","root");
            if(request.getParameter("add")!=null)
            {
            String name=request.getParameter("name");
            String h_id=request.getParameter("hardware_id");
            int hardware_id=Integer.parseInt(h_id);
            String temp_price=request.getParameter("price");
            int price=Integer.parseInt(temp_price);
            String temp_stock=request.getParameter("stock");
            int stock=Integer.parseInt(temp_stock);
            String s_id=request.getParameter("add");
            int shop_id=Integer.parseInt(s_id);
            Integer shopid=shop_id;
            String query="insert into hardware values("+stock+","+price+",'"+name+"',"+hardware_id+","+shop_id+")";
            String query1="select * from hardware where shop_id="+shop_id;
            Statement ps1=con.createStatement();
            ps1.executeQuery(query);
            Statement ps2=con.createStatement();
            ResultSet rs2=ps2.executeQuery(query1);
            List addeddata=new ArrayList();
            while(rs2.next())
            {
                addeddata.add(rs2.getInt("hardware_id"));
                addeddata.add(rs2.getString("name"));
                addeddata.add(rs2.getInt("stock"));
                addeddata.add(rs2.getInt("price"));    
            }
            RequestDispatcher rd=request.getRequestDispatcher("viewtables.jsp");
            request.setAttribute("query",addeddata);
            request.setAttribute("shop_id",shopid);
            rd.forward(request, response);
            }
            else if(request.getParameter("shop_id")!=null)
            {
                RequestDispatcher rd1=request.getRequestDispatcher("shopkeeper.jsp");
                String s_id=request.getParameter("shop_id");
                Integer shop_id=Integer.parseInt(s_id);
                request.setAttribute("shop_id",shop_id);
                rd1.forward(request,response);
                
            }
        }
        catch(Exception e)
        {
            out.println("Error at db:"+e);
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
            Logger.getLogger(AddedHardware.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddedHardware.class.getName()).log(Level.SEVERE, null, ex);
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
