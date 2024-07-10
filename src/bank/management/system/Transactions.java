
package bank.management.system;

/**
 *
 * @author RETAM
 * here we will build the Transactions page which will give the users options like given in real life ATM system
 * options)-> Deposit, Cash Withdrawal,Fast Cash,Mini Statement,Pin Change,Balance Enquiry,
 * Exit
 */
//import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import com.jtattoo.plaf.aluminium.AluminiumButtonUI;

public class Transactions extends JFrame implements ActionListener  {
        String pinnumber;
        JButton deposit,fastcash,pinchange,cashwithdraw,ministat,balance,exit;
    
       Transactions(String pinnumber){
           this.pinnumber=pinnumber;
           
           //using the ImageIcon class to add images from the system to our JFrame
           ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
           //now we will convert the ImageIcon object to a Image object inorder to scale it size and fit it the frame
           Image i2=i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT);
           ImageIcon i3=new ImageIcon(i2);
           JLabel background=new JLabel(i3);
           background.setBounds(0,0,900,850);
           add(background);
           //JLabel please select your transaction 
           JLabel label=new JLabel("Please  Select  Your  Transaction ");
           label.setFont(new Font("Raleway",Font.BOLD,14));
           label.setForeground(Color.white);
           label.setBounds(220,300,300,20);
           add(label);
           deposit=new JButton("Deposit");
           deposit.setFont(new Font("Raleway",Font.BOLD,15));
           deposit.setForeground(Color.black);
           deposit.setBounds(180,370,150,30);
           deposit.addActionListener(this);
           add(deposit);
           cashwithdraw=new JButton("Cash Withdrawal");
           cashwithdraw.setFont(new Font("Raleway",Font.BOLD,15));
           cashwithdraw.setForeground(Color.black);
           cashwithdraw.setBounds(350,370,150,30);
           add(cashwithdraw);
           cashwithdraw.addActionListener(this);
           fastcash=new JButton("Fast Cash");
           fastcash.setFont(new Font("Raleway",Font.BOLD,15));
           fastcash.setForeground(Color.black);
           fastcash.setBounds(180,410,150,30);
           fastcash.addActionListener(this);
           add(fastcash);
           pinchange=new JButton("Pin Change");
           pinchange.setFont(new Font("Raleway",Font.BOLD,15));
           pinchange.setBounds(180,450,150,30);
           pinchange.setForeground(Color.black);
           pinchange.addActionListener(this);
           add(pinchange);
           ministat=new JButton("Mini Statement");
           ministat.setFont(new Font("Raleway",Font.BOLD,15));
           ministat.setForeground(Color.black);
           ministat.setBounds(350,410,150,30);
           ministat.addActionListener(this);
           add(ministat);
           balance=new JButton("Balance Enquiry");
           balance.setFont(new Font("Raleway",Font.BOLD,15));
           balance.setForeground(Color.black);
           balance.setBounds(350,450,150,30);
           balance.addActionListener(this);
           add(balance);
           exit=new JButton("Exit");
           exit.setForeground(Color.black);
           exit.setFont(new Font("Raleway",Font.BOLD,15));
           exit.setBounds(350,490,150,30);
           exit.addActionListener(this);
           add(exit);
           
           add(background);
           setLayout(null);
           setSize(900,850);
           setUndecorated(true);
           setVisible(true);
   
           setLocation(320,0);
           repaint();
           revalidate();
           
           
         
           
           
       }
       @Override
       public void actionPerformed(ActionEvent ae){
           // now here will add the java buttons functionalities
           if(ae.getSource()==deposit)
           {
             
          try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            new Deposit(pinnumber);
 
        } catch (Exception ex) {
            System.out.println(ex);
            
        }   
           }
           else if(ae.getSource()==cashwithdraw){
               try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            new Withdrawal(pinnumber);
 
        } catch (Exception ex) {
            System.out.println(ex);
            
        } 
               
           }
            else if(ae.getSource()==balance){
               
           }
            else if(ae.getSource()==fastcash){
               
           }
            else if(ae.getSource()==ministat){
               
           }
            else if(ae.getSource()==pinchange){
               
           }
            else if(ae.getSource()==exit){
             System.exit(0);  
           }
           
           
           
       }
    public static void main(String[] args)throws ClassNotFoundException,
               InstantiationException,
               IllegalAccessException,
               UnsupportedLookAndFeelException {
        try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            new Transactions("");
 
        } catch (Exception ex) {
            System.out.println(ex);
            
        } 
//new Transactions();
        
          
    }
    
}
