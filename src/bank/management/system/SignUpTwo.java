package bank.management.system;

/**
 *
 * @author RETAM
 * in this class we will create the page two of signUp system
 * it will take extra info from the user like:
 * Religion(DropDown),Category(DropDown),Income(DropDown),Educational Qualification(DropDown),Occupation(DropDown),PAN Number(Text),
 * Aadhar Number(Text),Senior Citizen(radioButton),Existing Account(RadioButton) and a next button.
 */
//import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class SignUpTwo extends JFrame implements ActionListener {
    JTextField panField,aadharField;
    JRadioButton syes ,sno,existyes,existno;
    JComboBox religionOptions,categoryOptions,incomeOptions,eduOptions,occuOptions;
    String formno;
    JButton next;
    SignUpTwo(String formno){
        
        int fontsize=15;//text field font size
        this.formno=formno;
        JLabel additional =new JLabel("Page 2: Additional Details");
        additional.setBounds(270,50,500,50);
        additional.setFont(new Font("Raleway",Font.BOLD,25));
        add(additional);
        //now we will add the form labels
        JLabel religion =new JLabel("Religion:");
        religion.setBounds(120,170,200,30);
        religion.setFont(new Font("Raleway",Font.BOLD,18));
        add(religion);
        String religionopt[]={"Hindu","Muslim","Sikh","Christian","Jain","Others"};
        religionOptions=new JComboBox(religionopt);
        religionOptions.setBounds(340,170,300,30);
        add(religionOptions);
        JLabel category =new JLabel("Category");
        category.setBounds(120,230,200,30);
        category.setFont(new Font("Raleway",Font.BOLD,18));
        add(category);
        String catopt[]={"General","SC/ST","OBC","Others"};
        categoryOptions=new JComboBox(catopt);
        categoryOptions.setBounds(340,230,300,30);
        add(categoryOptions);
        
        JLabel income =new JLabel("Income:");
        income.setBounds(120,290,200,30);
        income.setFont(new Font("Raleway",Font.BOLD,18));
        add(income);
        String incomeopt[]={"Null","< 1,50,000","<2,50,000","<5,00,000","upto 10,00,000","more than 10,00,000"};
        incomeOptions=new JComboBox(incomeopt);
        incomeOptions.setBounds(340,290,300,30);
        add(incomeOptions);
        
        JLabel education =new JLabel("Educational Qualities:");
        education.setBounds(120,350,200,30);
        education.setFont(new Font("Raleway",Font.BOLD,18));
        add(education);
        String eduopt[]={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        eduOptions=new JComboBox(eduopt);
        eduOptions.setBounds(340,350,300,30);
        add(eduOptions);
        
        JLabel occupation =new JLabel("Occupation:");
        occupation.setBounds(120,410,200,30);
        occupation.setFont(new Font("Raleway",Font.BOLD,18));
        add(occupation);
        String occuopt[]={"Salaried","Self-Employed","Buisness","Retired","Student","Other"};
        occuOptions=new JComboBox(occuopt);
        occuOptions.setBounds(340,410,300,30);
        add(occuOptions);
        
        JLabel pan =new JLabel("PAN number:");
        pan.setBounds(120,470,200,30);
        pan.setFont(new Font("Raleway",Font.BOLD,18));
        add(pan);
        panField=new JTextField();
        panField.setBounds(340,470,300,30);
        panField.setFont(new Font("Arial",Font.BOLD,fontsize));
        add(panField);
        JLabel aadhar =new JLabel("Aadhar number:");
        aadhar.setBounds(120,530,200,30);
        aadhar.setFont(new Font("Raleway",Font.BOLD,18));
        add(aadhar);
        aadharField=new JTextField();
        aadharField.setFont(new Font("Arial",Font.BOLD,fontsize));
        aadharField.setBounds(340,530,300,30);
        add(aadharField);
        JLabel scitizen =new JLabel("Senior Citizen:");
        scitizen.setBounds(120,590,200,30);
        scitizen.setFont(new Font("Raleway",Font.BOLD,18));
        add(scitizen);
        syes=new JRadioButton("Yes");
        syes.setBackground(Color.white);
        syes.setBounds(340,590,60,30);
        add(syes);
        sno=new JRadioButton("No");
        sno.setBackground(Color.white);
        sno.setBounds(410,590,60,30);
        add(sno);
        ButtonGroup seniorCitizen=new ButtonGroup();
        seniorCitizen.add(sno);
        seniorCitizen.add(syes);
        
        
        JLabel existingaccount =new JLabel("Existing Account:");
        existingaccount.setBounds(120,650,200,30);
        existingaccount.setFont(new Font("Raleway",Font.BOLD,18));
        add(existingaccount);
         existyes=new JRadioButton("Yes");
        existyes.setBackground(Color.white);
        existyes.setBounds(340,650,60,30);
        add(existyes);
        existno=new JRadioButton("No");
        existno.setBackground(Color.white);
        existno.setBounds(410,650,60,30);
        add(existno);
        ButtonGroup existingAccount=new ButtonGroup();
        existingAccount.add(existno);
        existingAccount.add(existyes);
        
        
        //adding the JButton next
        next=new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,18));
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(650,700,100,30);
        next.addActionListener(this);
        add(next);
        setLayout(null);//deactivates the default layouts
        setSize(850,820);
        setLocation(320,5);
        setTitle("NEW ACCOUNT APPLICATION FORM-Page 2");
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
         String category=(String)categoryOptions.getSelectedItem();
         String religion=(String)religionOptions.getSelectedItem();
         String income=(String)incomeOptions.getSelectedItem();
         String education=(String)eduOptions.getSelectedItem();
         String occupation=(String)occuOptions.getSelectedItem();
         String pan=panField.getText();
         String aadhar=aadharField.getText();
         String senior=null;
         if(syes.isSelected())
              senior="Yes";
         else if(sno.isSelected())
              senior="No";
        
         String existingAcc=null;
        
         if(existyes.isSelected())
             existingAcc="Yes";
         else if(existno.isSelected())
             existingAcc="No";
         
        
try{
         if(religion.equals(""))
         JOptionPane.showMessageDialog(null,"Religion is required");
         else if(category.equals(""))
             JOptionPane.showMessageDialog(null,"Category is required");
         else if(income.equals(""))
             JOptionPane.showMessageDialog(null,"Income is required");
         else if(education.equals(""))
             JOptionPane.showMessageDialog(null,"Education Qualification  is required");
         else if(occupation.equals(""))
             JOptionPane.showMessageDialog(null,"Occupation is required");
         else if(pan.equals(""))
             JOptionPane.showMessageDialog(null,"PAN number is required");
         else if(aadhar.equals(""))
             JOptionPane.showMessageDialog(null,"Aadhar Number  is required");
         else if(existingAcc.equals(""))
             JOptionPane.showMessageDialog(null,"Existing account info  is required");
         else
         {
             Conn c=new Conn();
             //creating the query
             String query="insert into signuptwo values (' "+formno+"',' "+religion+" ',' "+category+" ',' "+income+" ',' "+education+" ',' "+occupation+" ',' "+pan+" ' ,' "+aadhar+" ' ,' "+senior+" ', ' "+existingAcc+" ')";
             //executing the query
             c.s.executeUpdate(query);
             setVisible(false);
             new SignUpThree(formno);
             
         }
}
         catch(Exception e)
         {
             System.out.println(e);
         }
             
        
    }
    public static void main(String[] args) {
         new SignUpTwo("");
    }
    
}
