package schoolmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class AdminComplainPnl {
    
    static JPanel complainPnl;
    JLabel compTitleLbl, compRelatedLbl, compLbl, compWrongLbl;
    private String compStr[] = {"Select","Attandance",  "Exam"};
    private JComboBox compCb;
    private JTextArea compArea;
    private JButton compSaveBtn, compNewBtn;
    
    //to make connection 
    Connection con = DatabaseConnection.connect();
    Statement stmt = null;
    ResultSet rs = null;
    public AdminComplainPnl(){ 
        createGui();
    }
    void createGui(){
        complainPnl = new JPanel();
        complainPnl.setLayout(null);
        
        //other complain 
        compTitleLbl = new JLabel("Staff Complain");
        compRelatedLbl = new JLabel("Complain Related");
        compCb = new JComboBox(compStr);
        compLbl = new JLabel("Complain");
        compArea = new JTextArea("");
        compSaveBtn = new JButton("Save");
        compNewBtn = new JButton("New");
        
        //other complain bounds
        compTitleLbl.setBounds(150, 50, 200, 25);
        compRelatedLbl.setBounds(50,100, 100,25);
        compCb.setBounds(170, 100, 150, 25);
        compLbl.setBounds(70, 180, 100, 25);
        compArea.setBounds(170, 140, 450, 120);
        compSaveBtn.setBounds(230, 270, 100, 25);
        compNewBtn.setBounds(350, 270, 100, 25);
        
        //other complain add
        complainPnl.add(compTitleLbl);
        complainPnl.add(compRelatedLbl);
        complainPnl.add(compCb);
        complainPnl.add(compLbl);
        complainPnl.add(compArea);
        complainPnl.add(compSaveBtn);
        complainPnl.add(compNewBtn);
        
        
        compSaveBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                System.out.println("sadf");
            }     
        });
    }
    
}
