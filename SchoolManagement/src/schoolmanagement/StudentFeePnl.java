
package schoolmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class StudentFeePnl {
    
    static JPanel feePnl;
    JLabel  mainLbl, infoLbl, reciptNoLbl, imageLbl;
    JButton showBtn, printBtn;
    JTextField reciptField;
    private JLabel enterUserIdLbl;
    private JTextField enterUserIdField;
    private JButton showFeeDetailsBtn;
    
    
    Connection con = DatabaseConnection.connect();
    Statement stmt = null;
    ResultSet rs = null;
    
    public StudentFeePnl(){ 
        createGui();
    }
    void createGui(){
        //academic fee
        feePnl = new JPanel();
        feePnl.setLayout(null);
        mainLbl = new JLabel("Fee Recipts");
        infoLbl = new JLabel("Your Recipt No. 1.");
        reciptNoLbl = new JLabel("Recipt Number");
        showBtn = new JButton("Show");
        printBtn = new JButton("Print");
        imageLbl = new JLabel();
        reciptField = new JTextField("");
        enterUserIdLbl = new JLabel("Enter User Id");
        enterUserIdField = new JTextField("");
        showFeeDetailsBtn = new JButton("Show Fee Details");
        
        mainLbl.setBounds(5,5,100,25);
        infoLbl.setBounds(5,30, 790, 35);
        reciptNoLbl.setBounds(5, 70, 100, 25);
        reciptField.setBounds(115, 70, 150, 25);
        showBtn.setBounds(280, 70, 100, 25);
        printBtn.setBounds(395, 70, 100, 25);
        imageLbl.setBounds(0, 90, 790,600);
        enterUserIdLbl.setBounds(800+95, 200, 120, 25);
        enterUserIdField.setBounds(800+70, 240, 150, 25);
        showFeeDetailsBtn.setBounds(800+70, 275, 150, 25);
        
        
        //feePnl add
        feePnl.add(mainLbl);
        feePnl.add(infoLbl);
        feePnl.add(reciptNoLbl);
        feePnl.add(reciptField);
        feePnl.add(showBtn);
        feePnl.add(printBtn);
        feePnl.add(imageLbl);
        feePnl.add(enterUserIdLbl);
        feePnl.add(enterUserIdField);
        feePnl.add(showFeeDetailsBtn);
        
        StudentHome.stp.addTab("Fee Details", null, feePnl, "Fee Details");
    }
    
}
