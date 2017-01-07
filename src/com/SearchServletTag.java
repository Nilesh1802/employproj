package com;

import java.io.IOException;
import java.sql.SQLException;

import query.Queries;

import javax.servlet.RequestDispatcher;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.catalina.connector.Request;

public class SearchServletTag extends SimpleTagSupport {

	
	@Override
	public void doTag() throws JspException, IOException {
	
		
		 JspWriter out=getJspContext().getOut();
		
		   int id=(Integer)getJspContext().getAttribute("id");
		
			String[] table;
			try {
				table = new Queries().search(id);
				out.println("<center>"); 
				out.println("<table style="+"color:red;"+">"); 
				out.println("<tr style="+"color:red"+">");
		    	
		          out.println("<td style="+"color:red;"+">"+table[0] +"</td>");
		          out.println("<td style="+"color:red;"+">"+table[1] +"</td>");
		          out.println("<td style="+"color:red;"+">"+table[2] +"</td>");      
		          out.println("</tr>");   
				 
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			 out.println("</table>");    
			 out.println("</center>"); 
	}
}
