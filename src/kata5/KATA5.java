package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KATA5 {

    //@SuppressWarnings("empty-statement")
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
       //Class.forName("org.sqlite.JDBC");
       Class.forName("oracle.jdbc.driver.OracleDriver");
       Connection conec = DriverManager.getConnection("jdbc:oracle:thin:@10.22.143.90:1521:orcl","system","orcl"); 
       Statement state = conec.createStatement();
       ResultSet rs = state.executeQuery("SELECT * FROM EMAILS");
       
       while (rs.next()){
       System.out.println("ID = "+ rs.getInt("ID"));
       System.out.println("NAME = "+ rs.getString("NAME"));
       
       }
       
       String nameFile ="C:\\Users\\usuario\\Documents\\NetBeansProjects\\KATA5\\data\\emails.txt";
       BufferedReader reader;
       reader = new BufferedReader (new FileReader(new File (nameFile)));
       
       String mail;
       
       /*
       while((mail = reader.readLine())!=null ){
           String query = " INSERT INTO EMAILS (NAME) VALUES('"+mail+"')";
           state.executeUpdate(query);
                      
        }
       */
       rs.close();
       state.close();
       conec.close();
       
    }
}
