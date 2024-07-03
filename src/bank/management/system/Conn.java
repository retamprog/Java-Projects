
package bank.management.system;
// we will use this class jdbc connect
//There are Five steps to do so:
//1)Register Driver
//2)Create Connection
//3)Create statement
//4)Execute Query
//5)Close Connection
//importing the java sql library
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
   Conn(){
       try{
//         Class.forName(com.mysql.cj.jdbc.Driver);//registering the driver
         //this step consists of creating the connection
         c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","retam112004");
        //this step creates the statement
         s=c.createStatement();
       }
       catch(Exception e){
       System.out.println(e);
   }
   }
   
}
