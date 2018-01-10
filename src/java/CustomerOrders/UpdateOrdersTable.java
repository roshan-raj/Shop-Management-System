/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerOrders;

import db.connection.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Roshan Raj
 */
public class UpdateOrdersTable extends HttpServlet {

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
PrintWriter out = response.getWriter(); 
         try
                {
            /* TODO output your page here. You may use following sample code. */
                    DatabaseConnection db=new DatabaseConnection();
                    PreparedStatement st=db.con.prepareStatement("insert into orders values (?,?,?,?,?,?,?,?,?)");
                    Statement st1=db.con.createStatement();
                    ResultSet rs=null;
                    ResultSet rs1=null;
                    int stock=Integer.parseInt(request.getParameter("stock"));
                    int hardware_id=Integer.parseInt(request.getParameter("tool"));
                    HttpSession hs=request.getSession(false);
                    String cust_id=(String)hs.getAttribute("uname");
                    int shop_id=(Integer)hs.getAttribute("shop_id");
                    String email=(String)hs.getAttribute("email");
                    Integer phone=(Integer)hs.getAttribute("phone");
                    Date date=new Date(hs.getLastAccessedTime());
                    String ord_day=new SimpleDateFormat("dd").format(date);
                    String ord_month=new SimpleDateFormat("MMM").format(date);
                    String ord_year=new SimpleDateFormat("yyyy").format(date);
                    String ord_date=ord_day+"-"+ord_month+"-"+ord_year;
                    Random r=new Random();
                    int order_id=r.nextInt(10000);
                    st.setInt(1,order_id);
                    st.setString(2,ord_date);
                    st.setString(3,cust_id);
                    st.setInt(4,hardware_id);
                    st.setString(5,email);
                    st.setInt(6,phone);
                    st.setInt(7,shop_id);
                    st.setInt(8,stock);
                    String cquery="{CALL test1(?,?)}";
                    CallableStatement cs=db.con.prepareCall(cquery);
                    cs.setInt(1,stock);
                    cs.setInt(2, hardware_id);
                    rs=st1.executeQuery("select stock,price from hardware where hardware_id="+hardware_id);
                    int shop_stock=0;
                    float price=0;
                    if(rs.next())
                    {
                        shop_stock=rs.getInt("stock");
                        price=rs.getInt("price");
                    }
                    price=price*stock;
                    st.setFloat(9,price);
                    if(stock<=shop_stock)
                    {
                       /* out.println(hardware_id);
                        out.println(stock);
                        out.println(shop_stock); */
                    int rows_update=st.executeUpdate();
                    cs.execute();
                    out.println(/*rows_update+*/" <script type='text/javascript'>alert('Order placed succesffully!');window.location='/MiniProject/viewshopsdetails.jsp'</script>\"");
                    }
                    else{
                       /* out.println(shop_id);
                        out.println(hardware_id);
                        out.println(stock);
                        out.println(shop_stock); */
                        out.println("<script type='text/javascript'>alert('The quantity entered exceeds the available stock!');window.location='/MiniProject/viewshopsdetails.jsp'</script>\"");
                    }
        }
         catch(ClassNotFoundException | NumberFormatException | SQLException e)
         {
             out.println("Error :"+e);
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
