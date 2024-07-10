
package bank.management.system;

/**
 *
 * @author RETAM
 * here we will create the fast cash JFrame which will give the users the real life atm sim type feeling
 * where users can directly withdraw cash in the denominations of 100,500,1000,2000,5000,10000 buttons and back button
 */
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class FastCash extends JFrame implements ActionListener{
     String pinnumber;
     JButton R100,R500,R1000,R2000,R5000,R10000,back;
     FastCash(String pinnumber){
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
           JLabel label=new JLabel("Select Withdrawal Amount ");
           label.setFont(new Font("Raleway",Font.BOLD,18));
           label.setForeground(Color.white);
           label.setBounds(215,290,300,20);
           background.add(label);
//           add(background);
           R100=new JButton("Rs 100");
           R100.setFont(new Font("Raleway",Font.BOLD,15));
           R100.setForeground(Color.black);
           R100.setBounds(180,370,150,30);
           R100.addActionListener(this);
           background.add(R100);
           R500=new JButton("Rs 500");
           R500.setFont(new Font("Raleway",Font.BOLD,15));
           R500.setForeground(Color.black);
           R500.setBounds(350,370,150,30);
           background.add(R500);
           R500.addActionListener(this);
           R1000=new JButton("Rs 1000");
           R1000.setFont(new Font("Raleway",Font.BOLD,15));
           R1000.setForeground(Color.black);
           R1000.setBounds(180,410,150,30);
           R1000.addActionListener(this);
           background.add(R1000);
           R2000=new JButton("Rs 2000");
           R2000.setFont(new Font("Raleway",Font.BOLD,15));
           R2000.setBounds(180,450,150,30);
           R2000.setForeground(Color.black);
           R2000.addActionListener(this);
           background.add(R2000);
           R5000=new JButton("Rs 5000");
           R5000.setFont(new Font("Raleway",Font.BOLD,15));
           R5000.setForeground(Color.black);
           R5000.setBounds(350,410,150,30);
           R5000.addActionListener(this);
           background.add(R5000);
           R10000=new JButton("Rs 10000");
           R10000.setFont(new Font("Raleway",Font.BOLD,15));
           R10000.setForeground(Color.black);
           R10000.setBounds(350,450,150,30);
           R10000.addActionListener(this);
           background.add(R10000);
          back=new JButton("Back");
           back.setForeground(Color.black);
           back.setFont(new Font("Raleway",Font.BOLD,15));
           back.setBounds(350,490,150,30);
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
            Date date =new Date();
            String Sdate=date.toString();
            Conn c=new Conn();
             if(ae.getSource()==R100){
                 Balance amt=new Balance(pinnumber);
                 int balance=amt.getBalance();
                 if(balance<100){
                     JOptionPane.showMessageDialog(null,"Insufficient Balance");
                 }
                 else{
                  String query="insert into bank values('"+ pinnumber+ "' ,'"+ Sdate+ "','Withdrawal','100')";
                  try{
                      c.s.executeUpdate(query);
                      JOptionPane.showMessageDialog(null,"Your Account was debited by Rs 100");
                      setVisible(false);
                      UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                      new Transactions(pinnumber);
                  }
                  catch(Exception e){
                      System.out.println(e);
                  }
                 }
                 
             }
             else if(ae.getSource()==R500){
                 Balance amt=new Balance(pinnumber);
                 int balance=amt.getBalance();
                 if(balance<500){
                     JOptionPane.showMessageDialog(null,"Insufficient Balance");
                 }
                 else{
                  
                  String query="insert into bank values('"+ pinnumber+ "' ,'"+ Sdate+ "','Withdrawal','500')";
                  try{
                      c.s.executeUpdate(query);
                       JOptionPane.showMessageDialog(null,"Your Account was debited by Rs 500");
                      setVisible(false);
                      UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                      new Transactions(pinnumber);
                  }
                  catch(Exception e){
                      System.out.println(e);
                  }
                 }
                 
             }
             else if(ae.getSource()==R1000){
                 Balance amt=new Balance(pinnumber);
                 int balance=amt.getBalance();
                 if(balance<1000){
                     JOptionPane.showMessageDialog(null,"Insufficient Balance");
                 }
                 else{
                   String query="insert into bank values('"+ pinnumber+ "' ,'"+ Sdate+ "','Withdrawal','1000')";
                  try{
                      c.s.executeUpdate(query);
                       JOptionPane.showMessageDialog(null,"Your Account was debited by Rs 1000");
                      setVisible(false);
                      UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                      new Transactions(pinnumber);
                  }
                  catch(Exception e){
                      System.out.println(e);
                  }
                 }
             }
             else if(ae.getSource()==R2000){
                 Balance amt=new Balance(pinnumber);
                 int balance=amt.getBalance();
                 if(balance<2000){
                     JOptionPane.showMessageDialog(null,"Insufficient Balance");
                 }
                 else{
                   String query="insert into bank values('"+ pinnumber+ "' ,'"+ Sdate+ "','Withdrawal','2000')";
                  try{
                      c.s.executeUpdate(query);
                       JOptionPane.showMessageDialog(null,"Your Account was debited by Rs 2000");
                      setVisible(false);
                      UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                      new Transactions(pinnumber);
                  }
                  catch(Exception e){
                      System.out.println(e);
                  }
                 }
             }
             else if(ae.getSource()==R5000){
                 Balance amt=new Balance(pinnumber);
                 int balance=amt.getBalance();
                 if(balance<5000){
                     JOptionPane.showMessageDialog(null,"Insufficient Balance");
                 }
                 else{
                   String query="insert into bank values('"+ pinnumber+ "' ,'"+ Sdate+ "','Withdrawal','5000')";
                  try{
                      c.s.executeUpdate(query);
                       JOptionPane.showMessageDialog(null,"Your Account was debited by Rs 5000");
                      setVisible(false);
                      UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                      new Transactions(pinnumber);
                  }
                  catch(Exception e){
                      System.out.println(e);
                  }
                 }
             }
             else if(ae.getSource()==R10000){
                 Balance amt=new Balance(pinnumber);
                 int balance=amt.getBalance();
                 if(balance<10000){
                     JOptionPane.showMessageDialog(null,"Insufficient Balance");
                 }
                 else{
                   String query="insert into bank values('"+ pinnumber+ "' ,'"+ Sdate+ "','Withdrawal','10000')";
                  try{
                      c.s.executeUpdate(query);
                       JOptionPane.showMessageDialog(null,"Your Account was debited by Rs 10000");
                      setVisible(false);
                      UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                      new Transactions(pinnumber);
                  }
                  catch(Exception e){
                      System.out.println(e);
                  }
                 }
             }
             else if(ae.getSource()==back){
                   try{
                       UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                       new Transactions(pinnumber);
                   }
                   catch(Exception ex){
                       System.out.println(ex);
                   }
             }
    }
    public static void main(String[] args) {
        try{
        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
          new FastCash("");
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
}
