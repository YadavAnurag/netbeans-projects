package schoolmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StaffHome {
    static JFrame frame;
    static JTabbedPane stp;
    JLabel  mainLbl;
    JButton staffHomeBtn, staffLogoutBtn, staffAcademicBtn, staffExamBtn, staffOtherBtn;
    
    //to make connection 
    Connection con = DatabaseConnection.connect();
    Statement stmt = null;
    ResultSet rs = null;
    public StaffHome(){
        createGui();
    }
    void createGui(){
        Toolkit kit  = Toolkit.getDefaultToolkit();
        Dimension d = kit.getScreenSize();
        frame = new JFrame("Staff Corner");
        frame.setLayout(null);
        mainLbl = new JLabel("Staff Setion");
        staffHomeBtn = new JButton("Home");
        staffLogoutBtn = new JButton("Logout");
        staffAcademicBtn = new JButton("Academic");
        staffExamBtn = new JButton("Examination");
        staffOtherBtn = new JButton("Other");
        stp =  new JTabbedPane();
        
        
        //stp bounds
        stp.setBounds(20,80, d.width*8/10,d.height*8/10);
        StaffAttendancePnl staffAttendancePnl = new StaffAttendancePnl();
        StaffRegFormPnl staffRegFormPnl = new StaffRegFormPnl();
        StaffMarksPnl staffMarksPnl = new StaffMarksPnl();
        StaffComplainPnl staffComplainPnl = new StaffComplainPnl();
        StaffChangePassword staffChangePassword = new StaffChangePassword();
        mainLbl.setBounds(250, 20, 200, 25);
        staffHomeBtn.setBounds(800,20,100,25);
        staffLogoutBtn.setBounds(920,20,100,25);
        staffAcademicBtn.setBounds(stp.getWidth()+70, 200, 120, 25);
        staffExamBtn.setBounds(stp.getWidth()+70, 240,120,25);
        staffOtherBtn.setBounds(stp.getWidth()+70, 280, 120, 25);
        
        
        frame.add(mainLbl);
        frame.add(staffHomeBtn);
        frame.add(staffLogoutBtn);
        frame.add(staffAcademicBtn);
        frame.add(staffExamBtn);
        frame.add(staffOtherBtn);
        frame.add(stp);
        frame.setSize(d.width, d.height);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        
        
        
        staffHomeBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
            }     
        });
        staffLogoutBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               frame.setVisible(false);
               Home home = new Home();
            }     
        });
        //action listener
        staffAcademicBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                stp.removeAll();
                stp.addTab("Attendence",null,StaffAttendancePnl.attendancePnl, "Your Attendence");
                stp.addTab("Registration Form",null,StaffRegFormPnl.regFormPnl,"Rgistration Form");
                mainLbl.setText("Acedemic Details");
            }
        });
        staffExamBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                stp.removeAll();
                stp.addTab("Marks Details", null, StaffMarksPnl.marksPnl, "Your Marks");
                mainLbl.setText("Examination Details");
            }     
        });
        staffOtherBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                stp.removeAll();
                stp.addTab("Complain", null, StaffComplainPnl.complainPnl, "Your complain");
                stp.addTab("Change Password", null, StaffChangePassword.changePassPnl, "Change Your Password");
                mainLbl.setText("Other");
            }     
        });
        
    }
    public static void main(String []args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                StaffHome staffHome = new StaffHome();
                System.out.println("set it to dispose on close");
            }
        });
        
    }
}
