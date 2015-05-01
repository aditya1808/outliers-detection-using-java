
package javaapplication1;

import java.sql.*;

public class JDBCExample {
  
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/db_proj";

  
   static final String USER = "root";
   static final String PASS = "";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
  
      Class.forName("com.mysql.jdbc.Driver");

  
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      
      System.out.println("Creating statement...");
      stmt = conn.createStatement();

      String sql = "SELECT id FROM employee";
      ResultSet rs = stmt.executeQuery(sql);
      
      while(rs.next()){
      
          int id  = rs.getInt("ID");
         
         //String age = rs.getString("addr");
         //String first = rs.getString("fn");
         //String last = rs.getString("ln");

      
      //   System.out.print("ID: " + id);
       
         //System.out.print(", Addr: " + age);
         //System.out.print(", First: " + first);
         //System.out.println(", Last: " + last);
      }
      rs.close();
      
      
      
      
      
      
      
      
      
      
      
     // stmt.executeUpdate(
       //   "CREATE TABLE testing "
       //   + "(name varchar(25),"
       //  + "age int,"
       // + "id int); "  
                         
        //      );
      
      String a = "aditya";
      int x = 23;
      int y = 1088;
     
      //stmt.executeUpdate(
      //        "INSERT INTO testing (name,age,id)"
       //      + "VALUES ('ADI',23,100),"
        //     + "('RAVI',22,101),"
         //  + "('X',20,103);"
      
     
       //                    );
      
      
      //stmt.executeUpdate("CREATE TABLE emp_out (name varchar(25),age int,id int,loc varchar(25));");
      
      // stmt.executeUpdate("INSERT INTO testing (name,age,id) VALUES"
        //      + "('"+a+"','"+x+"','"+y+"')");
              
     
     ResultSet rs1=stmt.executeQuery(
             "SELECT name,age,id,loc FROM emp_out;"
             );
     
     
         
    // ResultSet rs1 = stmt.executeQuery(
      //        "SELECT name,id,loc FROM employee2 WHERE id<103"
        //      );
      
      
      
      
      while(rs1.next()){
      
          int id  = rs1.getInt("id");
          String name = rs1.getString("name");
          String loc = rs1.getString("loc");
       int age = rs1.getInt("age");

      System.out.print("name: " + name);
         System.out.print("id: " + id);
         //System.out.print("loc: " + loc);
      System.out.print("age :" + age); 
         
         
         
         
         //THIS is to call another class from this program
         //for example we call NewMain from this class
         
         //new Thread(){
           // public void run() {
             //   NewMain.main(new String[]{});}
               // }.start();
         
         
      }
      rs1.close();      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample