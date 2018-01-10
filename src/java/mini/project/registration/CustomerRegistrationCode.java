
package mini.project.registration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author doodl
 */
public class CustomerRegistrationCode extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustomerRegistrationCode</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerRegistrationCode at " + request.getContextPath() + "</h1>");
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
        doPost(request, response);
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
    protected void doPost(HttpServletRequest rq, HttpServletResponse rsp)
            throws ServletException, IOException {
          PrintWriter pw=rsp.getWriter();
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","root","root");
            Statement st=con.createStatement();
            String name=rq.getParameter("name");
            String cust_id=rq.getParameter("user");
            String pass=rq.getParameter("password");
            String email=rq.getParameter("umail");
            String phonestring=rq.getParameter("phone");
            int phone=Integer.parseInt(phonestring);
            String address=rq.getParameter("address");
            
            String query="insert into customer values('"+cust_id+"','"+email+"','"+phone+"','"+name+"','"+address+"','"+pass+"')";
            st.executeQuery(query); 
            rsp.setContentType("text/html");
            pw.println("<html><body>");
            pw.println("<script type='text/javascript'>alert('Yuo have been registered successfully!');window.location='/MiniProject/MainPage.html'</script>\"");
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
