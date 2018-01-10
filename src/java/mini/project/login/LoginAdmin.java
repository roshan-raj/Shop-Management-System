    package mini.project.login;
    import java.sql.*;   
    public class LoginAdmin {  
    public static boolean validate(String name,String pass){  
    boolean status=false;  
    try{  
    Class.forName("oracle.jdbc.driver.OracleDriver");  
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","root","root");
    PreparedStatement ps=con.prepareStatement("select * from Admin where Username=? and password=?");  
    ps.setString(1,name);  
    ps.setString(2,pass);  
    ResultSet rs=ps.executeQuery();  
    status=rs.next();  
    }
    catch(ClassNotFoundException | SQLException e){
        System.out.println(e);
    }  
    return status;  
    }  
}  