/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package L164249_LMS;

/**
 *
 * @author ammar
 */
public class User {
  private String U_ID;
  private String PASSWORD;
  private String U_NAME;
  private String ADDRESS;
  private String Utype;
  private String Uphno;
    
    User(String uid,String pw,String un,String add,String phno,String ut){
    this.U_ID=uid;
    this.ADDRESS=add;
    this.PASSWORD=pw;
    this.U_NAME=un;
    this.Utype=ut;
    this.Uphno=phno;
    }

    public String getU_ID() {
        return U_ID;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getU_NAME() {
        return U_NAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public String getUtype() {
        return Utype;
    }

    public String getUphno() {
        return Uphno;
    }

    @Override
    public String toString() {
       // return super.toString(); //To change body of generated methods, choose Tools | Templates.
       return  (this.U_ID+" | "+this.PASSWORD+" | "+this.U_NAME+" | "+
               this.ADDRESS+" | "+this.Uphno+" | "+this.Utype
               );
    
    }
   
    
    
   
   
}
