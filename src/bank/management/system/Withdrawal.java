
package bank.management.system;

/**
 *
 * @author RETAM
 * here we will create the 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener{
    JButton withdraw,back;
    JTextField amount;
    String pinnumber;
    Withdrawal(String pinnumber){
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
           //withdrawal amt label
           JLabel withdrawalL=new JLabel("Maximum Withdrawal  is Rs 20,000");
           withdrawalL.setBounds(170,260,450,30);
           withdrawalL.setFont(new Font("Raleway",Font.BOLD,20));
           withdrawalL.setForeground(Color.white);
           background.add(withdrawalL);
           JLabel label=new JLabel("Please Enter The Amount ");
           label.setFont(new Font("Raleway",Font.BOLD,18));
           label.setForeground(Color.white);
           label.setBounds(215,300,320,20);
           background.add(label);
           //the amount text field
           amount=new JTextField();
           amount.setBounds(170,340,340,25);
           amount.setFont(new Font("Raleway",Font.BOLD,18));
           background.add(amount);
           //now setting the buttons withdrawal and back
           withdraw=new JButton("Withdrawal");
           withdraw.setBounds(350,420,150,30);
           withdraw.setFont(new Font("Raleway",Font.BOLD,18));
           withdraw.addActionListener(this);
           background.add(withdraw);
           back=new JButton("back");
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
   
    public static void main(String[] args) {
        
          try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            new Withdrawal("");
 
        } catch (Exception ex) {
            System.out.println(ex);
            
        } 
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdraw){
         String withdrawn=amount.getText();
            Date date =new Date();
            String Sdate=date.toString();
//            int amount=0;
//            amount=amount-(Integer.parseInt(deposit));
//            String samount=amount+"";
           if(withdrawn==""){
                 JOptionPane.showMessageDialog(null,"Please enter the amount you want withdraw");
           }
           else{
            Conn c=new Conn();
            String query="insert into bank values('"+ pinnumber+ "' ,'"+ Sdate+ "','Withdrawal','"+ withdrawn+ "')";
            try{
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"Your  account was debited by Rs"+withdrawn);
                 setVisible(false);
                 new Transactions(pinnumber);
            }
            catch(Exception ex){
                System.out.println(ex);
                
            }
           }
        
    }
        else if(ae.getSource()==back){
               try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            new Transactions(pinnumber);
 
        } catch (Exception ex) {
            System.out.println(ex);
            
        } 
        }
    }
}
