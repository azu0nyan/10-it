import com.google.gson.Gson;
import model.Character;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


/*
  gson:2.11.0

  Список публичных api
  https://github.com/public-apis/public-apis

  рекомендую
  https://pokeapi.co/



  используем
  https://jikan.moe/
 */
public class Main {

    public static void main(String[] args) throws Throwable {
        var jsonString = downloadFromUrl("https://api.jikan.moe/v4/characters/454/full");
        System.out.println(jsonString);
        Gson gson = new Gson();
        Character character = gson.fromJson(jsonString, Character.class);
        System.out.println(character);

        for(Character.Data.AnimeInner anime: character.data.anime) {
            System.out.println(anime.anime.url);
        }
    }

    static String downloadFromUrl(String url) throws Exception{
        // create a client
        var client = HttpClient.newHttpClient();

        // create a request
        URI uri = URI.create(url);
        var request =
                HttpRequest.newBuilder(uri)
                        .build();

        // use the client to send the request
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // the response:
        String jsonString = response.body();

        return jsonString;
    }
}