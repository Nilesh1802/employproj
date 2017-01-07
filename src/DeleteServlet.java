

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		HttpSession session = request.getSession();
		String temp = (String) session.getAttribute("name");
		
		if(temp != null) {
			
						java.sql.Connection con;
						PreparedStatement pst;
		
						int id=Integer.parseInt(request.getParameter("id"));
		
						try {
							Class.forName("com.mysql.jdbc.Driver");
							System.out.println("Driver Loaded");
							con = DriverManager.getConnection("jdbc:mysql://localhost/test","","");
							System.out.println("Connection established");
							pst=con.prepareStatement("select * from employee where id=?");
							pst.setInt(1,id);
							ResultSet rs =pst.executeQuery();
							PrintWriter out=response.getWriter();
							out.println("Row deleted");
							while(rs.next())
							{
								System.out.println(rs.getString(1)+"\t|\t"+rs.getString(2)+"\t|\t"+rs.getString(3)+"\t|\t");
					
							}
			 
							rs =pst.executeQuery();
							rs.next();
			 
							String data[]=new String[3];
							data[0]=rs.getString(1);
							data[1]=rs.getString(2);
							data[2]=rs.getString(3);
			 
							request.setAttribute("id",data[0]);

							request.setAttribute("name",data[1]);

							request.setAttribute("salary",data[2]);
			 
							pst=con.prepareStatement("delete from emplpyee where id=?");
							pst.setInt(1, id);
			 
			 
							RequestDispatcher rd=request.getRequestDispatcher("Delete.jsp");
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
