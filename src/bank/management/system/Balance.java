
package bank.management.system;

/**
 *
 * @author RETAM
 * here we create the balance class which will calculate the balance for  a particular pinnumber account
 * 
 */
import java.sql.*;
public class Balance {
    String pinnumber;
    int balance;
     Balance(String pinnumber)
     { 
         this.pinnumber=pinnumber;
        balance=0; 
     }
     public int getBalance(){
        Conn c=new Conn();
try{
//        String query="select * from bank where pin= ' "+pinnumber+" ' ";
        String query = "select * from bank where pin = ? ";
                PreparedStatement stmt = c.prepareStatement(query);
//                stmt.setString(1, cardnumber);

                stmt.setString(1, pinnumber);

                ResultSet rs = stmt.executeQuery();
      
  
//            ResultSet rs=c.s.executeQuery(query);
           
            while(rs.next()){
//                System.out.println(rs);
                        
                if(rs.getString("type_transaction").equals("Withdrawal"))
                    balance-=Integer.parseInt(rs.getString("amount"));
            
                else if(rs.getString("type_transaction").equals("Deposit"))
                    balance+=Integer.parseInt(rs.getString("amount"));
        }
            return balance;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return 0;
     }
     public static void main(String args[]){
         String pinnumber="4580";
         Balance balance=new Balance(pinnumber);
         System.out.println(balance.getBalance());
     }
     
    
}
