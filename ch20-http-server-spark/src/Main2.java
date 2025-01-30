import spark.Spark;

public class Main2 {

    public static void main(String[] args) {
        Spark.get("/kek", ((request, response) -> "Hello from kek" + request.queryParams("mem")));
    }
}
