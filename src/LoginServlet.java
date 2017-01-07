

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
      
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.sql.Connection con;
		PreparedStatement pst;
	
		response.setContentType("text/html");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost/test","","");
			System.out.println("Connection established");
			
			pst=con.prepareStatement("select username,password from login where username=? and password=?");
			
			pst.setString(1,username);
			pst.setString(2,password);
			java.sql.ResultSet rs=pst.executeQuery();
			
			int flag=0;
			while(rs.next())
			{
			
				flag=1;
				
			}
			 
			if(flag==1)
			{
				HttpSession session=request.getSession();
				session.setAttribute("name", request.getParameter("username"));
				
				 RequestDispatcher rd=request.getRequestDispatcher("index.html");
				 rd.forward(request, response);
				
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
				rd.include(request, response);
				
			}
		
			 
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
