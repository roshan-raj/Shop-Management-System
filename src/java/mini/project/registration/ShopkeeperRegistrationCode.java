/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Roshan Raj
*/
public class ShopkeeperRegistrationCode extends HttpServlet {

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
            out.println("<title>Servlet ShopkeeperRegistrationCode</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShopkeeperRegistrationCode at " + request.getContextPath() + "</h1>");
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
     * @param rq
     * @param rsp
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
            String shopkeeper_id=rq.getParameter("user");
            String pass=rq.getParameter("password");
            String email=rq.getParameter("umail");
            String phonestring=rq.getParameter("phone");
            HttpSession hs=rq.getSession();
            hs.setAttribute("shopkeeper_id",shopkeeper_id);
            //int phone=Integer.parseInt(phonestring);
            String address=rq.getParameter("address");
            String query="insert into shopkeeper(s_id,email,phone,name,address,pass) values('"+shopkeeper_id+"','"+email+"','"+phonestring+"','"+name+"','"+address+"','"+pass+"')";
            st.executeQuery(query); 
            st.executeQuery("commit");
            rsp.setContentType("text/html");
            pw.println("<html><body>");
            pw.println("<script type='text/javascript'>alert('Your account has been created, hit OK to enter your shop details!');window.location='/MiniProject/EnterShopDetails.jsp'</script>\"");
            pw.println("</body></html>");
            pw.close();
            
        }
        catch(SQLException | ClassNotFoundException e)
        {
            pw.println(e);
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

