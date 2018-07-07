package schoolmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class AdminChangePasswordPnl {
    
    static JPanel changePassPnl;
    private JLabel mainLbl, userIdLbl, currentPassLbl, wrongLbl, captchaLbl,capInfoLbl,newPassLbl, confirmPassLbl;
    private JTextField userIdField, currentPassField, captchaField, newPassField, confirmPassField;
    private JButton submitBtn, refreshBtn;
    
    //to make connection 
    Connection con = DatabaseConnection.connect();
    Statement stmt = null;
    ResultSet rs = null;
    public AdminChangePasswordPnl(){ 
        createGui();
    }
    void createGui(){
        changePassPnl = new JPanel();
        changePassPnl.setLayout(null);
        
        //changePassword
        mainLbl = new JLabel("Forget Password");
        userIdLbl = new JLabel("User Id");
        userIdField = new JTextField("");
        currentPassLbl = new JLabel("Password");
        currentPassField = new JTextField("");
        capInfoLbl = new JLabel("Enter Below Code");
        captchaField = new JTextField("");
        newPassLbl = new JLabel("New Password");
        newPassField = new JTextField("");
        confirmPassLbl = new JLabel("Confirm Password");
        confirmPassField = new JTextField("");
        captchaLbl = new JLabel(PasswordGenerator.generatePass(4));
        captchaLbl.setForeground(Color.blue);
        refreshBtn = new JButton("Refresh");
        submitBtn = new JButton("submit");
        wrongLbl = new JLabel("Wrong info Provided");
        
        //bounds
        mainLbl.setBounds(170,20,150,25);
        userIdLbl.setBounds(70, 130, 100, 25);
        userIdField.setBounds(200, 130, 180, 25);
        currentPassLbl.setBounds(70,160,100,25);
        currentPassField.setBounds(200,160,180,25);
        newPassLbl.setBounds(70,190,100,25);
        newPassField.setBounds(200, 190, 180, 25);
        confirmPassLbl.setBounds(70,220,120,25);
        confirmPassField.setBounds(200,220,180,25);
        capInfoLbl.setBounds(70,250,120,25);
        captchaField.setBounds(200,250,180,25);
        captchaLbl.setBounds(200, 280, 80, 25);
        refreshBtn.setBounds(300, 280, 80, 25);
        submitBtn.setBounds(150,340, 100, 25);
        wrongLbl.setBounds(140,370,200,25);
        wrongLbl.setForeground(Color.red);
        wrongLbl.setVisible(false);
        
        //other change password add
        changePassPnl.add(mainLbl);
        changePassPnl.add(userIdLbl);
        changePassPnl.add(userIdField);
        changePassPnl.add(currentPassLbl);
        changePassPnl.add(currentPassField);
        changePassPnl.add(capInfoLbl);
        changePassPnl.add(captchaField);
        changePassPnl.add(newPassLbl);
        changePassPnl.add(newPassField);
        changePassPnl.add(confirmPassLbl);
        changePassPnl.add(confirmPassField);
        changePassPnl.add(submitBtn);
        changePassPnl.add(wrongLbl);
        changePassPnl.add(captchaLbl);
        changePassPnl.add(refreshBtn);
        
        
        submitBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
                if (userIdField.getText().equals("") || currentPassField.getText().equals("") || captchaField.getText().equals("") || newPassField.getText().equals("") || confirmPassField.getText().equals("")) {
                    if (userIdField.getText().equals("")) {
                        wrongLbl.setText("User Id can't be empty");
                        wrongLbl.setVisible(true);
                        
                    }
                    else if(currentPassField.getText().equals("")){
                        wrongLbl.setText("Current Password can't be empty");
                        wrongLbl.setVisible(true);
                    }
                    else if(newPassField.getText().equals("")){
                        wrongLbl.setText("New Password can not be empty");
                        wrongLbl.setVisible(true);
                    }
                    else if(confirmPassField.getText().equals("")){
                        wrongLbl.setText("Pleae confirm the password ");
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
                        System.out.println("database communication");
                        wrongLbl.setVisible(false);
                    }
                }
            }
        });
        
        refreshBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                captchaLbl.setText(PasswordGenerator.generatePass(4));
            }
        });
    }
    
    
}
