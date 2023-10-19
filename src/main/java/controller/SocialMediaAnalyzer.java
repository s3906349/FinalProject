package main.java.controller;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import main.java.model.SocialMediaPost;


public class SocialMediaAnalyzer{
private PostManagement postFuncManagement;

//Constructor that intializes the postmanagement object
public SocialMediaAnalyzer(ArrayList<SocialMediaPost> posts){
this.postFuncManagement=new PostManagement();
}
//Method to run main method
public void run(){
   Scanner userInput = new Scanner(System.in);
int choice;
ArrayList<SocialMediaPost> csvPosts = Main.readPostsFromCSV("posts.csv");

do{
   try{
      displayMainMenu(); //calls main menu
   choice = userInput.nextInt();
   
   switch (choice){
case 1:
postFuncManagement.addPost(csvPosts,userInput); //call addpost method here 
break;
case 2:
postFuncManagement.deletePost(csvPosts, userInput);//call deletepost method here 
break;
case 3:
postFuncManagement.retrievePost(csvPosts,userInput); //call retrieve method here
break;
case 4:
postFuncManagement.retrieveTopPostsLikes(csvPosts,userInput); //call retrieve top posts by likes method here
break;
case 5:
postFuncManagement.retrieveTopPostsShares(csvPosts,userInput); //call retrieve top posts by shares method here
break;
case 6:
System.out.println("Exiting the program. Thanks for using our Social Media Analyzer.");
break;
default:
System.out.println("Invalid choice. Please enter a valid number.");
   }
} catch (InputMismatchException e){ //exception for valid choice 
   System.out.println("Invalid input. Please enter a valid number. ");
   userInput.nextLine();
   choice =0;
}
}while(choice!= 6 );
}
//Display main menu 
   void displayMainMenu() {
      System.out.println("Select from main menu");
      System.out.println("1) Add a social media post");
      System.out.println("2) Delete an existing social media post");
      System.out.println("3) Retrieve a social media post");
      System.out.println("4) Retrieve the top N posts with most likes");
      System.out.println("5) Retrieve the top N posts with most shares");
      System.out.println("6) Exit");
      System.out.print("Please select: ");
   }
   
   }
