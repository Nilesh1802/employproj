

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

import com.mysql.jdbc.ResultSet;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SearchServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String temp = (String) session.getAttribute("name");
		
		if(temp != null) {
			
				java.sql.Connection con;
				PreparedStatement pst;
				PrintWriter out=response.getWriter();
				response.setContentType("text/html");
				int id=Integer.parseInt(request.getParameter("id"));
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver Loaded");
					con = DriverManager.getConnection("jdbc:mysql://localhost/test","","");
					System.out.println("Connection established");
					pst=con.prepareStatement("select * from employee where id=?");
					pst.setInt(1,id);
			 
					java.sql.ResultSet rs=pst.executeQuery();
            
					request.setAttribute("id", id);
					RequestDispatcher rd=request.getRequestDispatcher("Search.jsp");
					rd.forward(request, response);
				
				} catch (SQLException | ClassNotFoundException e) {e.printStackTrace();}
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}
}
