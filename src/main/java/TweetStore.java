import com.sun.xml.internal.ws.api.message.Packet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import twitter4j.*;
public class TweetStore {

    private String fileName;
    private List<Status> tweets;

    public TweetStore(List<Status> status, String fileName){

        this.fileName = fileName;
        this.tweets = status;

    }

    public void store() throws IOException{

        FileWriter myFile = new FileWriter(this.fileName, true);
        BufferedWriter bf = new BufferedWriter(myFile);

        for(Status status: this.tweets) {
            String user = "\"" + "@" + status.getUser().getName() + "\"";
            String date = "\"" + status.getCreatedAt().toString() + "\"";
            // décompose le text en tableau de mots
            String[] text = status.getText().split("\\s");

            String separator = ";";
            String nextLine = "\n";

            bf.append(date);
            bf.append(separator);
            bf.append(user);

            for (int i = 0; i < text.length; ++i) {
                bf.write(separator);
                String lineToAdd = "\"" + text[i] + "\"";
                bf.append(lineToAdd);
            }
            bf.append(nextLine);
        }

        bf.close();
        myFile.close();

    }
}
