package com;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import query.Queries;
public class ViewAllTag extends SimpleTagSupport {
	
	public void doTag() throws IOException
	{
		
		JspWriter out=getJspContext().getOut();
	
		  
		     String[][] table;
			try {
				table = new Queries().viewAll();
				out.println("<br><br><br><br><br><br>");
				out.println("<center><br><br><br><br><br><br>");
				out.println("<table border=3");
			     
			    for (int i=0;i<table.length;i++){ 
			        
			    	out.println("<tr>");
			    	out.println("<td>"+table[i][0] +"</td>");
			        out.println("<td>"+table[i][1] +"</td>");
			        out.println("<td>"+table[i][2] +"</td>");    
			        out.println("</tr>");
			       
			    }
			         
			    out.println("</table>");    
			    out.println("</center>");    
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
		    
		   /*  out.println("<table border=3 style="+"color:#ffffff>");
		     
		    for (int i=0;i<table.length;i++){ 
		     
		    	out.println("<tr style="+"color:#ffffff"+">");
		    	
		          out.println("<td style="+"color:#ffffff"+">"+table[i][0] +"</td>");
		          out.println("<td style="+"color:#ffffff"+">"+table[i][1] +"</td>");
		          out.println("<td style="+"color:#ffffff"+">"+table[i][2] +"</td>");      
		          out.println("</tr>");
		          
		         
		    }
		         
		    out.println("</table>");
		
		*/		   	
	}
	
}
