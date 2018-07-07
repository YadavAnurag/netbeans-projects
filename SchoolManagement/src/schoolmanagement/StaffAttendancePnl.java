package schoolmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class StaffAttendancePnl {
    
    static JPanel attendancePnl;
    private JLabel mainLbl, wrongLbl, enterDateLbl;
    private JTable table;
    private JScrollPane sp;
    JTextField showAttendanceField;
    private JButton uploadAttendanceBtn, showAttendanceBtn;
    DefaultTableModel model = new DefaultTableModel();
    
    Connection con = DatabaseConnection.connect();
    Statement stmt = null;
    ResultSet rs = null;
    
    public StaffAttendancePnl(){ 
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
        uploadAttendanceBtn = new JButton("Upload attendance");
        enterDateLbl = new JLabel("Enter Date");
        showAttendanceField = new JTextField("YYYY-MM-DD");
        showAttendanceBtn = new JButton("Show Attendance");
        showAttendance();
        //acedemic attendance setBounds
        mainLbl.setBounds(200,5,300,25);
        wrongLbl.setBounds(130, 40, 300, 25);
        sp.setBounds(0,100,800, 790);
        uploadAttendanceBtn.setBounds(sp.getWidth()+40, 180, 150, 25);
        enterDateLbl.setBounds(sp.getWidth()+80, 260, 150, 25);
        showAttendanceField.setBounds(sp.getWidth()+40, 290, 150, 25);
        showAttendanceBtn.setBounds(sp.getWidth()+40, 320, 150, 25);
        //academic attendance add
        attendancePnl.add(mainLbl);
        attendancePnl.add(wrongLbl);
        attendancePnl.add(uploadAttendanceBtn);
        attendancePnl.add(enterDateLbl);
        attendancePnl.add(showAttendanceField);
        attendancePnl.add(showAttendanceBtn);
        attendancePnl.add(sp);
        
        StaffHome.stp.addTab("Student Attendance", null, attendancePnl, "Student Attendance Panel");
        
        uploadAttendanceBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            
            }
        });
        showAttendanceBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            
            }
        });
        
        
    }
    void showAttendance(){
        
    }
    
}
