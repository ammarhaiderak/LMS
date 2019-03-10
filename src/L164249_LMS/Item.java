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
public class Item {
    private String id;  
    private String title;
    private String author;
    private String sub;
    private String quan;
    
    Item(String id,String title,String author,String sub,String quan){
    this.id=id;
    this.title=title;
    this.author=author;
    this.sub=sub;
    this.quan=quan;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getSub() {
        return sub;
    }

    public String getQuan() {
        return quan;
    }
    
    
    
    
    
}
