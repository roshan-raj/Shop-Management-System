/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.project.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author doodl
 */
public class ShopkeeperLoginCode extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    protected void processRequest(HttpServletRequest rq, HttpServletResponse rsp)
            throws ServletException, IOException {
        rsp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=rsp.getWriter();
       
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","root","root");
            Statement st=con.createStatement();
            Statement st1=con.createStatement();
            String uname=rq.getParameter("uname");
            String pass=rq.getParameter("psw");
            String query="select * from shopkeeper where s_id='"+uname+"' and pass='"+pass+"'";
            ResultSet rs=st.executeQuery(query); 
            RequestDispatcher rd=rq.getRequestDispatcher("shopkeeper.jsp");
            Integer data=0; 
            HttpSession hs=rq.getSession();
            rsp.setContentType("text/html");
            pw.println("<html><body>");
            String shop_name=null;
            if(rs.next())
            {
                String query1="select * from shop where s_id='"+uname+"'";
                ResultSet rs1=st1.executeQuery(query1);
                if(rs1.next())
                {
                   data=rs1.getInt("shop_id"); 
                   shop_name=rs1.getString("name");
                }
                con.close();
                hs.setAttribute("s_id",data);
                rq.setAttribute("shop_id",data);
                hs.setAttribute("shopname",shop_name);
                rd.forward(rq, rsp);
            }
            else
            {
                pw.println("<h1>INVALID CREDENTIALS!</h1>");
            }
            pw.println("</body></html>");
            pw.close();
            
            
        }
        catch(SQLException e)
        {
            pw.println(e);
        }
        catch (ClassNotFoundException ex)
        {
            pw.println(ex);
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