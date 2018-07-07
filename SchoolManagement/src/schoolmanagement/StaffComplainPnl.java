package schoolmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class StaffComplainPnl {
    
    static JPanel complainPnl;
    JLabel mainLbl, compRelatedLbl, compLbl, wrongLbl;
    private String compStr[] = {"Select","Attandance",  "Exam"};
    private JComboBox cb;
    private JTextArea compArea;
    private JButton saveBtn, newBtn;
    
    //to make connection 
    Connection con = DatabaseConnection.connect();
    Statement stmt = null;
    ResultSet rs = null;
    public StaffComplainPnl(){ 
        createGui();
    }
    void createGui(){
        complainPnl = new JPanel();
        complainPnl.setLayout(null);
        
        //other complain 
        mainLbl = new JLabel("Staff Complain");
        compRelatedLbl = new JLabel("Complain Related");
        cb = new JComboBox(compStr);
        compLbl = new JLabel("Complain");
        compArea = new JTextArea("");
        saveBtn = new JButton("Save");
        newBtn = new JButton("New");
        wrongLbl = new JLabel("Complain successfully sent");
        wrongLbl.setForeground(Color.green);
        wrongLbl.setVisible(false);
        
        //other complain bounds
        mainLbl.setBounds(150, 50, 200, 25);
        compRelatedLbl.setBounds(50,100, 100,25);
        cb.setBounds(170, 100, 150, 25);
        compLbl.setBounds(70, 180, 100, 25);
        compArea.setBounds(170, 140, 450, 120);
        saveBtn.setBounds(230, 270, 100, 25);
        newBtn.setBounds(350, 270, 100, 25);
        wrongLbl.setBounds(300, 320, 200, 25);
                
        //other complain add
        complainPnl.add(mainLbl);
        complainPnl.add(compRelatedLbl);
        complainPnl.add(cb);
        complainPnl.add(compLbl);
        complainPnl.add(compArea);
        complainPnl.add(saveBtn);
        complainPnl.add(newBtn);
        complainPnl.add(wrongLbl);
        
        
        saveBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                wrongLbl.setForeground(Color.green);
                wrongLbl.setText("Complain successfully sent");
                wrongLbl.setVisible(true);
            }     
        });
        newBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
            }     
        });
    }
    
}
