
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
import java.sql.*;
public class PinChange extends JFrame implements ActionListener{
    String pinnumber;
    JPasswordField npin,rnpin;
    JButton change,back;
    
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
           //adding the labels for pin change 
           JLabel newPin=new JLabel("Enter New Pin: ");
           JLabel rnewPin=new JLabel("Re-Enter New PIn:");
           newPin.setBounds(180,280,200,30);
           rnewPin.setBounds(180,320,250,30);
           newPin.setFont(new Font("Raleway",Font.BOLD,16));
           rnewPin.setFont(new Font("Raleway",Font.BOLD,16));
           newPin.setForeground(Color.white);
           rnewPin.setForeground(Color.white);
           background.add(newPin);
           background.add(rnewPin);
           //now we will add the newPin and reNewPin fields 
           npin=new JPasswordField();
           rnpin=new JPasswordField();
           npin.setBounds(360,280,140,30);
           rnpin.setBounds(360,320,140,30);
           npin.setFont(new Font("Raleway",Font.BOLD,16));
           rnpin.setFont(new Font("Raleway",Font.BOLD,16));
           background.add(npin);
           background.add(rnpin);
           // now we will add the JButton for change pin and back
           change=new JButton("Change");
           change.setBounds(350,420,150,30);
           change.setFont(new Font("Raleway",Font.BOLD,18));
           change.addActionListener(this);
           background.add(change);
           back=new JButton("Back");
           back.setBounds(350,470,150,30);
           back.setFont(new Font("Raleway",Font.BOLD,18));
           back.addActionListener(this);
           background.add(back);
           
           setLayout(null);
           setSize(900,850);
//           setUndecorated(true);
           setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setLocation(320,0);
    }
    
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==change){
            String newpin=npin.getText();
            String rnewpin=rnpin.getText();
           //first chek whether the fields are emty are not
           if(newpin.equals(""))
               JOptionPane.showMessageDialog(null,"please enter new pin ");
          else if(rnewpin.equals(""))
               JOptionPane.showMessageDialog(null,"Please re-eneter new pin");
          else if(!newpin.equals(rnewpin)){
              JOptionPane.showMessageDialog(null,"Re-enter your new pin ,not maching");
          }
           else if((newpin.length()!=4)||(!digitChecker(newpin))||(rnewpin.length()!=4)||(!digitChecker(rnewpin)))
               JOptionPane.showMessageDialog(null,"Please enter the correct format of  pin, pin must be of four didgits and should not have any characters");
           else {
                Conn c=new Conn();
//                String query1="update bank set pin = ' "+newpin+" 'where pin =' "+pinnumber+"'";
//                String query2="update signupthree set pin_number ='"+newpin+" ' where pin_number = '"+pinnumber+"'";
//                String query3="update login set pin ='"+newpin+"'where pin ='"+pinnumber+"'";
//                try{
//                    c.s.executeUpdate(query1);
//                    c.s.executeUpdate(query2);
//                    c.s.executeUpdate(query3);
//                    JOptionPane.showMessageDialog(null,"your pin has been changed");
//                    setVisible(false);
//                    UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
//                    new Transactions(newpin);
//                }
              String query1 = "UPDATE bank SET pin = ? WHERE pin = ?";
                String query2 = "UPDATE signupthree SET pin_number = ? WHERE pin_number = ?";
                String query3 = "UPDATE login SET pin = ? WHERE pin = ?";
                try {
                    PreparedStatement ps = c.prepareStatement(query1);
                    ps.setString(1, newpin);
                    ps.setString(2, pinnumber);
                    System.out.println("execute");
                    ps.executeUpdate();

                    PreparedStatement ps2 = c.prepareStatement(query2);
                    ps2.setString(1, newpin);
                    ps2.setString(2, pinnumber);
                    ps2.executeUpdate();

                    PreparedStatement ps3 = c.prepareStatement(query3);
                    ps3.setString(1, newpin);
                    ps3.setString(2, pinnumber);
                    ps3.executeUpdate();
                    JOptionPane.showMessageDialog(null,"your pin has been changed");
                    setVisible(false);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                    new Transactions(newpin);
                    
                }   
                catch(Exception ex){
                    System.out.println(ex);
                }
           }
       
       }
       else if(ae.getSource()==back){
           setVisible(false);
           try{
                    UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                    new Transactions(pinnumber);
           }
           catch(Exception ex){
               System.out.println(ex);
           }
       }
        
    }
   public static boolean digitChecker(String s){
       for(int i=0;i<s.length();i++){
           char c=s.charAt(i);
           if(!Character.isDigit(c))
             return false;
               }
       return true;
   }
   public static void main(String[] args) {
       
        try{
                    UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                    new PinChange("");
           }
           catch(Exception ex){
               System.out.println(ex);
           }
    }
    
}
