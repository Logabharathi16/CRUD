package DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class connect {

	public void crud_operation() {
	
     String continuedata = "";
     System.out.println("HELLO");
     String continueUrl = "jdbc:sqlserver://localhost:3306;"
     +"database=crud;"
     +"user=root;"
     +"password=Loga@2000;";
     do
     {
    	 System.out.println("Select Your Action");
    	 System.out.println("Press 1 to select data \n Press 2 to Insert data \n Press 3 to delete data");
         Scanner sc = new Scanner(System.in);
         var DataInput = sc.nextLine();
         switch(DataInput)
         {
         case "1":
        	 ResultSet resultset = null;
        	 
        	 try(Connection connection = DriverManager.getConnection(continueUrl);Statement statement = connection.createStatement();)
        	 {
        		 String select = "select * from details";
        		 resultset = statement.executeQuery(select);
        		 
        		 while (resultset.next())
        		 {
        			 var str = String.format("%s %s %s",resultset.getString(1),resultset.getString(2),resultset.getString(3));
        			 System.out.println(str);
        		 }
        	 }
        	 catch (SQLException e) {
        		 e.printStackTrace();
        	 }
        	 break;
         case "2":
        	 try(Connection connection = DriverManager.getConnection(continueUrl)){
        		 System.out.println("Enter the S_No");
        		 var s_no = sc.nextLine();
        		 System.out.println(s_no);
        		 System.out.println("Enter the Name");
        		 var name = sc.nextLine();
        		 System.out.println(name);
        		 System.out.println("Enter the Age");
        		 var age = sc.nextLine();
        		 System.out.println(age);
        		 PreparedStatement stmt = connection.prepareStatement("insert into details values"+"(s_no,name,age)");
        		 stmt.setString(1,s_no);
        		 stmt.setString(2,name);
        		 stmt.setString(3,age);
        		 stmt.executeUpdate();
        		 
        		 System.out.println("Details Added Successfully");
        	 }
        	 catch(SQLException e) {
        		 e.printStackTrace();
        	 }
        	 break;
         case "3":
        	 try(Connection connection = DriverManager.getConnection(continueUrl);Statement stmt = connection.createStatement();){
        		 System.out.println("Enter S_No you want to delete");
        		 var s_no = sc.nextLine();
        		 String delete = "delete from details where s_no = "+"s_no";
        		 stmt.executeUpdate(delete);
        		 System.out.println("Details Deleted Successfully");
        	 }
        	 catch (SQLException e) {
        		 e.printStackTrace();
        	 }
        	 break;
        	 
        	 default:
        		 System.out.println("You have selected wrong input");
        		 break;        	 
         }
         System.out.println("Enter y to continue: else press any other to exit");
         continuedata = sc.nextLine();
         if(continuedata.equals("y"))
         System.out.println("You have selected to continue");
	}
     while(continuedata.equals("y"));
     System.out.println("you have exited the program");
}
}