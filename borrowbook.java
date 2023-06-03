import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
/**
 * Servlet implementation class order
 */
@WebServlet("/borrowbook")
public class borrowbook extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		       
		        response.setContentType("text/html");
		        PrintWriter out = response.getWriter();
		        String id = request.getParameter("id");
		        String name = request.getParameter("name");
		        String title = request.getParameter("title");
		        String author = request.getParameter("author");
		        String dat = request.getParameter("date");
		  
		        try {
		        	Class.forName("oracle.jdbc.driver.OracleDriver");
		        	 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1828");
		        	 String query="insert into borrowbook values(?,?,?,?,?)";
		            PreparedStatement ps = con.prepareStatement(query);
		            ps.setString(1, id);
		            ps.setString(2, name);
		            ps.setString(3, title);
		            ps.setString(4, author);
		            ps.setString(5, dat);
		            int i = ps.executeUpdate();
		            if (i > 0)
		            out.println("<h1><br><pre>               ORDERED  SUCCESSFULLY!!   <br><br>     YOU CAN'T BUY HAPPINESS BUT YOU CAN BUY BOOKS!!!<pre><br><pre>");
		        } catch (Exception e2) {
		            System.out.println(e2);
		        }
		        
	}
}

