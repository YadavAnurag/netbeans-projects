package BillingSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javafx.scene.layout.BorderStroke;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
public class AdminHome {
    
    public static JFrame frame;
    JPanel headPnl, midPnl;
    JLabel logoLbl;
    JButton cashierBtn, transactionBtn, stockBtn, salesBtn, logoutBtn;
    
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension d = kit.getScreenSize();
    public AdminHome(){
        createGui();
    }
    void createGui(){
        frame = new JFrame();
        frame.setLayout(null);
        JPanel p = new JPanel(null);
        logoLbl = new JLabel("Quick Bill", new ImageIcon(getClass().getResource("/BillingSystem/images/logo.png")), SwingConstants.CENTER);
        logoLbl.setForeground(Color.white);
        cashierBtn = new JButton("Cashier", new ImageIcon(getClass().getResource("/BillingSystem/images/cashier.png")));
        cashierBtn.setBackground(new Color(0,120,215));
        cashierBtn.setForeground(Color.white);
        cashierBtn.setBorderPainted(false);
        transactionBtn = new JButton("Transaction", new ImageIcon(getClass().getResource("/BillingSystem/images/transaction.png")));
        transactionBtn.setBackground(new Color(0,120,215));
        transactionBtn.setForeground(Color.white);
        transactionBtn.setBorderPainted(false);

        
        
        
        
        logoLbl.setBounds(0,5,150,60);
        cashierBtn.setBounds(160, 0, 140, 65);
        transactionBtn.setBounds(300, 0, 160, 65);
        
        p.add(logoLbl);
        p.add(cashierBtn);
        p.add(transactionBtn);
        p.setBounds(0,0,(int)d.getWidth(),65);
        p.setBackground(new Color(9,42,116));
        frame.getContentPane().add(p);
        
        
        frame.setSize(d);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String []args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                new AdminHome();
            }
        });
    }
}
