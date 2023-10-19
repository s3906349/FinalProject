    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.Date;

import main.java.controller.SocialMediaAnalyzer;
import main.java.model.SocialMediaPost;

    public class MyJavaFX {
        public static void main(String[] args) {
    //Define the name of the csv file containing posts 
    String filename = "posts.csv";
    //Read posts from the csv file intot he ArrayList
    ArrayList<SocialMediaPost> posts = readPostsFromCSV(filename);
    //Create a socialmediaanalyzer instane and pass the posts to it
    SocialMediaAnalyzer analyzer = new SocialMediaAnalyzer(posts);
    //run the social media analyzer
    analyzer.run();
    }
//function to read posts from a CSV file and return an ArrayList of Social Media Post
    static ArrayList<SocialMediaPost> readPostsFromCSV(String filename){
        ArrayList<SocialMediaPost> posts = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                boolean isFirstLine = true;
                while ((line = br.readLine()) != null) {
                    if (isFirstLine) {
                        isFirstLine = false;
                        continue; // Skip the header row
                    }
                    String[] data = line.split(",");
                    int id = Integer.parseInt(data[0]);
                    String content = data[1];
                    String author = data[2];
                    int likes = Integer.parseInt(data[3]);
                    int shares = Integer.parseInt(data[4]);
                    Date timestamp = parseDate(data[5]);

                    SocialMediaPost post = new SocialMediaPost(id,content,author,likes,shares,timestamp);
                    posts.add(post);
                }
            }catch (IOException e) {
                System.err.println("Error reading data from CSV file: "+ e.getMessage());
            }
        
            return posts;
        }
//Function to parse a dare string in the format date object
    private static Date parseDate(String dateString){
    try{

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    return dateFormat.parse(dateString);

    }catch (ParseException e){
        e.printStackTrace();
        return null;
    }

    }

    }
            




