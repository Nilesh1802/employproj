import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import query.Queries;
public class ViewAllTag extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out=getJspContext().getOut();
		out.println("Hello");
		  
		     String[][] table;
			try {
				table = new Queries().viewAll();
				out.println("<table border=3 style="+"color:#ffffff>");
			     
			    for (int i=0;i<table.length;i++){ 
			     
			    	out.println("<tr style="+"color:#ffffff"+">");
			    	
			          out.println("<td style="+"color:#ffffff"+">"+table[i][0] +"</td>");
			          out.println("<td style="+"color:#ffffff"+">"+table[i][1] +"</td>");
			          out.println("<td style="+"color:#ffffff"+">"+table[i][2] +"</td>");      
			          out.println("</tr>");    
			    }
			         
			out.println("</table>");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			};
			
		    
	}
	
}
