package PracticePackage;


import java.sql.*;

public class DatabasePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}catch(ClassNotFoundException ex) {
			System.out.println("probelm in loading the driver");
			ex.printStackTrace();
		}
		try {
			String dbName = "Employee.accdb";
			String dbURL ="jdbc:ucanaccess://" + dbName;
			conn = DriverManager.getConnection(dbURL);
			String n = "Dilpreet";
			double sa = 600;
			stat = conn.createStatement();
			String query;
			query = "insert into Emp (EName,salary)"+"values ('"+n+"','"+sa+"')";
			stat.executeUpdate(query);
			
			//query = "update Emp set salary = 700" + "where EName = 'ABC'";
			//stat.executeUpdate(query);
			
			rs = stat.executeQuery("select * from Emp");

			int id;
			double sal;
			String name;
			while(rs.next()) {
				id = rs.getInt(1);
				name = rs.getString(2);
				sal = rs.getDouble(3);
				
				System.out.println(" id " +id+" name "+name+" salary "+sal);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(conn!=null) {
					rs.close();
					stat.close();
					conn.close();
				}
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}

	}

}
