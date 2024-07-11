
package bank.management.system;

/**
 *
 * @author RETAM
 * here we will create the mini statement frame which gives user the details of his recent transactions containing the time and the  details of his transactions 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    String pinnumber;
    JButton exit;
     MiniStatement(String pinnumber){
         this.pinnumber=pinnumber;
         JLabel bank=new JLabel("Indian Bank");
         bank.setBounds(140,25,150,20);
         bank.setFont(new Font("Raleway",Font.BOLD,18));
         add(bank);
          String fcardnumber=null;
         //now adding the card number label
         Conn c=new Conn();
         try{
             
           String query = "SELECT * FROM login WHERE pin = ? ";
                PreparedStatement stmt = c.prepareStatement(query);
//                stmt.setString(1, cardnumber);
                 stmt.setString(1, pinnumber);
                 ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                String cardnumber=rs.getString("cardnumber");
                fcardnumber=cardnumber.substring(0,4)+"XXXXXXXX"+cardnumber.substring(cardnumber.length()-4);
                } 
         }
         catch(Exception ex){
             System.out.println(ex);
         }
         JLabel card =new JLabel("Card Number :");
         card.setBounds(20,100,150,20);
         card.setFont(new Font("Raleway",Font.BOLD,16));
         add(card);
         JLabel cardn=new JLabel(fcardnumber);
         cardn.setBounds(180,100,200,20);
         cardn.setFont(new Font("Raleway",Font.BOLD,18));
         add(cardn);
         //adding the JLabel mini which will display the transaction details.
         //first we will add border to check our position of the label then we will delete to set our mini JLabel
         JLabel mini=new JLabel();
//         mini.setBorder(BorderFactory.createLineBorder(Color.black));
         mini.setVerticalAlignment(SwingConstants.TOP);
         add(mini);
         try{
             String query="SELECT * FROM bank  WHERE pin = ? ";
             PreparedStatement stm=c.prepareStatement(query);
             stm.setString(1,pinnumber);
             ResultSet rs=stm.executeQuery();
            StringBuilder transactions = new StringBuilder("<html>");
             while(rs.next()){
//                 mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type_transaction")+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"</html>");
                    transactions.append(rs.getString("date")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                            .append(rs.getString("type_transaction")).append("&nbsp;&nbsp;&nbsp;&nbsp;")
                            .append(rs.getString("amount")).append("<br><br><br>");
             }
             transactions.append("</html>");
             mini.setText(transactions.toString());
         }
         catch(Exception ex){
             System.out.println(ex);
         }
         mini.setBounds(18,200,350,400);
         exit=new JButton("Exit");
         exit.setBounds(20,620,100,30);
         exit.setFont(new Font("Raleway",Font.BOLD,16));
         exit.addActionListener(this);
         add(exit);
         
         setLayout(null);
         setLocation(50,50);
         setSize(400,700);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
     }
    
    public void actionPerformed(ActionEvent ae){
          setVisible(false);
        
         
    }
    public static void main(String[] args) {
        try{
        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
               
            new MiniStatement("");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
    }
    }
}
