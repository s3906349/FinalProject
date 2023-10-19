package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.SocialMediaPost;

public class PostManagement {
    public void addPost(ArrayList<SocialMediaPost> posts, Scanner add) {
        // Implement adding a post
        try {
            System.out.print("Please provide the post ID: ");
            int id = add.nextInt();
            add.nextLine(); // Consume newline
    
            System.out.print("Please provide the post content: ");
            String content = add.nextLine();
    
            System.out.print("Please provide the post author: ");
            String author = add.nextLine();
    
            System.out.print("Please provide the number of likes of the post: ");
            int likes = add.nextInt();
    
            System.out.print("Please provide the number of shares of the post: ");
            int shares = add.nextInt();
    
            add.nextLine(); // Consume newline
    
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date timestamp = null;
    
            boolean validDate = false;
            while (!validDate) {
                try {
                    System.out.print("Please provide the date and time of the post in the format of DD/MM/YYYY HH:MM: ");
                    String dateString = add.nextLine();
                    timestamp = dateFormat.parse(dateString);
                    validDate = true;
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Please enter the date in the format DD/MM/YYYY HH:MM.");
                }
            }
    
            // This will perform the addition of the user-input posts into an ArrayList
            SocialMediaPost newPost = new SocialMediaPost(id, content, author, likes, shares, timestamp);
            posts.add(newPost);
            System.out.println("Post added successfully!");
            System.out.println(newPost.toString());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid value");
            add.nextLine();
        }
}
    //display posts
    public static void displayPosts(ArrayList<SocialMediaPost>newposts){
        System.out.println("List of added posts: ");
        for (int i = 0; i<newposts.size(); i++){
            SocialMediaPost post = newposts.get(i);
            System.out.println("Post #" + (i+1));
        System.out.println("ID: "+ post.getid()+ ", Content: "+ post.getContent()+ ", Author: " + post.getAuthor()+ "Likes: "+ post.getLikes()+ "Shares: "+ post.getShares()+ "Date|Time: "+ post.getTimestamp());
        }
    }

    // Implement deleting a post
    public void deletePost(ArrayList<SocialMediaPost>posts, Scanner delete) {
        displayPosts(posts);
        System.out.print("Enter the ID of the post you want to delete: ");
    int postIDToDelete= delete.nextInt();
    boolean postFound=false;
    for (int i = 0; i<posts.size(); i++){
        SocialMediaPost post = posts.get(i);
if (post.getid()== postIDToDelete){
    posts.remove(i);
    System.out.println("Post with ID " + postIDToDelete + " has been deleted.");
postFound=true;
break;
    }
}
if(!postFound){
    System.out.println("Post with ID " + postIDToDelete + " not found.");
    }
}
// Implement retrieving a post
    public void retrievePost(ArrayList<SocialMediaPost> posts, Scanner retrieve) {
        System.out.print("Please provide the Post Id to be retrieved: ");
        int postIDToRetrieve= retrieve.nextInt();
SocialMediaPost foundPost = null;

    for (SocialMediaPost post : posts){
if (post.getid()== postIDToRetrieve){
    foundPost = post;
    break;
}
    }
if(foundPost!= null){
    System.out.println("Retrieved Post: ");
    System.out.println(foundPost.toString());
}else{
    System.out.println("Post with ID" + postIDToRetrieve + " not found. ");
}
    }
// Implement retrieving top posts by likes 
    public void retrieveTopPostsLikes(ArrayList<SocialMediaPost> posts, Scanner numberL) {
      
    boolean validInput =false;
        while(!validInput){
System.out.print("Please specify the No. of posts to retrieve: ");
        int n = numberL.nextInt();
if(n>posts.size()){
System.out.println("The requested number of posts exceeds the available posts");
System.out.println("There are only " + posts.size() + " posts available.");
}else{
//Sort the post by likes in a decending order 
posts.sort((post1, post2) -> post2.getLikes()- post1.getLikes());
System.out.println("Top " + n + " Posts by Likes:");
for(int i=0; i<n && i < posts.size(); i++){
    System.out.println("Rank " + (i+1)+ ":" + posts.get(i).toStringLikes());
    }
    validInput = true;
}
} 
    }
    
// Implement retrieving top posts by shares
public void retrieveTopPostsShares(ArrayList<SocialMediaPost> posts, Scanner numberS) {
boolean validInput = false;
while(!validInput){
    System.out.println("Please specify the No. of posts to retrieve: ");
int n = numberS.nextInt();
if (n>posts.size()){
System.out.println("The requested number of posts exceeds the available posts");
System.out.println("There are only " + posts.size() + " posts available.");
}else{
//Sort the post by shares in a decending order 
posts.sort((post1, post2) -> post2.getShares()- post1.getShares());
System.out.println("Top " + n + " Posts by Shares:");
for(int i=0; i<n && i < posts.size(); i++){
    System.out.println("Rank " + (i+1)+ ":" + posts.get(i).toStringShares());
    }
    validInput = true;
}
}
}
}



