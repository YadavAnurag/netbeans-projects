package schoolmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminRegFormPnl {
    
    static JPanel regFormPnl;
    private JLabel yourPassLbl,regPassLbl, wrongLbl, mainLbl, userIdLbl,semLbl, areaLbl, yearLbl, branchLbl, firstNameLbl, middleNameLbl, lastNameLbl, dobLbl, birthPlaceLbl, ageLbl, genderLbl, statusLbl, guardianLbl, relationLbl, addressLbl, contactLbl, emailLbl;
    private JTextField userIdField, intrestField, firstNameField, middleNameField, lastNameField, dobField,birthPlaceField, ageField, guardianField, relationField, contactField,emailField ;
    private String semStr[] = {"Select", "First Semester", "Second Semester", "Third Semester", "Fourth Semester" ,"Fifth  Semester","Sixth Semester","Seventh Semester","Eighth Semester"};
    
    private String yearStr[] = {"Select", "First Year", "Second Year", "Third Year", "Final Year"};
    private String branchStr[] = {"Select", "Chemical Engineering", "Civil Engineering", "Computer Science and Engineering", "Electronics Engineering", "Electrical Engineering", "Mechanical Engineering"};
    
    private String statusStr[] = {"Select", "Single", "Married"};
    private String typeStr[] = {"Select", "Student", "Staff"};
    private JTextArea addressArea;
    private JRadioButton mrb,frb;
    private JComboBox semCb, yearCb, branchCb,statusCb, typeCb;
    private JLabel enterUserIdLbl;
    private JTextField enterUserIdField;
    private JButton newBtn, insertBtn, showRegFormBtn;
    
    Connection con = DatabaseConnection.connect();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    public AdminRegFormPnl(){ 
        createGui();
    }
    void createGui(){
        regFormPnl = new JPanel();
        regFormPnl.setLayout(null);
        regFormPnl.setBackground(Color.white);
        
        //academic reginstration form
        yourPassLbl = new JLabel("Generated Password");
        yourPassLbl.setVisible(false);
        regPassLbl = new JLabel(PasswordGenerator.generatePass(6));
        regPassLbl.setVisible(false);
        regPassLbl.setForeground(Color.red);
        wrongLbl = new JLabel("Any wrong info goes here");
        wrongLbl.setBackground(Color.red);
        mainLbl = new JLabel("Rgistration Form");
        userIdLbl = new JLabel("User Id");
        userIdField = new JTextField("");
        semLbl = new JLabel("Semester");
        semCb  = new JComboBox(semStr);
        areaLbl = new JLabel("Area of Intrest");
        areaLbl.setVisible(false);
        intrestField = new JTextField("");
        yearLbl = new JLabel("Year");
        yearCb = new JComboBox(yearStr);
        branchLbl = new JLabel("Branch");
        branchCb = new JComboBox(branchStr);
        firstNameLbl = new JLabel("First Name");
        firstNameField = new JTextField("");
        middleNameLbl = new JLabel("Middle Name");
        middleNameField = new JTextField("");
        lastNameLbl = new JLabel("Last Name");
        lastNameField = new JTextField("");
        dobLbl = new JLabel("Date of Birth");
        dobField = new JTextField("YYYY-MM-DD");
        birthPlaceLbl = new JLabel("Place of Birth");
        birthPlaceField = new JTextField("");
        ageLbl = new JLabel("Age");
        ageField = new JTextField("");
        genderLbl  = new JLabel("Gender");
        mrb = new JRadioButton("Male");
        frb = new JRadioButton("Female");
        statusLbl  = new JLabel("Status");
        statusCb = new JComboBox(statusStr);
        guardianLbl = new JLabel("Guardian");
        guardianField = new JTextField("");
        relationLbl = new JLabel("Relation");
        relationField  = new JTextField("");
        addressLbl  = new JLabel("Address");
        addressArea = new JTextArea("");
        contactLbl = new JLabel("Mobile No.");
        contactField = new JTextField("");
        emailLbl = new JLabel("Email");
        emailField = new JTextField("");
        newBtn = new JButton("New");
        typeCb = new JComboBox(typeStr);
        insertBtn = new JButton("Insert");
        enterUserIdLbl = new JLabel("Enter User Id");
        enterUserIdField = new JTextField("");
        showRegFormBtn = new JButton("Show Registration Form");
        
        
        
       //academic reg form bounds
        yourPassLbl.setBounds(30, 30, 120, 30);
        regPassLbl.setBounds(200, 30, 60, 30);
        mainLbl.setBounds(400, 30, 200, 30);
        userIdLbl.setBounds(30,100,100,30);
        userIdField.setBounds(120,100,150,25);
        semLbl.setBounds(300,100,80,30);
        semCb.setBounds(380,100,120,30);
        areaLbl.setBounds(300,100,150,30);        
        intrestField.setBounds(390,100,150,30);  
        yearLbl.setBounds(520,100,60,30);
        yearCb.setBounds(580,100,120,30);
        branchLbl.setBounds(720,100,70,30);
        branchCb.setBounds(790,100,220,30);
        firstNameLbl.setBounds(30,140,100,30);
        firstNameField.setBounds(120,140,150,25);
        middleNameLbl.setBounds(300,140,80,30);
        middleNameField.setBounds(390,140,150,25);
        lastNameLbl.setBounds(550,140,80,30);
        lastNameField.setBounds(630,140,150,25);
        dobLbl.setBounds(30,180,100,30);
        dobField.setBounds(120,180,150,25);
        birthPlaceLbl.setBounds(300,180,80,30);
        birthPlaceField.setBounds(390,180,150,25);
        ageLbl.setBounds(30,220,60,30);
        ageField.setBounds(120,220,150,25);
        genderLbl.setBounds(30,260,80,30);
        mrb.setBounds(120,260,80,30);
        frb.setBounds(200,260,80,30);
        statusLbl.setBounds(300,260,80,30);
        statusCb.setBounds(390,260,150,30);
        guardianLbl.setBounds(30,300,80,30);
        guardianField.setBounds(120,300,150,25);
        relationLbl.setBounds(300,300,80,30);
        relationField.setBounds(390,300,150,25);
        addressLbl.setBounds(30,340,80,30);
        addressArea.setBounds(120,340,300,80);
        contactLbl.setBounds(30,440, 100, 30);
        contactField.setBounds(120,440,150,25);
        emailLbl.setBounds(30,485,100,30);
        emailField.setBounds(120,485,150,25);
        newBtn.setBounds(30, 550, 80, 25);
        typeCb.setBounds(140, 550, 100, 25 );
        insertBtn.setBounds(250, 550, 120, 25);
        enterUserIdLbl.setBounds(800+115, 200, 120, 25);
        enterUserIdField.setBounds(800+85, 240, 150, 25);
        showRegFormBtn.setBounds(800+70, 275, 180, 25);
        wrongLbl.setBounds(500, 550, 200, 25);
        
        //academic reg form add
        regFormPnl.add(yourPassLbl);
        regFormPnl.add(regPassLbl);
        regFormPnl.add(mainLbl);
        regFormPnl.add(userIdLbl);
        regFormPnl.add(userIdField);
        regFormPnl.add(semLbl);
        regFormPnl.add(areaLbl);
        regFormPnl.add(semCb);
        regFormPnl.add(yearLbl);
        regFormPnl.add(yearCb);
        regFormPnl.add(branchLbl);
        regFormPnl.add(branchCb);
        regFormPnl.add(firstNameLbl);
        regFormPnl.add(firstNameField);
        regFormPnl.add(middleNameLbl);
        regFormPnl.add(middleNameField);
        regFormPnl.add(lastNameLbl);
        regFormPnl.add(lastNameField);
        regFormPnl.add(dobLbl);
        regFormPnl.add(dobField);
        regFormPnl.add(birthPlaceLbl);
        regFormPnl.add(birthPlaceField);
        regFormPnl.add(ageLbl);
        regFormPnl.add(ageField);
        regFormPnl.add(genderLbl);
        regFormPnl.add(mrb);
        regFormPnl.add(frb);
        regFormPnl.add(statusLbl);
        regFormPnl.add(statusCb);
        regFormPnl.add(guardianLbl);
        regFormPnl.add(guardianField);
        regFormPnl.add(relationLbl);
        regFormPnl.add(relationField);
        regFormPnl.add(addressLbl);
        regFormPnl.add(addressArea);
        regFormPnl.add(contactLbl);
        regFormPnl.add(contactField);
        regFormPnl.add(emailLbl);
        regFormPnl.add(emailField);
        regFormPnl.add(newBtn);
        regFormPnl.add(typeCb);
        regFormPnl.add(insertBtn);
        regFormPnl.add(enterUserIdLbl);
        regFormPnl.add(enterUserIdField);
        regFormPnl.add(showRegFormBtn);
        regFormPnl.add(wrongLbl);
        //academic reg form add close
        
        AdminHome.atp.addTab("Registration Form", null, regFormPnl, "Your Registration Form");
        
        typeCb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object selected = typeCb.getSelectedItem();
                if (selected.toString().equals("Staff")) {
                    yearLbl.setVisible(false);
                    yearCb.setVisible(false);
                    semLbl.setVisible(false);
                    areaLbl.setVisible(true);
                    semCb.setVisible(false);
                    regFormPnl.add(intrestField);
                } else if(selected.toString().equals("Student")){
                    yearLbl.setVisible(true);
                    yearCb.setVisible(true);
                    semLbl.setVisible(true);
                    areaLbl.setVisible(false);
                    semCb.setVisible(true);
                    regFormPnl.remove(intrestField);
                }
            }
        });
        showRegFormBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
            }
        });
        newBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                yourPassLbl.setVisible(true);
                regPassLbl.setText(PasswordGenerator.generatePass(6));
                regPassLbl.setVisible(true);
                
                try {
                    String sql = "select user_id from users order by user_id desc limit 1 ";
                    stmt =con.prepareStatement(sql);
                    rs = stmt.executeQuery(sql);
                    while(rs.next()){
                        userIdField.setText(rs.getInt(1)+"");
                        //System.out.println(rs.getInt(1)+"");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    e.printStackTrace();
                }
            }
        });
        dobField.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent fe){
                dobField.setText("");
            }
            public void focusLost(FocusEvent fe){
                
            }
        });
        insertBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    System.out.println(typeCb.getSelectedItem());
                    String sql = "";
                    switch (typeCb.getSelectedItem()+"") {
                        case "Student":
                            sql = "INSERT INTO users(pass, date_entered, first_name,\n" +
                                    "	middle_name, last_name, email,\n" +
                                    "	branch_id, semester_id, year_id,\n" +
                                    "	dob, marital_id, gender_id,\n" +
                                    "	age, mobile, gaurdian,\n" +
                                    "	gaurdian_relation, address, interest)\n" +
                                    "	values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                            stmt.setString(1, "mypass");
                            stmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
                            stmt.setString(3, firstNameField.getText());
                            stmt.setString(4, middleNameField.getText());
                            stmt.setString(5, lastNameField.getText());
                            stmt.setString(6, emailField.getText());
                            stmt.setInt(7, branchCb.getSelectedIndex());
                            stmt.setInt(8, semCb.getSelectedIndex());
                            stmt.setInt(9, yearCb.getSelectedIndex());
                            stmt.setString(10, dobField.getText());
                            stmt.setInt(11, statusCb.getSelectedIndex());
                            stmt.setInt(12, frb.isSelected()?2:1);
                            stmt.setInt(13, Integer.parseInt(ageField.getText()));
                            stmt.setString(14, contactField.getText());
                            stmt.setString(15, guardianField.getText());
                            stmt.setString(16, relationField.getText());
                            stmt.setString(17, addressArea.getText());
                            stmt.setString(18, "");
                            stmt = con.prepareStatement(sql);
                            int i = stmt.executeUpdate(sql);
                            System.out.println(".actionPerformed()");
                            System.out.println(i);
                            break;
                        case "Staff":
                            break;
                        case "Administrator":
                            break;
                        default:
                            break;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    e.printStackTrace();
                } 
            }
        });
        
    }
    
}
