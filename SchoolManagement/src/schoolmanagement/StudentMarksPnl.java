package schoolmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
public class StudentMarksPnl {
    
    static JPanel marksPnl;
    private JLabel mainLbl, wrongLbl;
    private JTable table;
    private JScrollPane sp;
    DefaultTableModel model = new DefaultTableModel();
    
    Connection con = DatabaseConnection.connect();
    Statement stmt = null;
    ResultSet rs = null;
    
    public StudentMarksPnl(){ 
        createGui();
    }
    void createGui(){
        marksPnl = new JPanel();
        marksPnl.setLayout(null);
        
        mainLbl = new JLabel("Your Marks Details");
        wrongLbl = new JLabel("Any wrong information goes here");
        wrongLbl.setForeground(Color.green);
        wrongLbl.setVisible(false);
        table = new JTable(model);
        model.addColumn("Date");
        model.addColumn("User Id");
        model.addColumn("Java");
        model.addColumn("Database");
        model.addColumn("Networking");
        model.addColumn("PHP");
        model.addColumn("Java Lab");
        sp = new JScrollPane(table);
        showMarks();
        //acedemic attendance setBounds
        mainLbl.setBounds(200,5,300,25);
        wrongLbl.setBounds(130, 70, 200, 25);
        sp.setBounds(0,100,800, 790);
        //academic attendance add
        marksPnl.add(mainLbl);
        marksPnl.add(wrongLbl);
        marksPnl.add(sp);
        

    }
    void showMarks(){
        
    }
    
}
