    package mini.project.login;
    import java.io.IOException;  
    import java.io.PrintWriter;  
    import javax.servlet.RequestDispatcher;  
    import javax.servlet.ServletException;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
    public class AdminLoginCode extends HttpServlet {  
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
        response.setContentType("text/html");  
        try (PrintWriter out = response.getWriter()) {
            String n=request.getParameter("uname");
            String p=request.getParameter("psw");
            if(LoginAdmin.validate(n, p)){
                RequestDispatcher rd=request.getRequestDispatcher("WelcomeAdmin");
                rd.forward(request,response);
            }
            else{
                out.print("<script type='text/javascript'>alert('User Name Or Password Invalid!')</script>\"");
                RequestDispatcher rd=request.getRequestDispatcher("MainPage.html");
                rd.include(request,response);
            }
        }  
    }  
}  