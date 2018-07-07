package BillingSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ForgotPassword {
    public static JFrame frame; 
    private JLabel mainLbl, userIdLbl, userNameLbl, dobLbl, emailIdLLbl, wrongLbl, captchaLbl,capInfoLbl,newPassLbl, confirmPassLbl;
    private JTextField userIdField, userNameField, dobField, emailIdField, captchaField;
    private JPasswordField  newPassField, confirmPassField;
    private JButton submitBtn, refreshBtn, returnBtn;
    private JCheckBox showPassCb;
    private char c;
    //to make connection 
    Connection con = DatabaseConnection.connect();
    Statement stmt = null;
    ResultSet rs = null;
    public ForgotPassword(){
        createGui();
    }
    void createGui(){
        frame = new JFrame("ForgotPassword");
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.cyan);
        mainLbl = new JLabel("Forget Password");
        userIdLbl = new JLabel("User Id");
        userIdField = new JTextField("");
        userNameLbl = new JLabel("Username");
        userNameField = new JTextField("");
        dobLbl = new JLabel("Date of Birth");
        dobField = new JTextField("YYYY-MM-DD");
        emailIdLLbl = new JLabel("Email ID");
        emailIdField = new JTextField("");
        capInfoLbl = new JLabel("Enter Below Code");
        captchaField = new JTextField("");
        newPassLbl = new JLabel("New Password");
        newPassField = new JPasswordField("");
        c = newPassField.getEchoChar();
        showPassCb = new JCheckBox("show password");
        showPassCb.setBackground(Color.cyan);
        confirmPassLbl = new JLabel("Confirm Password");
        confirmPassField = new JPasswordField("");
        captchaLbl = new JLabel(PasswordGenerator.generatePass(4));
        captchaLbl.setForeground(Color.blue);
        refreshBtn = new JButton("Refresh");
        submitBtn = new JButton("submit");
        returnBtn = new JButton("Return");
        wrongLbl = new JLabel("Wrong info Provided");
        
        
        
        mainLbl.setBounds(170,20,135,25);
        userIdLbl.setBounds(70,60,100,25);
        userIdField.setBounds(200,60, 180, 25);
        userNameLbl.setBounds(70,90,100,25);
        userNameField.setBounds(200,90,180,25);
        dobLbl.setBounds(70, 120, 100, 25);
        dobField.setBounds(200, 120, 180, 25);
        emailIdLLbl.setBounds(70,150,100,25);
        emailIdField.setBounds(200,150,180,25);
        newPassLbl.setBounds(70,180,100,25);
        newPassField.setBounds(200, 180, 180, 25);
        showPassCb.setBounds(200, 206, 180, 13);
        confirmPassLbl.setBounds(70,220,120,25);
        confirmPassField.setBounds(200,223,180,25);
        capInfoLbl.setBounds(70,250,120,25);
        captchaField.setBounds(200,250,180,25);
        captchaLbl.setBounds(200, 280, 80, 25);
        refreshBtn.setBounds(300, 280, 80, 25);
        submitBtn.setBounds(100,340, 100, 25);
        returnBtn.setBounds(230,340,100,25);
        wrongLbl.setBounds(140,370,200,25);
        
        wrongLbl.setForeground(Color.red);
        wrongLbl.setVisible(false);
        
        
        frame.add(mainLbl);
        frame.add(userIdLbl);
        frame.add(userIdField);
        frame.add(userNameLbl);
        frame.add(userNameField);
        frame.add(dobLbl);
        frame.add(dobField);
        frame.add(emailIdLLbl);
        frame.add(emailIdField);
        frame.add(capInfoLbl);
        frame.add(captchaField);
        frame.add(newPassLbl);
        frame.add(newPassField);
        frame.add(showPassCb);
        frame.add(confirmPassLbl);
        frame.add(confirmPassField);
        frame.add(submitBtn);
        frame.add(returnBtn);
        frame.add(wrongLbl);
        frame.add(captchaLbl);
        frame.add(refreshBtn);
        
        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        frame.setSize(screenSize.width/3,screenSize.height*3/5 );
        frame.setLocation(380, 150);
        frame.setResizable(false);
        frame.setLocationByPlatform(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        
        
        dobField.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent fe){
                dobField.setText("");
            }
            public void focusLost(FocusEvent fe){
                //dobField.setText("YYYY-MM-DD");
            }
        });
        refreshBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                captchaLbl.setText(PasswordGenerator.generatePass(4));
            }
        });
        submitBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String newPass, confirmPass;
                newPass = new String(newPassField.getPassword());
                confirmPass = new String(confirmPassField.getPassword());
                if (true) {
                    if (userIdField.getText().equals("")) {
                        wrongLbl.setText("user id can't be empty");
                        wrongLbl.setVisible(true);
                    }
                    if (userNameField.getText().equals("")) {
                        wrongLbl.setText("username can't be empty");
                        wrongLbl.setVisible(true);
                    }
                    if (dobField.getText().equals("YYYY-MM-DD")) {
                        wrongLbl.setText("Date of Birth can't be empty");
                        wrongLbl.setVisible(true);
                    }
                    
                    
                } else {
                }
            }
        });
        
    }
    public static void main(String []args){
        ForgotPassword fg = new ForgotPassword();
    }
}
