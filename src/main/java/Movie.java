import com.fasterxml.jackson.annotation.JsonAnySetter;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.util.ArrayList;
public class Movie {
    public static final String API_KEY = "cd209874";
    int ImdbVotes;
    ArrayList<String> actorsList;
    String rating;

    public Movie(ArrayList<String> actorsList, String rating, int ImdbVotes){
        this.actorsList = actorsList;
        this.rating = rating;
        this.ImdbVotes = ImdbVotes;
    }

    @SuppressWarnings("deprecation")
    /**
     * Retrieves data for the specified movie.
     *
     * @param title the name of the title for which MovieData should be retrieved
     * @return a string representation of the MovieData, or null if an error occurred
     */

        public String getMovieData(String title) throws IOException {
        URL url = new URL("https://www.omdbapi.com/?t="+title+"&apikey="+"cd209874");
        URLConnection Url = url.openConnection();
        Url.setRequestProperty("Authorization", "Key" + "cd209874");
        BufferedReader reader = new BufferedReader(new InputStreamReader(Url.getInputStream()));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine())!=null) {
            stringBuilder.append(line);
        }
        reader.close();
        String error = stringBuilder.toString();
        if (error.substring(error.length() - 27).equals("\"Error\":\"Movie not found!\"}")) {
            return "please check movies name :(";
        }
        else
            return stringBuilder.toString();
    }
    public int getImdbVotesViaApi(String moviesInfoJson){
        int ImdbVotes = 0;
        JSONObject jo = new JSONObject(moviesInfoJson);
        ImdbVotes = Integer.parseInt(jo.getString("imdbVotes").replace(",", ""));
        return ImdbVotes;
    }

    public String getRatingViaApi(String moviesInfoJson){
        String rating = "";
        String imdbRating = "";
        JSONObject jo = new JSONObject(moviesInfoJson);
        imdbRating += jo.getString("imdbRating");
        return imdbRating + "/10";
    }

    public void getActorListViaApi(String movieInfoJson){
        JSONObject jo = new JSONObject(movieInfoJson);
        String save = jo.getString("Actors");
        for (int i = 0; i < save.length(); i++) {
            int j = i;
            String bazigar = "";
            while (j < save.length() && save.charAt(j) != ',') {
                bazigar += save.charAt(j);
                j++;
            }
            i = j;
            actorsList.add(bazigar);
        }
    }
}
