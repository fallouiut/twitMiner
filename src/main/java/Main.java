import twitter4j.*;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String args[]) throws TwitterException{

        TwitterService tws = new TwitterService();

        int compteur = 0;
        try{

            // récupération des tweets en fonction du #hashtag + affichage
            //
            List<Status> tweets = tws.getByHashTag("Senegal", "2018-03-09", 10000);
            // tws.showTweets(tweets);

            // on range les tweets dans un fichier .csv
            TweetStore ts = new TweetStore(tweets, "motifs-frequents.sv");
            ts.store();
        }
        catch(TwitterException te){
            System.out.println("Exception Twitter: ");
            te.getMessage();
            te.printStackTrace();
        }
        catch(IOException ioe){
            System.out.println("Exception FileWriter: ");
            ioe.getMessage();
            ioe.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Exception inconnue: ");
            e.getMessage();
            e.printStackTrace();
        }

    }
}
