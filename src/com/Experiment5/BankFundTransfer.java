package com.Experiment5;

import java.sql.*;

public class BankFundTransfer{

    static final String URL = "jdbc:mysql://localhost:3306/bankdb";
    static final String USER = "root";
    static final String PASS = "S712@desai";

    public static void main(String[] args) {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);

            // Disable auto commit
            con.setAutoCommit(false);

            // Example transfer (you can change IDs)
            int senderId = 105;   // Vikram
            int receiverId = 104; // Sneha
            double amount = 3000;

            // Step 1: Check balance
            PreparedStatement check = con.prepareStatement(
                "SELECT name, balance FROM accounts WHERE id = ?"
            );
            check.setInt(1, senderId);
            ResultSet rs = check.executeQuery();

            String senderName = "";
            double balance = 0;

            if (rs.next()) {
                senderName = rs.getString("name");
                balance = rs.getDouble("balance");
            } else {
                throw new Exception("Sender not found!");
            }

            if (balance < amount) {
                throw new Exception("Insufficient balance in " + senderName + "'s account!");
            }

            // Step 2: Debit sender
            PreparedStatement debit = con.prepareStatement(
                "UPDATE accounts SET balance = balance - ? WHERE id = ?"
            );
            debit.setDouble(1, amount);
            debit.setInt(2, senderId);
            debit.executeUpdate();

            // Step 3: Credit receiver
            PreparedStatement credit = con.prepareStatement(
                "UPDATE accounts SET balance = balance + ? WHERE id = ?"
            );
            credit.setDouble(1, amount);
            credit.setInt(2, receiverId);
            int rows = credit.executeUpdate();

            if (rows == 0) {
                throw new Exception("Receiver not found!");
            }

            // Commit
            con.commit();

            System.out.println("₹" + amount + " transferred successfully from ID "
                    + senderId + " to ID " + receiverId);

        } catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback();
                    System.out.println("Transaction Failed! Rolled Back.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Error: " + e.getMessage());

        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}