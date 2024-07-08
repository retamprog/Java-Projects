
package bank.management.system;

/**
 *
 * @author RETAM
 * here we are going to create the deposit frame which is very similar to the Transactions frame
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Deposit extends JFrame implements ActionListener {
     JTextField depositField;
     JButton deposit,back;
     String pinnumber;
     Deposit(String pinnumber){
         this.pinnumber=pinnumber;
         //using the ImageIcon class to add images from the system to our JFrame
           ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
           //now we will convert the ImageIcon object to a Image object inorder to scale it size and fit it the frame
           Image i2=i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT);
           ImageIcon i3=new ImageIcon(i2);
           JLabel background=new JLabel(i3);
           background.setBounds(0,0,900,850);
//           add(background);
           add(background);
           //adding the deposit label
           JLabel label=new JLabel("Please Enter The Deposit Amount ");
           label.setFont(new Font("Raleway",Font.BOLD,18));
           label.setForeground(Color.white);
           label.setBounds(180,280,320,20);
           background.add(label);
           //now adding the depost amt text field
           depositField=new JTextField();
           depositField.setBounds(170,315,340,30);
           depositField.setFont(new Font("Raleway",Font.BOLD,18));
           background.add(depositField);
           //now adding the deposit button and back button
           deposit=new JButton("Deposit");
           deposit.setBounds(350,420,150,30);
           deposit.setFont(new Font("Raleway",Font.BOLD,18));
           deposit.addActionListener(this);
           background.add(deposit);
           back=new JButton("Back");
           back.setBounds(350,470,150,30);
           back.setFont(new Font("Raleway",Font.BOLD,18));
           back.addActionListener(this);
           background.add(back);
           setLayout(null);
           setSize(900,850);
//           setUndecorated(true);
           setVisible(true);   
           setLocation(320,0);
           
     }
     
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            
        }
        else if(ae.getSource()==back){
              setVisible(false);
              new Transactions(pinnumber);
                      
        }
        
    }
    public static void main(String[] args) {
        
          try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            new Deposit("");
 
        } catch (Exception ex) {
            System.out.println(ex);
            
        } 
    }
    
    
}
