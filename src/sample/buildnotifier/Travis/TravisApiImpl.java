package sample.buildnotifier.Travis;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TravisApiImpl implements TravisApi {

    private String sendGet(String url) throws Exception{

        URL httpURL = new URL(url);
        HttpURLConnection connection = (HttpURLConnection)httpURL.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Travis-API-Version", "3" );
        connection.setRequestProperty("User-Agent", "API Explorer" );
        connection.setRequestProperty("Authorization", "token mUPHlKB7W8VQfrLq25L8cw" );

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();

        return response.toString();
    }

    @Override
    public TravisUser getUser() throws Exception{
        String response = this.sendGet("https://api.travis-ci.com/user");

        Gson gson = new GsonBuilder().create();
        TravisUser travisUser = gson.fromJson(response, TravisUserImpl.class);

        return travisUser;
    }

    @Override
    public TravisRepoData getRepoData() throws Exception {
        String response = this.sendGet("https://api.travis-ci.org/repo/vitorgroter%2Fhelloworld_java/builds");

        Gson gson = new GsonBuilder().create();
        TravisRepoData travisRepo = gson.fromJson(response, TravisRepoDataImpl.class);

        return travisRepo;
    }
}
