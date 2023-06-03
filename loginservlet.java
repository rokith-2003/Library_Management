
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String pass = request.getParameter("pass");
        String phone = request.getParameter("phone");
        out.println("<pre>            <h1>SUCCESSFULLY CREATED YOUR LIBRARY ACCOUNT<br><br>NOW LOGIN TO ACCESS THE BOOKS<h1><pre>");
        try {
        	 Class.forName("oracle.jdbc.driver.OracleDriver");
        	 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1828");
            String query="insert into libraryuser values(?,?,?,?)";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setString(1,email);
            pstmt.setString(2,dob);
            pstmt.setString(3,pass);
            pstmt.setString(4,phone);
            pstmt.executeUpdate();
            con.close();
 
    }
    catch(Exception ex){
        out.println(ex);
    }

        
    }
}