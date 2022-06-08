package DB;

import java.sql.*;
import java.util.Scanner;
public class crud_operations
{
public static void main(String[] args)
{
String data = null;
System.out.println("\tHello\t");
try
{
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","Loga@2000");
if (con != null) {
System.out.println("\t Database Connected \t");
}
} catch (Exception e) {
System.err.println(e.getClass().getName() + ": "+ e.getMessage());
System.exit(0);
}

do
{
System.out.println("\t Select the option below \t");
System.out.println("\tPress 1 to select Data \t \n \tPress 2 to insert Data \t \n \t.Press 3 to update Data\t \n \tPress 4 to delete Data\t");
@SuppressWarnings("resource")
Scanner sc = new Scanner(System.in);
String input= sc.nextLine();

switch (input)
{
case "1":
try (Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","Loga@2000"))
{
Statement st=con.createStatement();
ResultSet rs1=st.executeQuery("select* from details");
while(rs1.next())
{
System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3));
}
}
catch(Exception e)
{
System.out.println(e.toString());
}
break;

case "2":
try (Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","Loga@2000"))
{


String sql= "INSERT INTO details (s_no,name,age) VALUES (?,?,?)";
PreparedStatement smt = con.prepareStatement(sql);
smt.setInt(1,4);
smt.setString(2,"Raja");
smt.setInt(3,24);
System.out.println(smt);
int inserted = smt.executeUpdate();
if (inserted>0)
{
System.out.println("\tAdded successfully\t");
       }
}
catch(Exception e)
{
System.out.println(e.toString());
}
break;

case "3":
try (Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","Loga@2000"))
{
String sql = "UPDATE details SET age=? WHERE s_no=?";
PreparedStatement smt = con.prepareStatement(sql);
smt.setInt(1,24);
smt.setInt(2,1);
System.out.println(smt);
int updated = smt.executeUpdate();
if (updated>0)
{
System.out.println("\tUpdated successfully\t");
       }
}
catch(Exception e)
{
System.out.println(e.toString());
}
break;

case "4":
try (Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","Loga@2000"))
{
String sql = "DELETE FROM details4 WHERE s_no=?";
PreparedStatement smt = con.prepareStatement(sql);
smt.setInt(1,4);
int deleted = smt.executeUpdate();
if (deleted>0)
{
   System.out.println("\tDeleted successfully\t");
       }
}
catch(Exception e)
{
System.out.println(e.toString());
}
break;

default:
System.out.println("\tYou are selected out of range\t");
break;
}
System.out.println("\tEnter y to continue (or) Enter z for EXIT\t");
data = sc.nextLine();
if (data.equals("z"))
System.out.println("\tYou are EXIT the Program\t");
} while (data.equals("y"));
 System.out.println("\t You Have selected to continue ... \t");
}
}