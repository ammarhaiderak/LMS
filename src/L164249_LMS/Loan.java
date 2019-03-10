/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package L164249_LMS;

import java.util.ArrayList;

/**
 *
 * @author ammar
 */
public class Loan {
   private String  ISSUE_DATE;
   private String RETURN_DATE;
   private String  U_ID;
   private ArrayList<String> B_ID;    
   private int APPROVED;
   private String bkid;
   
   Loan(String idate,String rdate,String uid,ArrayList<String> bid){
   this.B_ID=bid;
   this.ISSUE_DATE=idate;
   this.RETURN_DATE=rdate;
   this.U_ID=uid;
   
   }
   
   Loan(String idate,String rdate,String uid, String bid){
   this.bkid=bid;
   this.ISSUE_DATE=idate;
   this.RETURN_DATE=rdate;
   this.U_ID=uid;
   }
   
   public void setApproved(int apr){
   APPROVED=apr;
   }
   

    public String getISSUE_DATE() {
        return ISSUE_DATE;
    }

    public String getRETURN_DATE() {
        return RETURN_DATE;
    }

    public String getU_ID() {
        return U_ID;
    }

    public ArrayList<String> getB_ID() {
        return B_ID;
    }
    public String getBKID(){
        return this.bkid;
    }

    @Override
    public String toString() {
        String apr="";
        if (APPROVED==0){
        apr="NOT APPROVED!";
        }
        else if(APPROVED==1){
        apr="APPROVED!";
        }
        
        return ( ISSUE_DATE + " | " + RETURN_DATE + " | " + U_ID + " | " + bkid + " | " + apr) ;
    }
    
    
   
   
   
}
