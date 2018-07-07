package schoolmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ForgotPassword {
    public static JFrame frame; 
    private JLabel mainLbl, userIdLbl, userNameLbl, dobLbl, emailIdLLbl, wrongLbl, captchaLbl,capInfoLbl,newPassLbl, confirmPassLbl;
    private JTextField userIdField, nameField, dobField, emailIdField, captchaField,capInfoField, newPassField, confirmPassField;
    private JButton submitBtn, refreshBtn, returnBtn;
    
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
        mainLbl = new JLabel("Forget Password");
        userIdLbl = new JLabel("User Id");
        userIdField = new JTextField("");
        userNameLbl = new JLabel("Username");
        nameField = new JTextField("");
        dobLbl = new JLabel("Date of Birth");
        dobField = new JTextField("YYYY-MM-DD");
        emailIdLLbl = new JLabel("Email ID");
        emailIdField = new JTextField("");
        capInfoLbl = new JLabel("Enter Below Code");
        capInfoField = new JTextField("");
        newPassLbl = new JLabel("New Password");
        newPassField = new JTextField("");
        confirmPassLbl = new JLabel("Confirm Password");
        confirmPassField = new JTextField("");
        captchaLbl = new JLabel(PasswordGenerator.generatePass(4));
        captchaLbl.setForeground(Color.blue);
        refreshBtn = new JButton("Refresh");
        submitBtn = new JButton("submit");
        returnBtn = new JButton("Return");
        wrongLbl = new JLabel("Wrong info Provided");
        
        
        
        mainLbl.setBounds(170,20,150,25);
        userIdLbl.setBounds(70,70,100,25);
        userIdField.setBounds(200,70, 180, 25);
        userNameLbl.setBounds(70,100,100,25);
        nameField.setBounds(200,100,180,25);
        dobLbl.setBounds(70, 130, 100, 25);
        dobField.setBounds(200, 130, 180, 25);
        emailIdLLbl.setBounds(70,160,100,25);
        emailIdField.setBounds(200,160,180,25);
        newPassLbl.setBounds(70,190,100,25);
        newPassField.setBounds(200, 190, 180, 25);
        confirmPassLbl.setBounds(70,220,120,25);
        confirmPassField.setBounds(200,220,180,25);
        capInfoLbl.setBounds(70,250,120,25);
        capInfoField.setBounds(200,250,180,25);
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
        frame.add(nameField);
        frame.add(dobLbl);
        frame.add(dobField);
        frame.add(emailIdLLbl);
        frame.add(emailIdField);
        frame.add(capInfoLbl);
        frame.add(capInfoField);
        frame.add(newPassLbl);
        frame.add(newPassField);
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
                dobField.setText("YYYY-MM-DD");
            }
        });
        refreshBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                captchaLbl.setText(PasswordGenerator.generatePass(4));
            }
        });
        submitBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement","root","anuragtoor");
                    
                } catch (Exception e) {
                    System.out.println("Cannot connect to database\n"+e);
                }
            }
        });
        
        returnBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Home.frame.setVisible(true);
                ForgotPassword.frame.setVisible(false);
            }
        });
        
    }
    public static void main(String []args){
        ForgotPassword fg = new ForgotPassword();
    }
}
