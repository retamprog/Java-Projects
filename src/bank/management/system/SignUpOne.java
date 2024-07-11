package bank.management.system;

/**
 *
 * @author RETAM
 * in here we will create the first signUp page JFrame
 */
//now we will connect this JFrame with database so that the data can be stored from JFrame to the database
//we will use jdbc connectivity for connecting the database with JFrame.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener {
    int applNumber;//for the form number.
    JTextField nameField,fnameField,mnameField,emailField,addressField,cityField,pinField,stateField;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser dateChooser;
    JButton next;
    
    SignUpOne(){
        
        int fontsize=15;//text field font size
        Random random=new Random();
        applNumber=random.nextInt(1000,9999);
        JLabel title=new JLabel("Application Form No. "+applNumber);
        title.setBounds(200,30,500,50);
        title.setFont(new Font("Raleway",Font.BOLD,38));
        add(title);
        JLabel personal =new JLabel("Page 1: PERSONAL DETAILS");
        personal.setBounds(250,100,500,50);
        personal.setFont(new Font("Raleway",Font.BOLD,25));
        add(personal);
        //now we will add the form labels
        JLabel name =new JLabel("Name:");
        name.setBounds(120,190,200,20);
        name.setFont(new Font("Raleway",Font.BOLD,18));
        add(name);
        nameField=new JTextField();
        nameField.setBounds(320,190,300,30);
        nameField.setFont(new Font("Arial",Font.BOLD,fontsize));
        add(nameField);
        JLabel fname =new JLabel("Father's Name:");
        fname.setBounds(120,240,200,20);
        fname.setFont(new Font("Raleway",Font.BOLD,18));
        add(fname);
        fnameField=new JTextField();
        fnameField.setBounds(320,240,300,30);
        fnameField.setFont(new Font("Arial",Font.BOLD,fontsize));
        add(fnameField);
        JLabel mname =new JLabel("Mother's Name:");
        mname.setBounds(120,290,200,20);
        mname.setFont(new Font("Raleway",Font.BOLD,18));
        add(mname);
        mnameField=new JTextField();
        mnameField.setBounds(320,290,300,30);
        mnameField.setFont(new Font("Arial",Font.BOLD,fontsize));
        add(mnameField);
        JLabel dob =new JLabel("Date Of Birth:");
        dob.setBounds(120,340,200,20);
        dob.setFont(new Font("Raleway",Font.BOLD,18));
        add(dob);
         dateChooser=new JDateChooser();
        dateChooser.setBounds(320,340,300,30);
        //this dateChooser consists of a date editor(default:JTextFieldDateEditor) and a button to open the JCalendar popup.
        add(dateChooser);
        
        
        JLabel gender =new JLabel("Gender:");
        gender.setBounds(120,390,200,20);
        gender.setFont(new Font("Raleway",Font.BOLD,18));
        add(gender);
        male=new JRadioButton("Male");
        male.setBounds(320,390,60,30);
        male.setBackground(Color.white);
        add(male);
        female=new JRadioButton("Female");
        female.setBounds(450,390,80,30);
        female.setBackground(Color.white);
        add(female);
        ButtonGroup buttongroup =new ButtonGroup();
        buttongroup.add(male);
        buttongroup.add(female);
        JLabel email =new JLabel("Email Address:");
        email.setBounds(120,440,200,20);
        email.setFont(new Font("Raleway",Font.BOLD,18));
        add(email);
        emailField=new JTextField();
        emailField.setBounds(320,440,300,30);
        emailField.setFont(new Font("Arial",Font.BOLD,fontsize));
        add(emailField);
        JLabel marry =new JLabel("Marital Status:");
        marry.setBounds(120,490,200,20);
        marry.setFont(new Font("Raleway",Font.BOLD,18));
        add(marry);
        married=new JRadioButton("Married");
        married.setBounds(320,490,80,30);
        married.setBackground(Color.white);
        add(married);
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(420,490,90,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        other =new JRadioButton("Other");
        other.setBounds(540,490,60,30);
        other.setBackground(Color.white);
        add(other);
        ButtonGroup marrygroup=new ButtonGroup();
        marrygroup.add(married);
        marrygroup.add(unmarried);
        marrygroup.add(other);
        JLabel address =new JLabel("Address:");
        address.setBounds(120,540,200,20);
        address.setFont(new Font("Raleway",Font.BOLD,18));
        add(address);
        addressField=new JTextField();
        addressField.setBounds(320,540,300,30);
        addressField.setFont(new Font("Arial",Font.BOLD,fontsize));
        add(addressField);
        JLabel city =new JLabel("City:");
        city.setBounds(120,590,200,20);
        city.setFont(new Font("Raleway",Font.BOLD,18));
        add(city);
        cityField=new JTextField();
        cityField.setBounds(320,590,300,30);
        cityField.setFont(new Font("Arial",Font.BOLD,fontsize));
        add(cityField);
        JLabel pincode =new JLabel("Pin Code:");
        pincode.setBounds(120,640,200,20);
        pincode.setFont(new Font("Raleway",Font.BOLD,18));
        add(pincode);
        pinField=new JTextField();
        pinField.setBounds(320,640,300,30);
        pinField.setFont(new Font("Arial",Font.BOLD,fontsize));
        add(pinField);
        JLabel state =new JLabel("State:");
        state.setBounds(120,690,200,20);
        state.setFont(new Font("Raleway",Font.BOLD,18));
        add(state);
        stateField=new JTextField();
        stateField.setBounds(320,690,300,30);
        stateField.setFont(new Font("Arial",Font.BOLD,fontsize));
        add(stateField);
        //adding the JButton next
        next=new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,18));
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(700,750,100,30);
        next.addActionListener(this);
        add(next);
        setLayout(null);//deactivates the default layouts
        setSize(850,820);
        setLocation(320,5);
        setTitle("APPLICATION FORM-Page 1");
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);//turns the background of the JFrame white
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        //the image class is present in the awt package of java.
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        //in Jlabel we cannot pass a image object thus we need to convert it back to a image icon object i3
       
        JLabel label=new JLabel(i3);
        add(label);
        label.setBounds(30,10,100,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        revalidate();
        repaint();
    }
    public void actionPerformed(ActionEvent ae){
         String formno=""+applNumber;
         String name=nameField.getText();
         String fname=fnameField.getText();
         String mname=mnameField.getText();
         String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
         String gender=null;
         if(male.isSelected())
              gender="male";
         else if(female.isSelected())
              gender="female";
        
         String email=emailField.getText();
         String marry=null;
         if(married.isSelected())
             marry="married";
         else if(unmarried.isSelected())
             marry="unmarried";
         else
             marry="other";
         String address=addressField.getText();
         String city=cityField.getText();
         String pin=pinField.getText();
         String state=stateField.getText();
try{
         if(name.equals(""))
         JOptionPane.showMessageDialog(null,"Name is required");
         else if(fname.equals(""))
             JOptionPane.showMessageDialog(null,"Father's Name is required");
         else if(dob.equals(""))
             JOptionPane.showMessageDialog(null,"Dob is required");
         else if(gender.equals(""))
             JOptionPane.showMessageDialog(null,"Gender is required");
         else if(email.equals(""))
             JOptionPane.showMessageDialog(null,"Email is required");
         else if(marry.equals(""))
             JOptionPane.showMessageDialog(null,"Marry is required");
         else if(address.equals(""))
             JOptionPane.showMessageDialog(null,"address is required");
         else if(pin.equals(""))
             JOptionPane.showMessageDialog(null,"Pin  is required");
         else if(state.equals(""))
             JOptionPane.showMessageDialog(null,"State  is required");
         else
         {
             Conn c=new Conn();
             //creating the query
             String query="insert into signup values (' "+formno+"',' "+name+" ',' "+fname+" ',' "+mname+" ',' "+dob+" ',' "+gender+" ',' "+email+" ' ,' "+marry+" ' ,' "+address+" ', ' "+city+" ',' "+pin+" ',' "+state+" ')";
             //executing the query
             c.createStatement().executeUpdate(query);
             setVisible(false);
             UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
             new SignUpTwo(formno);
         }
}
         catch(Exception e)
         {
             System.out.println(e);
         }
             
        
    }
    public static void main(String[] args) {
        try{
        new SignUpOne();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
}
