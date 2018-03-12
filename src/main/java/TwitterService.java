import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;

// api key: etTdQUBxUMRC2RqGAq1yt6Yw8

// Consumer Key (API Key)       etTdQUBxUMRC2RqGAq1yt6Yw8
// Consumer Secret (API Secret) e7bK03FK0reXT1kVauQeraj0T8dg5AGvaQy35Ook1lTEEtwUbu
// Access Token        969509345313591296-PrpHRN2mznGhsk3o3otyPtnovQDjKyY
// Access Token Secret 2o7adEgNULFJ9aHe1QuSpfmY0rNyT0sJ1onMbfnw1RXxJ
// Owner Seye38738676
// Owner ID 969509345313591296


public class TwitterService {

    private Twitter twitter;

    public TwitterService(){

        String consumerKey = "etTdQUBxUMRC2RqGAq1yt6Yw8";
        String consumerSecret = "e7bK03FK0reXT1kVauQeraj0T8dg5AGvaQy35Ook1lTEEtwUbu";
        String accessToken = "969509345313591296-PrpHRN2mznGhsk3o3otyPtnovQDjKyY";
        String accessTockenSecret = "2o7adEgNULFJ9aHe1QuSpfmY0rNyT0sJ1onMbfnw1RXxJ";

        ConfigurationBuilder onf = new ConfigurationBuilder();
                onf.setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTockenSecret)
                .setTweetModeExtended(true);

        HttpParameter myParams = new HttpParameter("tweet_mode", "extended");


        TwitterFactory tf = new TwitterFactory(onf.build());
        this.twitter = tf.getInstance();
 }

    public List<Status> getByHashTag(String hashtag, String since, int nbMax) throws TwitterException{
        twitter.getUserTimeline();
        Query query = new Query(hashtag);

        if(since != null)
            query.setSince(since);


        query.count(nbMax);
        QueryResult qres = this.twitter.search(query);

        return qres.getTweets();

    }

    public void showTweets(List<Status> tweets){

        int compteur = 0;

        for(Status s: tweets) {
            System.out.println("@" + s.getUser().getName()  + ", Date: " + s.getCreatedAt().toString());
            System.out.println(s.getText());
            System.out.println("-----------------------------------------------------------------------------------------------");
            ++compteur;
        }

        System.out.println("Nous avons filtré " + compteur + " tweets");

    }


}


