
package bank.management.system;

/**
 *
 * @author RETAM
 * Create the PinChange JFrame which will help the user to change the pin of  the account.
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    String pinnumber;
    PinChange(String pinnumber){
         this.pinnumber=pinnumber;
           
           //using the ImageIcon class to add images from the system to our JFrame
           ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
           //now we will convert the ImageIcon object to a Image object inorder to scale it size and fit it the frame
           Image i2=i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT);
           ImageIcon i3=new ImageIcon(i2);
           JLabel background=new JLabel(i3);
           background.setBounds(0,0,900,850);
           add(background);
           setLayout(null);
           setSize(900,850);
           setUndecorated(true);
           setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setLocation(320,0);
    }
    
   public void actionPerformed(ActionEvent ae){
        
    }
   public static void main(String[] args) {
        new PinChange("");
    }
    
}
