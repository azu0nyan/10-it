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

/*
Пример json для парсинга
{
	"name": "Luke Skywalker",
	"height": 172,
	"mass": 77,
	"hair_color": "blond",
	"skin_color": "fair",
	"eye_color": "blue",
	"birth_year": "19BBY",
	"gender": "male",
	"isReal": false,
	"someData": null,
	"homeworld": "https://swapi.dev/api/planets/1/",
	"films": [
		"https://swapi.dev/api/films/2/",
		"https://swapi.dev/api/films/6/",
		"https://swapi.dev/api/films/3/",
		"https://swapi.dev/api/films/1/",
		"https://swapi.dev/api/films/7/"
	],
	"species": [
		"https://swapi.dev/api/species/1/"
	],
	"vehicles": [
		"https://swapi.dev/api/vehicles/14/",
		"https://swapi.dev/api/vehicles/30/"
	],
	"starships": [
		"https://swapi.dev/api/starships/12/",
		"https://swapi.dev/api/starships/22/"
	],
	"created": "2014-12-09T13:50:51.644000Z",
	"edited": "2014-12-20T21:17:56.891000Z",
	"url": "https://swapi.dev/api/people/1/",
	"nested": {
        "array": [1, 2]
	}
}

Пример запросов к

name            -> Luke Skywalker
films[2]  	    -> https://swapi.dev/api/films/3/
nested.array[0] -> 1

 */