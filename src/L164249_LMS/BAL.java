/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Business Access Layer Class 
package L164249_LMS;

import java.util.ArrayList;

/**
 *
 * @author ammar
 */
public class BAL {
static final int U_ID=0; 
static final int PASSWORD=1;
static final int U_NAME=2;
static final int ADDRESS=3;
static final int PH_NO=4;
static final int U_TYPE=5;

 
   
   private  DAL dbconnector;
    
   //constructor
   
   public BAL() {
    
        
        dbconnector=new DAL();
        
     
       
    }
    
   
    public String loginUser(String id,String pw,String selection){
    
    String message=" ";   
    
    int response=dbconnector.loginUser(id, pw,selection);
    if(response==4){
    message="Incorrect Selection of user type!";
    }
    else if(response==1){
    message="Login Successful!";
    }
    else if(response==3){
    message="incorrect Password!";
    }
    else if(response==2){
    message="incorrect Login and Password!";
    }
        
        return message;
    }
    
    //CREATE PROCEDURE SIGNUP @U_ID VARCHAR(20),@PASSWORD VARCHAR(20),
//@NAME VARCHAR(20),@ADDRESS VARCHAR(50),@PHNO VARCHAR(20),@UTYPE VARCHAR(40)
    public String signup(User u){
    String msg=" ";    
            
            if(u.getU_ID().equals("")||u.getPASSWORD().equals("")||
                    u.getU_NAME().equals("")||
                    u.getADDRESS().equals("")||
                    u.getADDRESS().equals(""))
                
            {
            msg="Empty Fields not allowed";
            }    
            else if(u.getU_ID().length()>20){
            msg="ID must be less than 20 characters";
            }    
            else if(u.getPASSWORD().length()>20){
            msg="Password must be less than 20 characters";
            }
            else
                msg=dbconnector.signupUser(u);
            
           
    return msg;
    }
    
    
    public ArrayList<Book> getBooks(String title,String author,String subject,int mode){
    //ArrayList<String> books=new ArrayList<String>();
    
    return dbconnector.getBooks(title,author,subject,mode);
    
    //return books;
    }
    
    
    public User viewProfile(String uid){
        return dbconnector.viewProfile(uid);     
    }
    
     public int additem(Item i){
     int resp=0;
     
     resp=dbconnector.additem(i);
     
     return resp;
     
     }

     public int removeitem(String bid){
         return dbconnector.removeitem(bid);
     }

     public String changeitem(String val,int position,String bid){
         return dbconnector.changeitem(val, position, bid);
     }
    //@IDATE VARCHAR(50),@RETDATE VARCHAR(50),@BID VARCHAR(50),@UID VARCHAR(50) 
     public void addloan(Loan l){
     ArrayList<String>bids=new ArrayList<String>();
     bids.addAll(l.getB_ID());
     
     
     for(int i=0;i<bids.size();++i){
       dbconnector.addLoan(l.getISSUE_DATE(),l.getRETURN_DATE(),bids.get(i),l.getU_ID());
      // System.out.println(bids.get(i).length());
     }
     
     
     
     }
     public void checkin(String bid,String stid){
     
         dbconnector.checkin(bid, stid);
      
     }
     public ArrayList<Loan> getborrowed(String uid){
     
         return dbconnector.getborrowed(uid);
     }
     
     public void approveloan(String bid,String uid){
     
         dbconnector.approveloan(bid,uid);
     }
     
     public ArrayList<Loan> getloans(){
     
         return dbconnector.getloans();
     }
     
   public String changeUser(String val,int position,String uid)
   {
       return dbconnector.changeUser(val, position, uid);
   }
   
   public void renewItem(String uid,String bid,String retdate){
       dbconnector.renewItem(uid, bid, retdate);       
   }
   
    public ArrayList<Loan> getloans2(){
        return dbconnector.getloans2();
    }
   
    public int removeStudent(String uid){
        return dbconnector.removeStudent(uid);
    }
     
}
