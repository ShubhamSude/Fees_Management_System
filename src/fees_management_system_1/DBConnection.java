/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fees_management_system_1;
import java.sql.*;
/**
 *
 * @author shubham
 */
public class DBConnection {
    public static Connection getConnection(){
        Connection con=null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management", "root", "Shubhu@2001");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
