

package schoolmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminHome {
    static JFrame frame;
    static JTabbedPane atp;
    JLabel  mainLbl;
    JButton adminHomeBtn, adminLogoutBtn, adminAcademicBtn, adminExamBtn, adminOtherBtn;
    
    
    //to make connection 
    Connection con = DatabaseConnection.connect();
    Statement stmt = null;
    ResultSet rs = null;
    public AdminHome(){
        createGui();
    }
    void createGui(){
        Toolkit kit  = Toolkit.getDefaultToolkit();
        Dimension d = kit.getScreenSize();
        frame = new JFrame("Admin");
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.cyan);
        mainLbl = new JLabel("Admin Setion");
        adminHomeBtn = new JButton("Home");
        adminLogoutBtn = new JButton("Logout");
        adminAcademicBtn = new JButton("Academic");
        adminExamBtn = new JButton("Examination");
        adminOtherBtn = new JButton("Other");
        atp =  new JTabbedPane();
        atp.setBackground(Color.white);
        
        
        //stp bounds
        atp.setBounds(20,80, d.width*8/10,d.height*8/10);
        AdminAttendancePnl adminAttendancePnl = new AdminAttendancePnl();
        AdminRegFormPnl adminRegFormPnl = new AdminRegFormPnl();
        AdminFeePnl adminFeePnl = new AdminFeePnl();
        AdminMarksPnl adminMarksPnl = new AdminMarksPnl();
        AdminComplainPnl adminComplainPnl = new AdminComplainPnl();
        AdminChangePasswordPnl adminChangePasswordPnl = new AdminChangePasswordPnl();
        mainLbl.setBounds(250, 20, 200, 25);
        adminHomeBtn.setBounds(800,20,100,25);
        adminLogoutBtn.setBounds(920,20,100,25);
        adminAcademicBtn.setBounds(atp.getWidth()+70, 200, 120, 25);
        adminExamBtn.setBounds(atp.getWidth()+70, 240,120,25);
        adminOtherBtn.setBounds(atp.getWidth()+70, 280, 120, 25);
        
        
        frame.add(mainLbl);
        frame.add(adminHomeBtn);
        frame.add(adminLogoutBtn);
        frame.add(adminAcademicBtn);
        frame.add(adminExamBtn);
        frame.add(adminOtherBtn);
        frame.add(atp);
        frame.setSize(d.width, d.height);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        
        
        
        adminHomeBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
            }     
        });
        adminLogoutBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               frame.setVisible(false);
               Home home = new Home();
            }     
        });
        //action listener
        adminAcademicBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                atp.removeAll();
                atp.addTab("Attendence",null,AdminAttendancePnl.attendancePnl, "Attendance Details");
                atp.addTab("Registration Form",null,AdminRegFormPnl.regFormPnl,"Rgistration Form");
                mainLbl.setText("Acedemic Details");
            }
        });
        adminExamBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                atp.removeAll();
                atp.addTab("Marks Details", null, AdminMarksPnl.marksPnl, "Marks Details");
                mainLbl.setText("Examination Details");
            }     
        });
        adminOtherBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                atp.removeAll();
                atp.addTab("Complains", null, AdminComplainPnl.complainPnl, "All Complains Details");
                atp.addTab("Change Password", null, adminChangePasswordPnl.changePassPnl, "Change Your Password");
                mainLbl.setText("Other");
            }     
        });
        
    }
    public static void main(String []args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                AdminHome adminHome = new AdminHome();
            }
        });
        
    }
}
