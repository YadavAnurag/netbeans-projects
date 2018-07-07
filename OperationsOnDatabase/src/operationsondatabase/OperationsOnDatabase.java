
package operationsondatabase;
import java.sql.*;
import java.util.*;
public class OperationsOnDatabase {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/schoolmanagement";
    static final String USER = "root";
    static final String PASSWORD = "anuragtoor";
    public static void main(String[] args) {
        // TODO code application logic here
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        String databaseName = null;
        String tableName = null;
        Scanner sc = new Scanner(System.in);
        try{
            //registering the driver
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                System.err.println(e);
            }
            //opening connection
            System.out.println("Connecting to the datbase...");
            con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            System.out.println("connected");
            //preparing and executing sql statement
           
            //System.out.println("Enter the new database name");
            //databaseName = sc.next();
            //databaseName = "jdbcdatabase";
            //String sql  = "create database "+databaseName;
           
           
           //displaying the data
           //String sql = "select att_id , id , (select name from site1 where newsite.id = 1)from  newsite";
            stmt = con.createStatement();
            String sql = " select user_id from users where user_id = 20160004";           
            rs = stmt.executeQuery(sql);          
            while(rs.next()){
                System.out.println("checking");
                int n = rs.getInt(1);
                System.out.println( n);
                //int n = rs.getInt(1);
                //String dataName  = rs.getInt(3);
                //String dataEmail = rs.getString("email");
                //long dataNumber  = rs.getLong("mobile");
                
                //displayig values
               // System.out.println("\n"+ n);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
