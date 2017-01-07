import java.io.IOException;
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


@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String temp = (String) session.getAttribute("name");
		
		if(temp != null) {
			
			java.sql.Connection con;
			PreparedStatement pst;
			int re = 0;
		
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			float salary=Float.parseFloat(request.getParameter("salary"));
		
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver Loaded");
					con = DriverManager.getConnection("jdbc:mysql://localhost/test","","");
					System.out.println("Connection established");
					pst=con.prepareStatement("insert into employee values (?,?,?)");
					pst.setInt(1,id);
					pst.setString(2,name);
					pst.setFloat(3,salary);
					re =  pst.executeUpdate();
					System.out.println("Rows Effected : " + re);
					request.setAttribute("numberofrows", re);
		
					RequestDispatcher rd=request.getRequestDispatcher("Insert.jsp");
					rd.forward(request, response);
		
					}catch (SQLException | ClassNotFoundException e) {e.printStackTrace();}		
		}
		else{
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
				rd.include(request, response);
		}
		
	}

}
