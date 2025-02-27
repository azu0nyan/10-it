import  spark.Spark;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.ZonedDateTime;

/*
   com.sparkjava.spark-core:2.9.4

 */
public class Main {
    static String page = "";
    static {
        try {
            page = Files
                    .readAllLines(Path.of("index.html"))
                    .stream()
                    .reduce((x, y) -> x + y)
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String getPage() {
        var currentTime = ZonedDateTime.now();
        var result = page.replace("{{content}}", currentTime.toString());
        return result;
    }
    public static void main(String[] args) {
        //Дать доступ к файлам в classpath (папке src)
        Spark.staticFileLocation("");
        //Дать дотуп к файлам в рабочей папке
        Spark.externalStaticFileLocation("");


        Spark.get("/", (request, response) -> getPage());
        System.out.println("Serving on http://localhost:" + Spark.port());
    }
}