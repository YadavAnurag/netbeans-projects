package schoolmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class StudentAttendancePnl {
    
    static JPanel attendancePnl;
    private JLabel mainLbl, wrongLbl;
    private JTable table;
    private JScrollPane sp;
    DefaultTableModel model = new DefaultTableModel();
    
    Connection con = DatabaseConnection.connect();
    Statement stmt = null;
    ResultSet rs = null;
    
    public StudentAttendancePnl(){ 
        createGui();
    }
    void createGui(){
        attendancePnl = new JPanel();
        attendancePnl.setLayout(null);
        
        //academic attedance init
        mainLbl = new JLabel("Student Attendance");
        wrongLbl = new JLabel("any wrong infomation");
        wrongLbl.setForeground(Color.red);
        wrongLbl.setVisible(false);
        table = new JTable(model);
        model.addColumn("Date");
        model.addColumn("User id");
        model.addColumn("Java");
        model.addColumn("Database");
        model.addColumn("Networking");
        model.addColumn("PHP");
        model.addColumn("Java Lab");
        sp = new JScrollPane(table);
        showAttendance();
        //acedemic attendance setBounds
        mainLbl.setBounds(200,5,300,25);
        wrongLbl.setBounds(130, 40, 300, 25);
        sp.setBounds(0,100,800, 790);
        //academic attendance add
        attendancePnl.add(mainLbl);
        attendancePnl.add(wrongLbl);
        attendancePnl.add(sp);
        
        StudentHome.stp.addTab("Your Attendance", null, attendancePnl, "Student Attendance Panel");
        
        
    }
    void showAttendance(){
    
    }
    
}
