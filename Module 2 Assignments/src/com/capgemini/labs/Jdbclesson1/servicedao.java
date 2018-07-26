package com.capgemini.labs.Jdbclesson1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class servicedao {
	
		
		 public Connection servicedao1(){
			  Connection con=null;
			
				String url = "jdbc:mysql://localhost:3306/test";
				String uid = "root";
				String pwd = "corp123";
				try {
					con = DriverManager.getConnection(url, uid, pwd);

				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				return con;
		 }
		 void Save(ItemsList items){
		 String query = "insert into customer1 values(?)";
		 System.out.println(items.getItems());
		 try {
			 
			 	Connection con = servicedao1();
				PreparedStatement psmt = con.prepareStatement(query);
				psmt.setString(1, items.getItems());
				psmt.execute();
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 void Save1(ItemsList items){
			 String query1 = "select * from customer1 where items=?";
				try {
					Connection con = servicedao1();
					PreparedStatement stmt = con.prepareStatement(query1);
					
					stmt.setString(1, items.getItems());
					ResultSet rs = stmt.executeQuery();
					int flag=0;
					while(rs.next())
					{
						
						if(rs.getString(1).equals(items.getItems())){
						flag=1;
						
						}
					}
					
					if(flag==0)
					{
					String query2 = "insert into customer2 values(?)";
					System.out.println(items.getItems());
					try {
						 //Connection con = servicedao1();
							PreparedStatement psmt = con.prepareStatement(query2);
							psmt.setString(1, items.getItems());
							psmt.execute();
							}catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
					
			
			 }
}
