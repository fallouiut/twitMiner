import com.sun.org.apache.xpath.internal.SourceTree;
import twitter4j.*;
import twitter4j.api.DirectMessagesResources;
import twitter4j.auth.AccessToken;

import java.util.List;

public class Main {
    public static void main(String args[]) throws TwitterException{

        TwittterService tws = new TwittterService();

        int compteur = 0;
        try{

            List<Status> tweets = tws.getByHashTag("OMBilbao");
            tws.showTweets(tweets);

        }
        catch(TwitterException te){
            System.out.println("Exception Twitter: ");
            te.getMessage();
            te.printStackTrace();
        }
   }
}
