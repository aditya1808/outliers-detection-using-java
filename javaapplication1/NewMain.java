package javaapplication1;
import java.sql.*;
import java.util.Arrays;
class patient{
 int age;
 int id;
 String loc;
 String name;
 
 patient(int a,int i,String n,String l)
 {
     age=a;
     id=i;
     loc=l;
     name=n;
 }
}


class sortclass{
    int ids[];
    sortclass(int i)
    {
        ids=new int[i];
    }
void sort(int x[])
{
    Arrays.sort(x);
    
}
}


public class NewMain {     
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

          
    // stmt.executeUpdate(
      //        "INSERT INTO employee (name,age,id,loc)"
       //      + "VALUES ('ADI',23,10,'blr'),"
        //     + "('RAVI',22,11,'chennai'),"
        //   + "('X',20,12,'delhi');"
         //       );      
      
     
     ResultSet rs1=stmt.executeQuery(
             "SELECT name,age,id,loc FROM employee"
             );
         
     patient patients[] = new patient[10];    
      int patient_ids[]=new int[10];   
      int i=0;
      int q1=0;
      int q3=0;
      int iqr=0;
      int len;
      
      while(rs1.next()){
      if(i<10){
          
       int x = rs1.getInt("id");
       String y = rs1.getString("name");
       String z = rs1.getString("loc");
       int a = rs1.getInt("age");
       patients[i] = new patient(a,x,z,y);
       
       System.out.print(patients[i].id);
       System.out.print(patients[i].name);
       System.out.print(patients[i].loc);
       System.out.print(patients[i].age);
       System.out.println("done with one object");
       patient_ids[i]=patients[i].id;
       System.out.println(patient_ids[i]);
       i=i+1;
      }
      }
      
       System.out.println("");
       System.out.println("");
       System.out.println("");
       System.out.println("");
          
      System.out.println("olds array");
      for(int k=0;k<10;k++)
      {
          System.out.println(patient_ids[k]);
    
      }
      Arrays.sort(patient_ids);
      
      System.out.println("new array");
      
      for(int m=0;m<10;m++)
      {
          System.out.println(patient_ids[m]);
          
      }      
      len = patient_ids.length;
      if(len%2==0)
      {
      q1=patient_ids[len/4];
      q3=patient_ids[3*(len/4)];
      iqr=q3-q1;
      }
              
      else if(len%2==1)
      {
      System.out.println("not yet coded");
      }
      
      System.out.println(q1);
      System.out.println(q3);
      System.out.println(iqr);
      
      
      
        for(int m=0;m<10;m++)
      {
          int a = patients[m].age;
          int b = patients[m].id;
          String c = patients[m].name;
          String d = patients[m].loc;
          if(patients[m].id<q1)
          {
              
              stmt.executeUpdate("INSERT INTO emp_out (name,age,id,loc) VALUES"
                    + "('"+c+"','"+a+"','"+b+"','"+d+"')");
          }
          else if(patients[m].id>q3)
          {
               stmt.executeUpdate("INSERT INTO emp_out (name,age,id,loc) VALUES"
                      + "('"+c+"','"+a+"','"+b+"','"+d+"')");
              
          }
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
    }