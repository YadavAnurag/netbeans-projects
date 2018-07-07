
package schoolmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
public class AdminMarksPnl {
    
    static JPanel marksPnl;
    private JLabel mainLbl, userIdLbl, userId, studentNameLbl, studentName,  wrongLbl;
    private JTable table;
    private JScrollPane sp;
    DefaultTableModel model = new DefaultTableModel();
    
    Connection con = DatabaseConnection.connect();
    Statement stmt = null;
    ResultSet rs = null;
    
    public AdminMarksPnl(){ 
        createGui();
    }
    void createGui(){
        marksPnl = new JPanel();
        marksPnl.setLayout(null);
        
        mainLbl = new JLabel("Student Marks Details");
        userIdLbl = new JLabel("User  Id:");
        userId  = new JLabel("sdf");
        studentNameLbl = new JLabel("Student Name:");
        studentName = new JLabel("safd");
        //awrongLbl = new JLabel("this is your Attendance php 70%");
        table = new JTable(model);
        model.addColumn("Date");
        model.addColumn("User Id");
        model.addColumn("Java");
        model.addColumn("Database");
        model.addColumn("Networking");
        model.addColumn("PHP");
        model.addColumn("Java Lab");
        sp = new JScrollPane(table);
        showMarks();
        //acedemic attendance setBounds
        mainLbl.setBounds(200,5,300,25);
        userIdLbl.setBounds(20, 40, 100, 25);
        userId.setBounds(130, 40, 100, 25);
        studentNameLbl.setBounds(20, 70, 100, 25);
        studentName.setBounds(130, 70, 100, 25);
        sp.setBounds(0,100,800, 790);
        //academic attendance add
        marksPnl.add(mainLbl);
        marksPnl.add(userIdLbl);
        marksPnl.add(userId);
        marksPnl.add(studentNameLbl);
        marksPnl.add(studentName);
        marksPnl.add(sp);
    }
    void showMarks(){
        
    }
    
}
