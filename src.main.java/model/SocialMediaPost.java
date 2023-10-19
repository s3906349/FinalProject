package main.java.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class SocialMediaPost{
    private int id;
    private String content;
    private String author;
    private int likes;
    private int shares;
    private Date timestamp;

    public SocialMediaPost(int id, String content, String author, int likes, int shares, Date timestamp) {
    this.id=id;
    this.content=content;
    this.author=author;
    this.likes=likes;
    this.shares=shares;
    this.timestamp=timestamp;
    }
    
    public int getid(){
    return id;

    }
    public String getContent(){

        return content;
    }

    public int getLikes(){
        return likes;
    }
    public int getShares(){
    return shares;
    }
    public String getAuthor(){
        return author;
    }
    public Date getTimestamp(){
        return timestamp;
     }
// where we will me adding only get id get content, get likes methods which will be used in the postmanagemnt class file.  

public String  toString (){ //useful for the retrieve posts 
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    String formattedTimestamp = dateFormat.format(timestamp);
    return "ID: " + id + ", " + " Content: " + content + ", " + " Author: " + author + ", " + " Likes: " + likes + ", " + " Shares: " +shares + ", " + " Date|Time: " + formattedTimestamp;
// "ID: "+ post.getid()+ ", Content: "+ post.getContent()+ ", Author: " + post.getAuthor()+ "Likes: "+ post.getLikes()+ "Shares: "+ post.getShares()+ "Date|Time: "+ post.getTimestamp()
}

public String  toStringLikes (){ // useful for retrive posts in terms of likes  
    return "ID: " + id + ", " + " Content: "+ content + ", "+ " Likes: " + likes ;
}

public String  toStringShares (){ // useful for retrive posts in terms of shares 
    return "ID: " + id + ", " + " Content: " + content + ", " + " Shares: " + shares ;
}
}

