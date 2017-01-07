package query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Queries {
		PreparedStatement pst;
		Connection con;
	public Queries()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost/test","","");
			System.out.println("Connection established");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public void insert(int id,String name,float sal) throws SQLException
	 {
		 pst=con.prepareStatement("insert into employee values (?,?,?)");
		 pst.setInt(1,id);
		 pst.setString(2,name);
		 pst.setFloat(3,sal);
		 int re =  pst.executeUpdate();
		 System.out.println("Rows Effected : " + re);
	 }
	 public void delete(int id) throws SQLException
	 {
		 pst=con.prepareStatement("delete from employee where id = ?;");
		 pst.setInt(1, id);
		 int re=  pst.executeUpdate();
		 System.out.println("Rows Deleted : " + re);
	 }
	 public void updateAll(int id,String name,float sal) throws SQLException
	 {
		 pst=con.prepareStatement("update employee set name=?,sal=? where id=? ;");
		 pst.setInt(3, id);
		 pst.setString(1, name);
		 pst.setFloat(2, sal);
		 int re=  pst.executeUpdate();
		 System.out.println("Rows Effected : " + re);
	 }
	 
	 public String[]search(int id) throws SQLException
	 {
		 pst=con.prepareStatement("select * from employee where id=?;");
		 pst.setInt(1, id);
		 ResultSet rs=pst.executeQuery();
		 System.out.println("Id\t|\tName\t|\tSalary");
		 
		 while(rs.next())
		 {
			 
			 System.out.println(rs.getString(1)+"\t|\t"+rs.getString(2)+"\t|\t"+rs.getString(3)+"\t|\t");
					
			 
		 }
		 rs=pst.executeQuery();
		 rs.next();
		 String data[]=new String[3];
		 data[0]=rs.getString(1);
		 data[1]=rs.getString(2);
		 data[2]=rs.getString(3);
		 
		 return data;
		 
	 }
 
	 public String[][] viewAll() throws SQLException
	 {
		 int c=0;
		 Statement st= con.createStatement();
		 ResultSet rs=  st.executeQuery("select * from employee;");
		 System.out.println("Id\t|\tName\t|\tSalary");
		 while(rs.next())
		 {
			 c++;
			 System.out.println(rs.getString(1)+"\t|\t"+rs.getString(2)+"\t|\t"+rs.getString(3)+"\t|\t");
		 }
		 rs=  st.executeQuery("select * from employee;");
		 String [][]data=new String[c][3];
		 int i=0;
		 while(rs.next())
		 { 
				 data[i][0]=Integer.toString(rs.getInt(1));
				 data[i][1]=rs.getString(2);
				 data[i][2]=Float.toString(rs.getFloat(3));
				 i++;
			 
		 }
		 return data;
		 
		 
	 }
}
