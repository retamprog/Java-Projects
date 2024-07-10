
package bank.management.system;

/**
 *
 * @author RETAM
 *  here we will create the Balance enquiry frame which we will show the balance
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinnumber;
    JButton Back;
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
           ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
           //now we will convert the ImageIcon object to a Image object inorder to scale it size and fit it the frame
           Image i2=i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT);
           ImageIcon i3=new ImageIcon(i2);
           JLabel background=new JLabel(i3);
           background.setBounds(0,0,900,850);
           add(background);
           //JLabel please select your transaction 
           Balance amt=new Balance(pinnumber);
           int balance=amt.getBalance();        
           JLabel label=new JLabel("Your Current Account Balance "+balance);
           label.setFont(new Font("Raleway",Font.BOLD,18));
           label.setForeground(Color.white);
           label.setBounds(170,300,300,20);
           background. add(label);
          //
          Back=new JButton("Back");
          Back.setBounds(350,470,150,30);
          Back.setFont(new Font("Raleway",Font.BOLD,18));
          Back.addActionListener(this);
          background.add(Back);
          setLayout(null);
          setSize(900,850);
          setUndecorated(true);
          setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setLocation(320,0);
          
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        try{
        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        new Transactions(pinnumber);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
    }
    public static void main(String[] args) {
        try{
        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
         new BalanceEnquiry("");
        }
        catch(Exception ex){
            System.out.println(ex);
        }
   
                }
    
}
