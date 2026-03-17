package com.Experiment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connection {
    public static void main(String[] args) {
        // Double-check this password! 
      
        String url = "jdbc:mysql://localhost:3306/productdb";
        String username = "root";
        String password = "S712@desai"; 
        String query = "SELECT * FROM product";

        try {
            // Step 1: Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            Connection c = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database successfully!");

            // Step 3: Create statement
            Statement st = c.createStatement();

            // Step 4: Execute query
            ResultSet rs = st.executeQuery(query);

            // Step 5: Process ResultSet 
            // FIXED: Column names now match your SQL 'create table' script
            while(rs.next()) {
                System.out.println("ID: " + rs.getInt("pid") +
                                   " | Name: " + rs.getString("pname") +
                                   " | Price: " + rs.getDouble("Price") 
                                   );
            }

            // Step 6: Close resources
            rs.close();
            st.close();
            c.close();
            System.out.println("Connection closed.");
            
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            if (e.getErrorCode() == 1045) {
                System.err.println("TIP: Your MySQL password for 'root' is likely NOT 'root'.");
            }
        }
    }
}