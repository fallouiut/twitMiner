import twitter4j.*;
import twitter4j.auth.AccessToken;

import java.util.ArrayList;
import java.util.List;

// api key: etTdQUBxUMRC2RqGAq1yt6Yw8

// Consumer Key (API Key)       etTdQUBxUMRC2RqGAq1yt6Yw8
// Consumer Secret (API Secret) e7bK03FK0reXT1kVauQeraj0T8dg5AGvaQy35Ook1lTEEtwUbu
// Access Token        969509345313591296-PrpHRN2mznGhsk3o3otyPtnovQDjKyY
// Access Token Secret 2o7adEgNULFJ9aHe1QuSpfmY0rNyT0sJ1onMbfnw1RXxJ
// Owner Seye38738676
// Owner ID 969509345313591296


public class TwittterService {

    private Twitter twitter;

    public TwittterService(){

        this.twitter = new TwitterFactory().getInstance();
        String consumerKey = "etTdQUBxUMRC2RqGAq1yt6Yw8";
        String consumerSecret = "e7bK03FK0reXT1kVauQeraj0T8dg5AGvaQy35Ook1lTEEtwUbu";
        String accessToken = "969509345313591296-PrpHRN2mznGhsk3o3otyPtnovQDjKyY";
        String accessTockenSecret = "2o7adEgNULFJ9aHe1QuSpfmY0rNyT0sJ1onMbfnw1RXxJ";


        twitter.setOAuthConsumer(consumerKey, consumerSecret);
        twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTockenSecret));

    }

    public List<Status> getByHashTag(String hashtag) throws TwitterException{

        Query query = new Query("VendrediLecture");
        query.count(101);
        QueryResult qres = this.twitter.search(query);

        return qres.getTweets();
    }


}

