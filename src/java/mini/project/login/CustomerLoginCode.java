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
public class CustomerLoginCode extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param rq
     * @param rsp
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
            String query="select * from customer where cust_id='"+uname+"' and password='"+pass+"'";
            ResultSet rs=st.executeQuery(query); 
            ResultSet rs1;
           
            rsp.setContentType("text/html");
            pw.println("<html><body>");
            String email=null;
                Integer phone=null;
                String name=null;
            if(rs.next())
            {
               rs1=st1.executeQuery("select name,email,phone from customer where cust_id='"+uname+"' and password='"+pass+"'");
                while(rs1.next())
                {
                name=rs1.getString("name");
                email=rs1.getString("email");
                phone=(rs1.getInt("phone"));
                }
                
                HttpSession hs=rq.getSession();
                RequestDispatcher rd=rq.getRequestDispatcher("customerpostlogin.jsp");
                hs.setAttribute("uname",uname);
                hs.setAttribute("email",email);
                hs.setAttribute("phone",phone);
                hs.setAttribute("name",name);
                rd.forward(rq, rsp);
            }
            else
            {
                pw.println("<script type='text/javascript'>alert('User Name Or Password Invalid!');window.location='/MiniProject/MainPage.html'</script>\"");
            }
            pw.println("</body></html>");
            pw.close();
            
        }
        catch(SQLException | ClassNotFoundException e)
        {
            pw.println(e);
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
