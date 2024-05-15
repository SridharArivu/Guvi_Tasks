package com.example.mysql;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/empl",
                    "root",
                    "sridhar12"
            );
            Statement st = connection.createStatement();

            String insertData1 = "insert into employee (empcode, empname, empage, esalary) values (101,'jenny',25,10000)";
            String insertData2 = "insert into employee (empcode, empname, empage, esalary) values (102,'jacky',30,20000)";
            String insertData3 = "insert into employee (empcode, empname, empage, esalary) values (103,'joe',20,40000)";
            String insertData4 = "insert into employee (empcode, empname, empage, esalary) values (104,'john',40,80000)";
            String insertData5 = "insert into employee (empcode, empname, empage, esalary) values (105,'Shameer',25,90000)";


            int rowsInserted = st.executeUpdate(insertData1);
            rowsInserted += st.executeUpdate(insertData2);
            rowsInserted += st.executeUpdate(insertData3);
            rowsInserted += st.executeUpdate(insertData4);
            rowsInserted += st.executeUpdate(insertData5);

            String getData = "select * from employee";

            if (rowsInserted == 5) {
                System.out.println("inserted successfully!");
                ResultSet rs = st.executeQuery(getData);

                while (rs.next()){
                    System.out.print("employee ID: "+ rs.getInt(1));
                    System.out.print(" | employee Name: "+ rs.getString(2));
                    System.out.print(" | employee Age: "+ rs.getInt(3));
                    System.out.print(" | employee Salary: "+ rs.getInt(4));
                    System.out.println();
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
