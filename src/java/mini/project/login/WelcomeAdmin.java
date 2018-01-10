    package mini.project.login;
    import java.io.IOException;  
    import java.io.PrintWriter;  
    import javax.servlet.ServletException;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
    public class WelcomeAdmin extends HttpServlet {  
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
        response.setContentType("text/html");  
        try (PrintWriter out = response.getWriter()) {
            String n=request.getParameter("uname");
            out.print("Welcome "+n);
        }  
    }  
}  