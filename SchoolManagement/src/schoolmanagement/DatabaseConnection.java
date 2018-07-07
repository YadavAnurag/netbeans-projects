package schoolmanagement;
import java.sql.*;
import javax.swing.*;
public class DatabaseConnection {
    public static Connection con;
    public static Connection connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement", "root", "anuragtoor");
            return con;
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Database connection does not establish", "Database Connection", JOptionPane.ERROR_MESSAGE, null);
            return null;
        }
    }
}
