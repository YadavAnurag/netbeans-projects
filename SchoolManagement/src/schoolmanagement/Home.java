package schoolmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Home {
    public static JFrame frame; 
    private JLabel mainLbl, userNameLbl, userPassLbl, wrongLbl, captchaLbl,capInfoLbl;
    private JTextField nameField, userPass, captchaField;
    private JButton loginBtn, cancelBtn, forgotBtn, refreshBtn, staffLoginBtn, studentLoginBtn, administratorLoginBtn;
    
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
        mainLbl = new JLabel("Staff");
        staffLoginBtn = new JButton("Staff");
        studentLoginBtn  = new JButton("Student");
        administratorLoginBtn = new JButton("Administrator");
        userNameLbl = new JLabel("Username");
        nameField = new JTextField("");
        userPassLbl = new JLabel("Password");
        userPass = new JTextField("");
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
        staffLoginBtn.setBounds(500,80,120,25);
        studentLoginBtn.setBounds(500,120,120,25);
        administratorLoginBtn.setBounds(500,160,120,25);
        userNameLbl.setBounds(70,70,100,25);
        nameField.setBounds(200,70,180,25);
        userPassLbl.setBounds(70, 105, 100, 25);
        userPass.setBounds(200, 105, 180, 25);
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
        frame.add(staffLoginBtn);
        frame.add(studentLoginBtn);
        frame.add(administratorLoginBtn);
        frame.add(userNameLbl);
        frame.add(nameField);
        frame.add(userPassLbl);
        frame.add(userPass);
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
        staffLoginBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                mainLbl.setText("Staff");
            }
        });
        studentLoginBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                mainLbl.setText("Student");
            }
        });
        administratorLoginBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                mainLbl.setText("Administrator");
            }
        });
        loginBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
                if (nameField.getText().equals("") || userPass.getText().equals("") || captchaField.getText().equals("")) {
                    if (nameField.getText().equals("")) {
                        wrongLbl.setText("Username can't be empty");
                        wrongLbl.setVisible(true);
                        
                    }
                    else if(userPass.getText().equals("")){
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
                             case "Student":
                                 wrongLbl.setVisible(true);
                                 
                                 forgotBtn.setVisible(true);
                                 //StudentHome studentHome = new StudentHome();
                                 //frame.setVisible(false);
                                 break;
                             case "Staff":
                                 wrongLbl.setVisible(false);
                                 wrongLbl.setText("Wrong User Id or Password");
                                 wrongLbl.setVisible(true);
                                 forgotBtn.setVisible(true);
                                 //StaffHome staffHome = new StaffHome();
                                 //frame.setVisible(false);
                                 break;
                             case "Administrator":
                                 wrongLbl.setVisible(true);
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
