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
import java.util.Iterator;
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
public class DeleteHardware extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            /* TODO output your page here. You may use following sample code. */
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","root","root");
            int shop_id=Integer.parseInt(request.getParameter("shop_id"));
            String tools[]=request.getParameterValues("tools");
            List<String> toolslist=new ArrayList();
            for(int i=0;i<tools.length;i++)
                toolslist.add(tools[i]);           
            PreparedStatement ps1 = con.prepareStatement("delete from hardware where hardware_id=?");
            ResultSet rs=null;
            Iterator itr;
            for(itr=toolslist.iterator();itr.hasNext();)
            {
                int j=Integer.parseInt((String)itr.next());
                ps1.setInt(1,j);
                ps1.executeQuery();
            }
            Statement st=con.createStatement();
            String query="select * from hardware where shop_id="+shop_id+"order by hardware_id";
            List data=new ArrayList();
            rs=st.executeQuery(query);
            while(rs.next())
            {
                data.add(rs.getInt("stock"));
                data.add(rs.getInt("price"));
                data.add(rs.getString("name"));
                data.add(rs.getInt("hardware_id"));
            }
            RequestDispatcher rd=request.getRequestDispatcher("viewtables.jsp");
            request.setAttribute("shop_id",shop_id);
            request.setAttribute("query", data);
            rd.forward(request,response);
        }
        catch(SQLException e)
        {
            out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteHardware.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(DeleteHardware.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(DeleteHardware.class.getName()).log(Level.SEVERE, null, ex);
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
