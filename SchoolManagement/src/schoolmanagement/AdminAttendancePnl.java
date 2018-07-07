package schoolmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class AdminAttendancePnl {
    
    static JPanel attendancePnl;
    private JLabel mainLbl, userIdLbl, userId, studentNameLbl, studentName,  wrongLbl, enterUserIdLbl;
    private JTextField enterUserIdField;
    private JButton showAttendanceBtn;
    private JTable table;
    private JScrollPane sp;
    DefaultTableModel model = new DefaultTableModel();
    
    Connection con = DatabaseConnection.connect();
    Statement stmt = null;
    ResultSet rs = null;
    
    public AdminAttendancePnl(){ 
        createGui();
    }
    void createGui(){
        attendancePnl = new JPanel();
        attendancePnl.setLayout(null);
        attendancePnl.setBackground(Color.white);
        //academic attedance init
        mainLbl = new JLabel("Student Attendance");
        wrongLbl = new JLabel("Any wrong info goes here");
        wrongLbl.setForeground(Color.red);
        wrongLbl.setVisible(false);
        userIdLbl = new JLabel("User  Id:");
        userIdLbl.setVisible(false);
        userId  = new JLabel("sdf");
        userId.setVisible(false);
        studentNameLbl = new JLabel("Student Name:");
        studentNameLbl.setVisible(false);
        studentName = new JLabel("safd");
        studentName.setVisible(false);
        enterUserIdLbl = new JLabel("Enter User Id");
        enterUserIdField = new JTextField("");
        showAttendanceBtn = new JButton("Show Attendance");
        table = new JTable(model);
        table.setBackground(Color.white);
        
        model.addColumn("Date");
        model.addColumn("User Id");
        model.addColumn("Java");
        model.addColumn("Database");
        model.addColumn("Networking");
        model.addColumn("PHP");
        model.addColumn("Java Lab");
        sp = new JScrollPane(table);
        sp.setBackground(Color.white);
        showAttendance();
        //acedemic attendance setBounds
        mainLbl.setBounds(200,5,300,25);
        userIdLbl.setBounds(20, 40, 100, 25);
        userId.setBounds(130, 40, 100, 25);
        studentNameLbl.setBounds(20, 70, 100, 25);
        studentName.setBounds(130, 70, 100, 25);
        wrongLbl.setBounds(230, 70, 200, 25);
        sp.setBounds(0,100,800, 790);
        enterUserIdLbl.setBounds(sp.getWidth()+95, 200, 120, 25);
        enterUserIdField.setBounds(sp.getWidth()+70, 240, 150, 25);
        showAttendanceBtn.setBounds(sp.getWidth()+70, 275, 150, 25);
       
        
        //academic attendance add
        attendancePnl.add(mainLbl);
        attendancePnl.add(userIdLbl);
        attendancePnl.add(userId);
        attendancePnl.add(studentNameLbl);
        attendancePnl.add(studentName);
        attendancePnl.add(wrongLbl);
        attendancePnl.add(sp);
        attendancePnl.add(enterUserIdLbl);
        attendancePnl.add(enterUserIdField);
        attendancePnl.add(showAttendanceBtn);
        
        AdminHome.atp.addTab("Student Attendance", null, attendancePnl, "Student Attendance Panel");
        
        showAttendanceBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                userIdLbl.setVisible(true);
                userId.setText(enterUserIdField.getText());
                userId.setVisible(true);
                studentNameLbl.setVisible(true);
                studentName.setVisible(true);
            }
        });
    }
    void showAttendance(){
        
    }
    
}
