/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.project.registration;

import db.connection.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
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
public class EnterShopDetails extends HttpServlet {

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
            out.println("<title>Servlet EnterShopDetails</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EnterShopDetails at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param rq servlet request
     * @param rsp servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rsp)
            throws ServletException, IOException {
        PrintWriter pw=rsp.getWriter();
        try 
        {
            DatabaseConnection db=new  DatabaseConnection();
            Statement st=db.con.createStatement();
            int shop_id=Integer.parseInt(rq.getParameter("shop_id"));
            String shop_name=rq.getParameter("name");
            String email=rq.getParameter("email");
            String address=rq.getParameter("address");
            String phonestring=rq.getParameter("phone");
            HttpSession hs=rq.getSession(false);
            String shopkeeper_id=(String)hs.getAttribute("shopkeeper_id");
            String query ="insert into shop(shop_id,name,email,phone,shopaddress,s_id) values ("+shop_id+",'"+shop_name+"','"+email+"','"+phonestring+"','"+address+"','"+shopkeeper_id+"')";
            st.executeQuery(query); 
            rsp.setContentType("text/html");
            pw.println(shopkeeper_id);
            //hs.invalidate();
            pw.println("<html><body>");
            pw.println("<script type='text/javascript'>alert('Your Shop has been registered!');window.location='/MiniProject/MainPage.html'</script>\"");
            pw.println("</body></html>");
            pw.close();
        }
        catch(ClassNotFoundException | NumberFormatException | SQLException e) {
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
