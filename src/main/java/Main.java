import com.sun.org.apache.xpath.internal.SourceTree;
import twitter4j.*;
import twitter4j.api.DirectMessagesResources;
import twitter4j.auth.AccessToken;

import java.util.List;

public class Main {
    public static void main(String args[]){

        TwittterService tws = new TwittterService();

        int compteur = 0;
        try{
            for(Status s: tws.getByHashTag("OMBilbao")) {
                System.out.println("@" + s.getUser().getName() + ": " + s.getText() + " / " + s.getGeoLocation());
                ++compteur;
            }

            System.out.println("Il y a eu: " + compteur + " tweets concernant ce hashtag");

        }
        catch(TwitterException te){
            System.out.println("Exception Twitter: ");
            te.getMessage();
            te.printStackTrace();
        }
   }
}
