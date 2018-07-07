package jdbcapplication;
import java.sql.*;
public class JDBCApplication {

    /**
     * @param args the command line arguments
     */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/jdbcdatabase?zeroDateTimeBehavior=convertToNull";
    
    static final String USER = "root";
    static final String PASS = "mysqlpswd";
    
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //registering jdbc driver
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            }
            
            //opening  connection
            System.out.println("Connection to database...");
            con = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //execute a query
            System.out.println("Creating statement....");
            stmt = con.createStatement();
            String sql;
            sql = "select id , first, last, age from employees";
            rs = stmt.executeQuery(sql);
            
            //extracting data form resultset
            while(rs.next()){
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");
                
                //display values 
                System.out.println("ID: "+id+"\n Age :"+age+"\n First Name :"+first+"\nLast Name :"+last);    
            }
            //clean-Up environment
             rs.close();
                stmt.close();
                con.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{     
        }
    }
    
}
