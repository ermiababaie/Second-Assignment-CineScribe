import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
public class Actors {
    public static final String API_KEY = "XIheTcCoz15ScEiySz8R/Q==eXNvYqfHuLJy4jT7";   // TODO --> add your api key about Actors here
    String netWorth;
    Boolean isAlive;

    public Actors(String netWorth, boolean isAlive){
        this.isAlive = isAlive;
        this.netWorth = netWorth;
    }
    @SuppressWarnings({"deprecation"})
    /**
     * Retrieves data for the specified actor.
     * @param name for which Actor should be retrieved
     * @return a string representation of the Actors info or null if an error occurred
     */
    //[{"name": "leonardo dicaprio", "net_worth": 260000000, "gender": "male", "nationality": "us", "occupation": ["actor", "film_producer", "television_producer"], "height": 1.83, "birthday": "1974-11-11", "age": 49, "is_alive": true}]
    public String getActorData(String name) {
        try {
            URL url = new URL("https://api.api-ninjas.com/v1/celebrity?name="+
                    name.replace(" ", "+")+"&apikey="+"XIheTcCoz15ScEiySz8R/Q==eXNvYqfHuLJy4jT7");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("X-Api-Key", "XIheTcCoz15ScEiySz8R/Q==eXNvYqfHuLJy4jT7");
            System.out.println(connection);
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();
                return response.toString().substring(1, response.toString().length() - 1);
            } else {
                return "Error: " + connection.getResponseCode() + " " + connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public double getNetWorthViaApi(String actorsInfoJson){
        double result = 0.0;
        JSONObject jo = new JSONObject(actorsInfoJson);
        result = jo.getDouble("net_worth");
        return result;
    }

    public boolean isAlive(String actorsInfoJson){
        boolean statues = false;
        JSONObject jo = new JSONObject(actorsInfoJson);
        statues = jo.getBoolean("is_alive");
        return statues;
    }

    public String getDateOfDeathViaApi(String actorsInfoJson){
        String date = "";
        JSONObject jo = new JSONObject(actorsInfoJson);
        if (isAlive(actorsInfoJson)) {
            date = "not yet :)";
        }
        else {
            date = jo.getString("death");
        }
        return date;
    }

}
