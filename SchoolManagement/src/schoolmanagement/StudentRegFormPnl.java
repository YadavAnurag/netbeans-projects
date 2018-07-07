package schoolmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentRegFormPnl {
    
    static JPanel regFormPnl;
    private JLabel wrongLbl, mainLbl, userIdLbl,semLbl, yearLbl, branchLbl, firstNameLbl, middleNameLbl, lastNameLbl, dobLbl, birthPlaceLbl, ageLbl, genderLbl, statusLbl, guardianLbl, relationLbl, addressLbl, contactLbl, emailLbl;
    private JTextField userIdField, firstNameField, middleNameField, lastNameField, dobField,birthPlaceField, guardianField, relationField, contactField,emailField ;
    private String semStr[] = {"Select", "Even Semester", "Odd Semester" };
    private String yearStr[] = {"Select", "First Year", "Second Year", "Third Year", "Final Year"};
    private String branchStr[] = {"Select", "Chemical Engineering", "Civil Engineering", "Computer Science and Engineering", "Electronics Engineering", "Electrical Engineering", "Mechanical Engineering"};
    private String ageStr[] = {"Select", "16","17","18","19","20", "21","22","23", "24","25","26"};
    private String statusStr[] = {"Select", "Single", "Married"};
    private JTextArea addressArea;
    private JRadioButton mrb,frb;
    private JComboBox semCb, yearCb, branchCb, ageCb, statusCb; 
    private JButton sendForApprovalBtn;
    
    Connection con = DatabaseConnection.connect();
    Statement stmt = null;
    ResultSet rs = null;
    
    public StudentRegFormPnl(){ 
        createGui();
    }
    void createGui(){
        regFormPnl = new JPanel();
        regFormPnl.setLayout(null);
        
        //academic reginstration form
        wrongLbl = new JLabel("Has been sent for Approval");
        wrongLbl.setForeground(Color.green);
        wrongLbl.setVisible(false);
        mainLbl = new JLabel("Student Rgistration Form");
        userIdLbl = new JLabel("User Id");
        userIdField = new JTextField("");
        semLbl = new JLabel("Semester");
        semCb  = new JComboBox(semStr);
        yearLbl = new JLabel("Year");
        yearCb = new JComboBox(yearStr);
        branchLbl = new JLabel("Branch");
        branchCb = new JComboBox(branchStr);
        firstNameLbl = new JLabel("First Name");
        firstNameField = new JTextField("");
        middleNameLbl = new JLabel("Middle Name");
        middleNameField = new JTextField("");
        lastNameLbl = new JLabel("Last Name");
        lastNameField = new JTextField("");
        dobLbl = new JLabel("Date of Birth");
        dobField = new JTextField("YYYY-MM-DD");
        birthPlaceLbl = new JLabel("Place of Birth");
        birthPlaceField = new JTextField("");
        ageLbl = new JLabel("Age");
        ageCb = new JComboBox(ageStr);
        genderLbl  = new JLabel("Gender");
        mrb = new JRadioButton("Male");
        frb = new JRadioButton("Female");
        statusLbl  = new JLabel("Status");
        statusCb = new JComboBox(statusStr);
        guardianLbl = new JLabel("Guardian");
        guardianField = new JTextField("");
        relationLbl = new JLabel("Relation");
        relationField  = new JTextField("");
        addressLbl  = new JLabel("Address");
        addressArea = new JTextArea("");
        contactLbl = new JLabel("Mobile No.");
        contactField = new JTextField("");
        emailLbl = new JLabel("Email");
        emailField = new JTextField("");
        sendForApprovalBtn = new JButton("Send for Approval");
        
       //academic reg form bounds
        mainLbl.setBounds(400, 30, 200, 30);
        userIdLbl.setBounds(30,100,100,30);
        userIdField.setBounds(120,100,150,25);
        semLbl.setBounds(300,100,80,30);
        semCb.setBounds(380,100,120,30);
        yearLbl.setBounds(520,100,60,30);
        yearCb.setBounds(580,100,120,30);
        branchLbl.setBounds(720,100,70,30);
        branchCb.setBounds(810,100,220,30);
        firstNameLbl.setBounds(30,140,100,30);
        firstNameField.setBounds(120,140,150,25);
        middleNameLbl.setBounds(300,140,80,30);
        middleNameField.setBounds(390,140,150,25);
        lastNameLbl.setBounds(550,140,80,30);
        lastNameField.setBounds(630,140,150,25);
        dobLbl.setBounds(30,180,100,30);
        dobField.setBounds(120,180,150,25);
        birthPlaceLbl.setBounds(300,180,80,30);
        birthPlaceField.setBounds(390,180,150,25);
        ageLbl.setBounds(30,220,60,30);
        ageCb.setBounds(120,220,120,30);
        genderLbl.setBounds(30,260,80,30);
        mrb.setBounds(120,260,80,30);
        frb.setBounds(200,260,80,30);
        statusLbl.setBounds(300,260,80,30);
        statusCb.setBounds(390,260,150,30);
        guardianLbl.setBounds(30,300,80,30);
        guardianField.setBounds(120,300,150,25);
        relationLbl.setBounds(300,300,80,30);
        relationField.setBounds(390,300,150,25);
        addressLbl.setBounds(30,340,80,30);
        addressArea.setBounds(120,340,300,80);
        contactLbl.setBounds(30,440, 100, 30);
        contactField.setBounds(120,440,150,25);
        emailLbl.setBounds(30,485,100,30);
        emailField.setBounds(120,485,150,25);
        sendForApprovalBtn.setBounds(250, 550, 150, 25);
        wrongLbl.setBounds(450, 550, 200, 25);
        
        //academic reg form add
        regFormPnl.add(mainLbl);
        regFormPnl.add(userIdLbl);
        regFormPnl.add(userIdField);
        regFormPnl.add(semLbl);
        regFormPnl.add(semCb);
        regFormPnl.add(yearLbl);
        regFormPnl.add(yearCb);
        regFormPnl.add(branchLbl);
        regFormPnl.add(branchCb);
        regFormPnl.add(firstNameLbl);
        regFormPnl.add(firstNameField);
        regFormPnl.add(middleNameLbl);
        regFormPnl.add(middleNameField);
        regFormPnl.add(lastNameLbl);
        regFormPnl.add(lastNameField);
        regFormPnl.add(dobLbl);
        regFormPnl.add(dobField);
        regFormPnl.add(birthPlaceLbl);
        regFormPnl.add(birthPlaceField);
        regFormPnl.add(ageLbl);
        regFormPnl.add(ageCb);
        regFormPnl.add(genderLbl);
        regFormPnl.add(mrb);
        regFormPnl.add(frb);
        regFormPnl.add(statusLbl);
        regFormPnl.add(statusCb);
        regFormPnl.add(guardianLbl);
        regFormPnl.add(guardianField);
        regFormPnl.add(relationLbl);
        regFormPnl.add(relationField);
        regFormPnl.add(addressLbl);
        regFormPnl.add(addressArea);
        regFormPnl.add(contactLbl);
        regFormPnl.add(contactField);
        regFormPnl.add(emailLbl);
        regFormPnl.add(emailField);
        regFormPnl.add(sendForApprovalBtn);
        regFormPnl.add(wrongLbl);
        //academic reg form add close
        
        StudentHome.stp.addTab("Registration Form", null, regFormPnl, "Your Registration Form");
        
        sendForApprovalBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                wrongLbl.setText("Has been sent for Approval");
                wrongLbl.setVisible(true);
                sendForApprovalBtn.setEnabled(false);
            }
        });
        
    }
    
}
