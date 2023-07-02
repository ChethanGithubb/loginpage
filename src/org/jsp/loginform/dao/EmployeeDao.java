package org.jsp.loginform.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jsp.loginfrorm.model.Employee;

public class EmployeeDao {

	public int registerEmployee(Employee e) {
		String insertqry = "insert into loginpage.employee(id,fname,lname,username,password,address,contact) values(?,?,?,?,?,?,?)";

		int result = 0;

		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");

			// Step 2:Create a statement using connection object
			pstmt = con.prepareStatement(insertqry);
			pstmt.setInt(1, 1);
			pstmt.setString(2, e.getFname());
			pstmt.setString(3, e.getLname());
			pstmt.setString(4, e.getUsername());
			pstmt.setString(5, e.getPassword());
			pstmt.setString(6, e.getAddress());
			pstmt.setString(7, e.getContact());

			System.out.println(pstmt);
			// Step 3: Excecute the query or update query
			result = pstmt.executeUpdate();
			System.out.println("Record Inserted");
			
	
		} catch (SQLException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		if(pstmt!=null)
		{
			try {
				pstmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return result;
	}
}
