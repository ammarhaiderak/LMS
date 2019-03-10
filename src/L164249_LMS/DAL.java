/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Data Access Layer Connect to DB here
package L164249_LMS;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ammar
 */
public class DAL {
 private Connection con;//=this.connectDb();
//tatement stm;
 

 

 
 
 private final String []v={
 "B_ID",
 "B_TITLE",
 "B_AUTHOR",    
 "B_SUBJECT",
 "B_QUAN"
 };
 
 private final String []u={
"U_ID",
"PASSWORD",
"U_NAME",
"ADDRESS",
"ph_no",
"U_TYPE"
};

    public DAL() {
        try{         
      // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      // String URL="jdbc:sqlserver://DESKTOP-T2BCB89\\SQLEXPRESS01;" + "databaseName=L164249_LMS;integratedSecurity=true;";
      String URL="jdbc:sqlserver://DESKTOP-T2BCB89\\SQLEXPRESS01;databaseName=L164249_LMS"; 
      con=DriverManager.getConnection(URL,"new_user","1234");
        }
        catch(Exception e){
        }
    }
   public int loginUser(String id,String pw,String selection){
        
      //this.connectDb();
       CallableStatement cs;
       
       System.out.println("Loginmethod called\n");
       
        int result=0;
   try{
          cs=con.prepareCall("{call dbo.LOGIN_PROC(?,?,?,?)}");
          
          cs.registerOutParameter(4, java.sql.Types.INTEGER);
          
          cs.setString(1, id);
          
          cs.setString(2, pw);
          
          cs.setString(3, selection);
          
          cs.execute();
          
          result=cs.getInt(4);
          cs.close();
          
   }
   
   catch(Exception e){
   System.out.println(e.toString()+"login Procedure failed");
   }
    
   return result;     
        
    }

  
   
   
   public String signupUser(User u)
   {
       
       String uid=u.getU_ID();
       String pw=u.getPASSWORD();
       String name=u.getU_NAME();
       String add=u.getADDRESS();
       String ph=u.getUphno();
       String utype=u.getUtype();
       
        System.out.println(utype);
       
  String msg=" ";
  
  
  CallableStatement cs;
       // SIGNUP @U_ID VARCHAR(20),@PASSWORD VARCHAR(20),
//@NAME VARCHAR(20),@ADDRESS VARCHAR(50),@PHNO VARCHAR(20),@UTYPE VARCHAR(40)
//,@res int output
            
  try{
     int result=0;
     cs=con.prepareCall("{call dbo.SIGNUP(?,?)}");
     cs.registerOutParameter(2,java.sql.Types.INTEGER);
     cs.setString(1, uid);
     cs.execute();
     result=cs.getInt(2);
     cs.close();
  
//
  if(result==2){
      
      msg="User Already Present!";
  }
  else if(result==1){
      msg="Account Created!";
      


//  }
 
Statement st=con.createStatement(); 

    String query="INSERT INTO USERS" +
    " VALUES('"+uid+"','"+pw+"','"+name+"','"+add+"','"+ph+"','"+utype+"')";
    st.executeQuery(query);
    //st.close();
  }

  }catch(Exception ex){
  
  System.out.println(ex.toString());
  }
    
      System.out.println(msg);
  
  return msg;
   }
    
   
   
   public ArrayList<Book> getBooks(String title,String author,String subject,int mode){
   
  ArrayList<Book> temp2=new ArrayList<Book>();
   
   
   
   
   try{
       Statement stm=con.createStatement();
       String query1="Select* from Books";
       String query2="Select* from Books where B_TITLE LIKE '%"+title+"%' AND B_AUTHOR like '%"+author+"%' AND B_SUBJECT like '%"+subject+"%'";
       String query=null; 
       ResultSet rs;
 
       if(mode==1){
       query=query1;
       }
       else if(mode==2){
       query=query2;
       }
       
       if(query!=null){
       rs=stm.executeQuery(query);
       
       
       while(rs.next()){
       Book temp= new Book(
       rs.getString(1),
       rs.getString(2),
       rs.getString(3),
       rs.getString(4),
       rs.getInt(5)
       );
       
       temp2.add(temp);
       
       }
       
       }
   }catch(Exception e){System.out.println(e.toString());}
   
   
   
   
   
   return temp2;
   }
   

   
   
   public User viewProfile(String uid){
        
       //ArrayList<String> x=new ArrayList<String>();
        User user=null;
      // connectDb();
         
        try{
        Statement st=con.createStatement();
        
        String query="select* from USERS where U_ID='"+uid+"'";
        ResultSet rs=st.executeQuery(query);
       
        rs.next();
                user=new User(
                rs.getString(1),
                rs.getString(2),        
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6)            
                );
                //{
               
                
        //System.out.println(x.toString());
        
        }catch(Exception ex){
        
            System.out.println(ex.toString());
        }
        return user;
   }
   
   

   
   public int additem(Item it){
       String bid=it.getId();
       String title=it.getTitle();
       String auth=it.getAuthor();
       String sub=it.getSub();
       String quan=it.getQuan();
               
       
       
       
       int resp=0;
       
       try{
           String q="{call ADDITEM(?,?,?,?,?,?)}";
           CallableStatement cs=con.prepareCall(q);
           cs.registerOutParameter(6,java.sql.Types.INTEGER);
           cs.setString(1,bid);
           cs.setString(2, title);
           cs.setString(3,auth);
           cs.setString(4,sub);
           cs.setString(5, quan);
           cs.execute();
           resp=cs.getInt(6);
           //cs.close();
           
       }catch(Exception e){System.out.println(e.toString());};
       
       
       return resp;
   }
   public int removeitem(String id){
   int resp=0;
   
   try{
      CallableStatement cs=con.prepareCall("{call dbo.REMOVEITEM(?,?)}");
      cs.registerOutParameter(2, java.sql.Types.INTEGER);
      cs.setString(1, id);
      cs.execute();
      resp=cs.getInt(2);
   
   }catch(Exception e){System.out.println(e.toString());}
   
   
   
   
   return resp;
   
   }
   
   
   public String changeitem(String val,int position,String bid)
   {
   int resp=0;
   String vx="";
   
   
   try{
        
       Statement st=con.createStatement();
       String query="update books set "+v[position]+"='"+val+"' where B_ID='"+bid+"'";
       st.executeQuery(query);
       
       System.out.println(vx);
       vx=v[position]+" has been updated!"; 
       
   }catch(Exception e){
       System.out.println(e.toString());
       vx="Error updating Item!";
   }
  
   return vx;
   }
 //@IDATE VARCHAR(50),@RETDATE VARCHAR(50),@BID VARCHAR(50),@UID VARCHAR(50)
   public void addLoan(String idate,String retdate,String bid,String uid){
   
      // connectDb();
       try{
      
      System.out.println(idate+" "+retdate+" "+bid+" "+uid);
           
      CallableStatement cs=con.prepareCall("{call dbo.LOANPROC(?,?,?,?)}");
      cs.setString(1,idate);
      cs.setString(2,retdate);
      cs.setString(3,bid);
      cs.setString(4,uid);
      cs.execute();
      
 
       }catch(Exception e){
       
       System.out.println(e.toString());
       
       }
  
   }
  
   public void checkin(String bid,String stid){
   
       
       
       try{
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("Select * from Books where B_ID='"+bid+"'");
       
           rs.next();
           String quan=rs.getString(5);
           int quant=Integer.valueOf(quan)+1;
           quan=quant+"";
           
           this.changeitem(quan, 4, bid);
           
           st.execute("delete from LOANS where U_ID='"+stid+"' AND B_ID='"+bid+"'");
         
           
           
           
           
           
       }catch(Exception e){System.out.println(e.toString());}
   
   }
   
   public ArrayList<Loan> getborrowed(String uid){
   ArrayList<Loan> ar=new ArrayList<Loan>();
   
   try{
   
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("Select* from Loans where U_ID='"+uid+"'");
       
       //String m="";
       while(rs.next()){
           
       //String m="";
       Loan l=new Loan(rs.getString(2),rs.getString(3),rs.getString(5),rs.getString(4));
       l.setApproved(rs.getInt(6));
       ar.add(l);
       
       }
       
       
   
   }catch(Exception e){
   
       System.out.println(e.toString());
   }
   
   
   
   
   return ar;
   }
   
   public void approveloan(String bid,String uid){
      // connectDb();
       try{
       Statement st=con.createStatement();
       String q="update Loans set APPROVED=1 WHERE B_ID='"+bid+"' AND U_ID='"+uid+"'";
       st.execute(q);
       String q2="select* from Books where B_ID='"+bid+"'";
       ResultSet rs=st.executeQuery(q2);
       rs.next();
       String quan=rs.getString(5);
       
       int quant=Integer.valueOf(quan)-1;
       quan=quant+"";
       
       this.changeitem(quan, 4, bid);
       
       }catch(Exception e){
       System.out.println(e.toString());
       
       }
       
   
   }
   //String idate,String rdate,String uid, String bid
   
   public ArrayList<Loan> getloans(){           //not approved loans
   ArrayList<Loan> al=new ArrayList<Loan>(); 
   
   try{
   Statement st=con.createStatement();
   ResultSet rs=st.executeQuery("Select* from LOANS where APPROVED != 1 ORDER BY U_ID");
   while(rs.next()){
   Loan l=new Loan(rs.getString(2),rs.getString(3),rs.getString(5),rs.getString(4));
   al.add(l);
   }
   
   
   }catch(Exception e){
   System.out.println(e.toString());
   
   }
   
   
   return al;
   }
   
   public ArrayList<Loan> getloans2(){           //approved loans
   ArrayList<Loan> al=new ArrayList<Loan>(); 
   
   try{
   Statement st=con.createStatement();
   ResultSet rs=st.executeQuery("Select* from LOANS ORDER BY U_ID");
   while(rs.next()){
   Loan l=new Loan(rs.getString(2),rs.getString(3),rs.getString(5),rs.getString(4));
   al.add(l);
   }
   
   
   }catch(Exception e){
   System.out.println(e.toString());
   
   }
   
   
   return al;
   }
   
   
   
   
   
   
   public String changeUser(String val,int position,String uid)
   {
   int resp=0;
   String vx="";
   
   String cx=u[position];
   try{
      vx=cx +" has been updated!";  
       Statement st=con.createStatement();
       String query="update USERS set "+u[position]+"='"+val+"' where U_ID='"+uid+"'";
       st.execute(query);
       
       System.out.println(vx);
       
   }catch(Exception e){
       System.out.println(e.toString());
       vx=cx + "is not Updated!";
       
   }
  
   return vx;
   }
   public void renewItem(String uid,String bid,String retdate){
   
      // SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
       try{
        //    Date d=sdf.parse(retdate);
             String query="update loans set RETURN_DATE='"+retdate+"' where U_ID='"+uid+"' AND B_ID='"+bid+"'";
      
           Statement st=con.createStatement();
           st.execute(query);
       }
       catch(Exception e){
           System.out.println(e.toString());
       }
       
       
       
   }
   
   public int removeStudent(String uid){
       int resp=-1;
       try{
          String query="{call dbo.REMOVEUSER(?,?)}";
          CallableStatement cs=con.prepareCall(query);
          cs.registerOutParameter(2,java.sql.Types.INTEGER);
          cs.setString(1, uid);
          
          cs.execute();
           
          resp= cs.getInt(2);
           
       
       }catch(Exception e){
       System.out.println(e.toString());
       }
       
       return resp;
   }
   
   
   
}
