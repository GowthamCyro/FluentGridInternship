package sqlpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import java.sql.ResultSet;




public class SqlClass {
	
	String database = "jdbc:mysql://localhost:3306/";	
	String username = "root";
	String password = "";
	
	

	public void createDatabase() throws SQLException
	{	
		Connection con = DriverManager.getConnection(database,username,password);
		
		Statement stmt = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("DataBase name ivvu rajaa");
		
		String dbname = sc.next();
		
		try
		{
			
			String s = "create database "+ dbname;
			 
			stmt.execute(s);
			 	
			System.out.println("Database Created Successfully");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			con.close();
		}
	}
	
	public void createTable() throws SQLException
	{
		String s1 = "King";
		Connection con = DriverManager.getConnection(database+s1,username,password);
		
		Statement stmt = con.createStatement();
		
		System.out.println("Table name ivvu rajaa");
		
		Scanner sc = new Scanner(System.in);
		
		String tablename = sc.next();
		
		try
		{
			String s = "create table " + tablename + "(soldier_id int(2),soldier_name varchar(20),soldier_lvl int(2))";
			stmt.execute(s);
			System.out.println("Table Created Successfully");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			con.close();
		}
	}
	
	public void createData() throws SQLException 
	{
		String database = "jdbc:mysql://localhost:3306/King";
		Connection conn = DriverManager.getConnection(database,username,password);	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the id of your soldier");
		int a = sc.nextInt();
		System.out.println("Enter the level of your soldier");
		int c = sc.nextInt();
		System.out.println("Enter the name of your soldier");
		String b = sc.next();		
		try
		{
			String s = "Insert into kingdom values(?,?,?)";
			
			PreparedStatement pstm = conn.prepareStatement(s);
			
			pstm.setInt(1,a);
			pstm.setString(2,b);
			pstm.setInt(3,c);
			
			
			pstm.execute();
			
			System.out.println("Data Inserted Successfully");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			conn.close();
		}
	}
	
	public void getData() throws SQLException 
	{
		
		String database = "jdbc:mysql://localhost:3306/King";
		
		Connection conn = DriverManager.getConnection(database,username,password);
		
		Statement stmt = conn.createStatement();
		
		try
		{
			String s = "Select * from king";
			ResultSet rs = stmt.executeQuery(s);
			
			
			System.out.println("Got the data Successfully");
			
			while(rs.next())
			{
				System.out.println("My soilder id is " + rs.getInt(1));
				System.out.println("My soilder level is " + rs.getInt(3));
				System.out.println("My soilder name is " + rs.getString(2));
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		finally
		{
			conn.close();
		}
	}
	
	public void updateData() throws SQLException
	{
		String s1 = "db";
		Connection conn = DriverManager.getConnection(database+s1,username,password);
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		try
		{
			String s = "Update king set soldier_id=? where soldier_name='Beru'";
			
			PreparedStatement pstm = conn.prepareStatement(s);
			
			pstm.setInt(1,a);
			
			pstm.execute();
			
			System.out.println("Updated Successfully");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			conn.close();
		}
	}
	
	
	public static void main(String args[]) throws SQLException
	{
		SqlClass s = new SqlClass();
//		s.createDatabase();
//		s.createTable();
		s.createData();
//		s.getData();
//		s.updateData();
		
	}

}