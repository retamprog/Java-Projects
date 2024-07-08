package bank.management.system;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/*
 now we will also impplement the ActionListener interface to add some action to our JFrame
*/
public class Login extends JFrame implements ActionListener {
    JButton signin,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login() {
        // this Jframe has many default layouts.
        //meaning the way the components are going to be arranged in the JFrame.
        //one such is the border layout whose default settings is to arrange elements into the center.
        //thus in order to have our own custom layout we need to deactivate the default layout settings.
        // to use our own custom layout we use the setBounds function. 
        setLayout(null);
        // this function sets the title of the JFrame
        setTitle("AUTOMATED TELLER MACHINE");
        // this function along with length and breadth parameters creates the login frame
        setSize(800, 480);
        // by default the frame visibility is hidden
//        setUndecorated(true); by doing this it doesnt show the header bar of the JFrame
        setVisible(true);
        // by default the JFrame opens at the top left corner (0,0)
        // we can use the setLocation function to change the opening location according to the x, y coordinates given in the function.
        setLocation(350, 200);
        
        // for using images in our program we will use the ImageIcon class to take images from the system and use it in our frame
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        //the image class is present in the awt package of java.
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        //in Jlabel we cannot pass a image object thus we need to convert it back to a image icon object i3
       
        JLabel label=new JLabel(i3);
        add(label);
        label.setBounds(70,10,100,100);
        
        JLabel text=new JLabel("Welcome to ATM machine");
        text.setFont(new Font("Baskerville Old Face",Font.BOLD,38));
        text.setBounds(200,40,500,40);
        add(text);
        
        JLabel cardno=new JLabel("Card No");
        cardno.setFont(new Font("Raleway",Font.BOLD,20));
        cardno.setBounds(150,150,150,30);
        add(cardno);
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,20));
        add(cardTextField);
        
        JLabel pin=new JLabel("Pin");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(150,200,150,30);
        add(pin);
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,200,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,20));
        add(pinTextField);
        //now we will create the buttons signIn,clear,signUp
        signin=new JButton("Sign In");
        signin.setBounds(300,300,120,30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);
         clear=new JButton("Clear");
        clear.setBounds(430,300,120,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        signup=new JButton("Sign Up");
        signup.setBounds(300,350,250,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        //to access the content of the JFrame and set its background to white by the Color class
        getContentPane().setBackground(Color.WHITE);
        
        
        
        // Make sure the application exits when the window is closed
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         
//         Validate and repaint to ensure the frame is rendered properly
        revalidate();
        repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        //this declares the function of the clear button in the JFrame
        if(e.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
            
        }
        else if(e.getSource()==signin){
             
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
//            System.out.println(pinnumber);
          try{
              Conn conn=new Conn();
            //now we will write a DDL command where we will extract data from the database
           String query = "SELECT * FROM login WHERE cardnumber = ? AND pin = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, cardnumber);
                stmt.setString(2, pinnumber);
                ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                  //which means the query has returned some data
             setVisible(false);
             UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            new Transactions();
            }else{
                JOptionPane.showMessageDialog(null,"Incorrect Card number or Pin number");    
            }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            
              
        
            
        }
        else if(e.getSource()==signup){
              setVisible(false);
              new SignUpOne();
        }
        
    }
    
    public static void main(String[] args) {
        // Ensuring the creation of GUI happens on the Event Dispatch Thread    
          new Login(); // creating an anonymous Login object to call the constructor which will display the Login frame
        
    }
}