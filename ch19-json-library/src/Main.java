import com.google.gson.Gson;
import model.Anime;
import model.Character;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


//https://github.com/public-apis/public-apis
public class Main {
    public static void main(String[] args) throws Throwable {
        // create a client
        var client = HttpClient.newHttpClient();

        // create a request
        URI uri = URI.create("https://api.jikan.moe/v4/anime/454/full");
        var request =
                HttpRequest.newBuilder(uri)
                        .build();

        // use the client to send the request
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // the response:
        String jsonString = response.body();
        System.out.println(jsonString);

        System.out.println("---------");
        Gson gson = new Gson();
        var anime = gson.fromJson(jsonString, Anime.class);
        System.out.println(anime);

//        var character = gson.fromJson(jsonString, Character.class);
//        System.out.println(character);

    }
}