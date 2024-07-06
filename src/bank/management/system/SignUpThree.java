
package bank.management.system;

/**
 *
 * @author RETAM'
 * In here we are going to create the third signup page which is going to ask the user to give services they want from the bank and the type of account it is 
 * going to be.
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SignUpThree extends JFrame implements ActionListener   {
    String formno;
    int fontsize=15;
    JRadioButton savingAcc,FDAcc,currentAcc,RDAcc;
    JCheckBox atmcard,intbank,mobbank,emailsms,chequebook,estat,finalcheck;
    JButton cancel,submit;
      SignUpThree(String formno){
           
          this.formno=formno;
          JLabel title=new JLabel("Page 2: Account Type");
          title.setBounds(220,50,400,30);
          title.setFont(new Font("Raleway",Font.BOLD,25));
          add(title);  
          JLabel accountType=new JLabel("Account Type");
          accountType.setBounds(90,130,200,30);
          accountType.setFont(new Font("Raleway",Font.BOLD,18));
          add(accountType);
          //here we are going to set up the account type radio buttons
          savingAcc=new JRadioButton("Savings Account");
          savingAcc.setBounds(85,170,200,20);
          savingAcc.setFont(new Font("Raleway",Font.BOLD,fontsize));
          savingAcc.setBackground(Color.white);
          add(savingAcc);
          FDAcc=new JRadioButton("Fixed Deposit Account");
          FDAcc.setBounds(320,170,200,20);
          FDAcc.setFont(new Font("Raleway",Font.BOLD,fontsize));
          FDAcc.setBackground(Color.white);
          add(FDAcc);
          currentAcc=new JRadioButton("Current Account");
          currentAcc.setBounds(85,220,200,20);
          currentAcc.setFont(new Font("Raleway",Font.BOLD,fontsize));
          currentAcc.setBackground(Color.white);
          add(currentAcc);
          RDAcc=new JRadioButton("Recurring Deposit Account");
          RDAcc.setBounds(320,220,300,20);
          RDAcc.setFont(new Font("Raleway",Font.BOLD,fontsize));
          RDAcc.setBackground(Color.white);
          add(RDAcc);
          ButtonGroup accType=new ButtonGroup();
          accType.add(savingAcc);
          accType.add(FDAcc);
          accType.add(RDAcc);
          accType.add(currentAcc);
          JLabel cardNumber=new JLabel("Card  Number");
          cardNumber.setFont(new Font("Raleway",Font.BOLD,18));
          cardNumber.setBounds(90,270,200,30);
          add(cardNumber);
          JLabel card=new JLabel("Your 16 Digit Card Number");
          card.setFont(new Font("Raleway",Font.BOLD,10));       
          card.setBounds(85,300,400,20);
          add(card);
          JLabel cardnumber=new JLabel("XXXX-XXXX-XXXX-3364");
          cardnumber.setFont(new Font("Raleway",Font.BOLD,18));
          cardnumber.setBounds(320,270,300,30);
          add(cardnumber);
          JLabel pinNumber=new JLabel("PIN:");
          pinNumber.setBounds(90,350,200,30);
          pinNumber.setFont(new Font("Raleway",Font.BOLD,18));
          add(pinNumber);
          JLabel pin=new JLabel("Your 4 Digit Password");
          pin.setFont(new Font("Raleway",Font.BOLD,10));
          pin.setBounds(85,380,400,30);
          add(pin);
          JLabel pinnumber=new JLabel("XXXX");
          pinnumber.setFont(new Font("Raleway",Font.BOLD,18));
          pinnumber.setBounds(320,350,200,30);
          add(pinnumber);
          JLabel services=new JLabel("Services Required");
          services.setFont(new Font ("Raleway",Font.BOLD,18));
          services.setBounds(90,430,300,30);
          add(services);
          atmcard=new JCheckBox("ATM card");
          atmcard.setBounds(83,470,200,20);
          atmcard.setFont(new Font("Raleway",Font.BOLD,fontsize));
          atmcard.setBackground(Color.white);
          add(atmcard);
          intbank=new JCheckBox("Internet Banking");
          intbank.setBounds(350,470,200,20);
          intbank.setFont(new Font("Raleway",Font.BOLD,fontsize));
          intbank.setBackground(Color.white);
          add(intbank);
          mobbank=new JCheckBox("Mobile Banking");
          mobbank.setBounds(83,510,200,20);
          mobbank.setFont(new Font("Raleway",Font.BOLD,fontsize));
          mobbank.setBackground(Color.white);
          add(mobbank);
          emailsms=new JCheckBox("Email and SMS");
          emailsms.setBounds(350,510,200,20);
          emailsms.setFont(new Font("Raleway",Font.BOLD,fontsize));
          emailsms.setBackground(Color.white);
          add(emailsms);
          estat=new JCheckBox("Internet Banking");
          estat.setBounds(350,550,200,20);
          estat.setFont(new Font("Raleway",Font.BOLD,fontsize));
          estat.setBackground(Color.white);
          add(estat);
          chequebook=new JCheckBox("Cheque Book");
          chequebook.setBounds(83,550,200,20);
          chequebook.setFont(new Font("Raleway",Font.BOLD,fontsize));
          chequebook.setBackground(Color.white);
          add(chequebook);
          //the checked radiobutton
          finalcheck=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
          finalcheck.setFont(new Font("Raleway",Font.BOLD,12));
          finalcheck.setBackground(Color.white);
          finalcheck.setBounds(83,590,650,20);
          add(finalcheck);
          //now we will create the buttons for the last sigup page
          //cancel and submit
          cancel=new JButton("Cancel");
          cancel.setFont(new Font("Raleway",Font.BOLD,18));
          cancel.setBackground(Color.black);
          cancel.setForeground(Color.white);
          cancel.setBounds(170,650,150,30);
          cancel.addActionListener(this);
          add(cancel);
          submit=new JButton("Submit");
          submit.setFont(new Font("Raleway",Font.BOLD,18));
          submit.setBackground(Color.black);
          submit.setForeground(Color.white);
          submit.setBounds(340,650,150,30);
          submit.addActionListener(this);
          add(submit);
          
          setLayout(null);
          setVisible(true);
          setSize(700,750);
         
          setTitle("ACCOUNT SIGNUP DETAILS:PAGE 3");
          setLocation(410,50);
          getContentPane().setBackground(Color.white);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
      }
      @Override
      public void actionPerformed(ActionEvent ae){
          //now we have to pick up the action based on the button clicked.
          if(ae.getSource()==submit){
               String accountype=null;
               if(savingAcc.isSelected())
                    accountype="Savings Account";
               else if(FDAcc.isSelected())
                    accountype="Fixed Deposit Account";
               else if(currentAcc.isSelected())
                    accountype="Current Account";
               else if(RDAcc.isSelected())
                    accountype="Recurring Deposit Account";
               Random random=new Random();
               String cardnumber=(Math.abs(random.nextLong()%900000000000L)+5040000000000000L)+"";
               String pinnumber=""+random.nextInt(1000,9999);
               String services="";
               if(atmcard.isSelected())
                   services=services+" ATM Card";
                if(mobbank.isSelected())
                   services=services+" Mobile Banking";
                if(intbank.isSelected())
                   services=services+" Internet Banking";
                if(emailsms.isSelected())
                   services=services+" Email and SMS";
               if(chequebook.isSelected())
                   services=services+" Cheque Book";
                if(estat.isSelected())
                   services=services+" E-Statement";
               
               if(accountype=="")
                     JOptionPane.showMessageDialog(null,"Account Type info is required");
               else if(services=="")
                   JOptionPane.showMessageDialog(null,"You need to the mention the services you require");
               else if(!finalcheck.isSelected())
                   JOptionPane.showMessageDialog(null,"You need to check and verify your details ");
               else{
                   try{
                    Conn c=new Conn();
                   String query1="insert into signupthree values (' "+formno+"',' "+accountype+" ',' "+cardnumber+" ',' "+pinnumber+"  ',' "+services+" ')";
                   String query2="insert into login values (' "+formno+"',' "+cardnumber+" ',' "+pinnumber+"  ')";
                   c.s.executeUpdate(query1);
                   c.s.executeUpdate(query2);
                   setVisible(false);
                   JOptionPane.showMessageDialog(null, "<html>Card Number: "+cardnumber+"<br>Pin: "+pinnumber+"</html>");
                  
                   
               }
                   catch(Exception e  ){
                       System.out.println(e);
               }
               }            
               
               
          }
          else if(ae.getSource()==cancel){
                         
              
          }
          
          
      }
    public static void main(String[] args) {
        new SignUpThree("");
    }
    
}
;