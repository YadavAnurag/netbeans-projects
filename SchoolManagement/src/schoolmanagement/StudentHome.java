package schoolmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentHome {
    static JFrame frame;
    static JTabbedPane stp;
    JLabel  mainLbl;
    JButton homeBtn, logoutBtn, academicBtn, examBtn, otherBtn;
    
    //to make connection 
    Connection con = DatabaseConnection.connect();
    Statement stmt = null;
    ResultSet rs = null;
    public StudentHome(){
        createGui();
    }
    void createGui(){
        Toolkit kit  = Toolkit.getDefaultToolkit();
        Dimension d = kit.getScreenSize();
        frame = new JFrame("Student Corner");
        frame.setLayout(null);
        mainLbl = new JLabel("Student Setion");
        homeBtn = new JButton("Home");
        logoutBtn = new JButton("Logout");
        academicBtn = new JButton("Academic");
        examBtn = new JButton("Examination");
        otherBtn = new JButton("Other");
        stp =  new JTabbedPane();
        
        
        //stp bounds
        stp.setBounds(20,80, d.width*8/10,d.height*8/10);
        StudentAttendancePnl studentAttendancePnl = new StudentAttendancePnl();
        StudentRegFormPnl studentRegFormPnl = new StudentRegFormPnl();
        StudentMarksPnl studentMarksPnl = new StudentMarksPnl();
        StudentComplainPnl studentComplainPnl = new StudentComplainPnl();
        StudentChangePasswordPnl studentChangePasswordPnl = new StudentChangePasswordPnl();
        mainLbl.setBounds(250, 20, 200, 25);
        homeBtn.setBounds(800,20,100,25);
        logoutBtn.setBounds(920,20,100,25);
        academicBtn.setBounds(stp.getWidth()+70, 200, 120, 25);
        examBtn.setBounds(stp.getWidth()+70, 240,120,25);
        otherBtn.setBounds(stp.getWidth()+70, 280, 120, 25);
        
        
        frame.add(mainLbl);
        frame.add(homeBtn);
        frame.add(logoutBtn);
        frame.add(academicBtn);
        frame.add(examBtn);
        frame.add(otherBtn);
        frame.add(stp);
        frame.setSize(d.width, d.height);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        
        
        
        homeBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
            }     
        });
        logoutBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               frame.setVisible(false);
               Home home = new Home();
            }     
        });
        //action listener
        academicBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                stp.removeAll();
                stp.addTab("Attendence",null,StudentAttendancePnl.attendancePnl, "Your Attendence");
                stp.addTab("Registration Form",null,studentRegFormPnl.regFormPnl,"Rgistration Form");
                mainLbl.setText("Acedemic Details");
            }
        });
        examBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                stp.removeAll();
                stp.addTab("Marks Details", null, studentMarksPnl.marksPnl, "Your Marks");
                mainLbl.setText("Examination Details");
            }     
        });
        otherBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                stp.removeAll();
                stp.addTab("Complain", null, studentComplainPnl.complainPnl, "Your complain");
                stp.addTab("Change Password", null, studentChangePasswordPnl.changePassPnl, "Change Your Password");
                mainLbl.setText("Other");
            }     
        });
        
    }
    public static void main(String []args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                StudentHome studentHome = new StudentHome();
                System.out.println("set it to dispose on close");
            }
        });
        
    }
}
