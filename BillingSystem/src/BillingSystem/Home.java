package BillingSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Home {
    public static JFrame frame; 
    private JLabel mainLbl, userIdLbl, userPassFieldLbl,  wrongLbl, captchaLbl,capInfoLbl;
    private JPasswordField  userPassField;
    private JTextField userIdField, captchaField;
    private JButton loginBtn, cancelBtn, forgotBtn, refreshBtn, cashierLoginBtn, adminLoginBtn;
    private JCheckBox showPassCb; 
    private char c;       
    //to make connection 
    Connection con = DatabaseConnection.connect();
    Statement stmt = null;
    ResultSet rs = null;
    public Home(){
        createGui();
    }
    void createGui(){
        frame = new JFrame("Home");
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.cyan);
        mainLbl = new JLabel("Cashier");
        cashierLoginBtn = new JButton("Cashier");
        adminLoginBtn = new JButton("Admin");
        userIdLbl = new JLabel("Username");
        userIdField = new JTextField("");
        userPassFieldLbl = new JLabel("Password");
        userPassField = new JPasswordField("");
        c = userPassField.getEchoChar();
        showPassCb = new JCheckBox("show password");
        showPassCb.setBackground(Color.cyan);
        capInfoLbl = new JLabel("Enter Below Code");
        captchaField = new JTextField("");
        captchaLbl = new JLabel(PasswordGenerator.generatePass(4));
        
        captchaLbl.setForeground(Color.blue);
        refreshBtn = new JButton("Refresh");
        loginBtn = new JButton("login");
        cancelBtn = new JButton("cancel");
        forgotBtn  = new JButton("Forgot Password");
        wrongLbl = new JLabel("wrong username or password");
        wrongLbl.setForeground(Color.red);
        
        
        mainLbl.setBounds(200,20,100,25);
        cashierLoginBtn.setBounds(500,100,120,25);
        adminLoginBtn.setBounds(500,140,120,25);
        userIdLbl.setBounds(70,60,100,25);
        userIdField.setBounds(200,60,180,25);
        userPassFieldLbl.setBounds(70, 90, 100, 25);
        userPassField.setBounds(200, 90, 180, 25);
        showPassCb.setBounds(200, 120, 180, 15);
        capInfoLbl.setBounds(70,140,100,25);
        captchaField.setBounds(200, 140, 180, 25);
        captchaLbl.setBounds(200, 180, 80, 25);
        refreshBtn.setBounds(300, 180, 80, 25);
        loginBtn.setBounds(100,270, 100, 25);
        cancelBtn.setBounds(230,270,100,25);
        wrongLbl.setBounds(146,300,200,25);
        forgotBtn.setBounds(150, 340, 150,25 );
        forgotBtn.setVisible(false);
        wrongLbl.setVisible(false);
        
        
        
        frame.add(mainLbl);
        frame.add(cashierLoginBtn);
        frame.add(adminLoginBtn);
        frame.add(userIdLbl);
        frame.add(userIdField);
        frame.add(userPassFieldLbl);
        frame.add(userPassField);
        frame.add(showPassCb);
        frame.add(capInfoLbl);
        frame.add(captchaField);
        frame.add(loginBtn);
        frame.add(cancelBtn);
        frame.add(wrongLbl);
        frame.add(forgotBtn);
        frame.add(captchaLbl);
        frame.add(refreshBtn);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        frame.setSize(screenSize.width/2,screenSize.height*3/5 );
        frame.setLocation(380, 150);
        frame.setResizable(false);
        frame.setLocationByPlatform(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        refreshBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                captchaLbl.setText(PasswordGenerator.generatePass(4));
            }
        });
        cashierLoginBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                mainLbl.setText("Staff");
            }
        });
        showPassCb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if (showPassCb.isSelected()) {
                    userPassField.setEchoChar((char)0);
                } else if(!showPassCb.isSelected()){
                    userPassField.setEchoChar(c);
                }
                else{
                
                }
            }
        });
        adminLoginBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                mainLbl.setText("Administrator");
            }
        });
        loginBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String pswd = new String(userPassField.getPassword());
                if (userIdField.getText().equals("") || pswd.equals("") || captchaField.getText().equals("")) {
                    if (userIdField.getText().equals("")) {
                        wrongLbl.setText("User Id can't be empty");
                        wrongLbl.setVisible(true);
                        
                    }
                    else if(pswd.equals("")){
                        wrongLbl.setText("Password can't be empty");
                        wrongLbl.setVisible(true);
                    }
                    else if(captchaField.getText().equals("")){
                        wrongLbl.setText("Please input generated catcha ");
                        wrongLbl.setVisible(true);
                    }
                } else {
                    if(!captchaField.getText().equals(captchaLbl.getText())){
                        wrongLbl.setText("Captch does not matched ");
                        wrongLbl.setVisible(true);
                        captchaLbl.setText(PasswordGenerator.generatePass(4));
                    } else {
                        //database connectivity code
                         String str = mainLbl.getText();
                         switch(str){
                             case "Cashier":
                                 JOptionPane.showMessageDialog(frame, "Wrong User Id or Password", "Non matching", 0, null);
                                 forgotBtn.setVisible(true);
                                 //StudentHome studentHome = new StudentHome();
                                 //frame.setVisible(false);
                                 break;
                             case "Admin":
                                 JOptionPane.showMessageDialog(frame, "Wrong User Id or Password", "Non matching", 0, null);
                                 forgotBtn.setVisible(true);
                                 //AdminHome adminHome = new AdminHome();
                                 //frame.setVisible(false);
                                 break;
                             default:
                                 JOptionPane.showMessageDialog(frame, "Wrong User Id or Password", "Non matching", 0, null);
                                 
                         }
                        wrongLbl.setVisible(false);
                    }
                }
            }
        });
        
        cancelBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                System.exit(0);
            }
        });
        
        forgotBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Home.frame.setVisible(false);
                ForgotPassword forgotPassword = new ForgotPassword();
                
            }
        });
       
    }
    
    public static void main(String []args){
        Runnable runner = new Runnable(){
            public void run(){
                new Home();
            }
        };
        EventQueue.invokeLater(runner);
    }
}

