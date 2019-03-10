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
public class Book{
private String B_ID;
private String B_TITLE;
private String B_AUTHOR;
private String B_SUBJECT;
private int B_QUAN;
    
public Book(String B_ID,
String B_TITLE,
String B_AUTHOR,
String B_SUBJECT,
int B_QUAN
){
    this.B_ID=B_ID;
    this.B_TITLE=B_TITLE;
    this.B_AUTHOR=B_AUTHOR;
    this.B_SUBJECT=B_SUBJECT;
    this.B_QUAN=B_QUAN;
}

    public String getB_ID() {
        return B_ID;
    }

    public String getB_TITLE() {
        return B_TITLE;
    }

    public String getB_AUTHOR() {
        return B_AUTHOR;
    }

    public String getB_SUBJECT() {
        return B_SUBJECT;
    }

    public int getB_QUAN() {
        return B_QUAN;
    }

    @Override
    public String toString() {
       // return super.toString(); //To change body of generated methods, choose Tools | Templates.
    
       return (this.B_ID+" | "+
               this.B_AUTHOR+" | "+
               this.B_SUBJECT+" | "+
               this.B_TITLE+" | "+
               this.B_QUAN
               );
    
    }

    
    
    






}
