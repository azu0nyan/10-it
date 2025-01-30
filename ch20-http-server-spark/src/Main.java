import  spark.Spark;
/*
   com.sparkjava.spark-core:2.9.4
 */
public class Main {
    public static void main(String[] args) {
        Spark.get("/", (request, response) -> "Hello from Spark!");
        Spark.get("/cat", (request, response) -> {
                    var p1 = request.queryParams("p1");
                    var p2 = request.queryParams("p2");
                    var userAgent = request.headers("user-agent");
                    return "ConCATenataion result: " + p1 + p2 + " <br>" + userAgent;
                }
        );
        System.out.println("Serving on http://localhost:" + Spark.port());
    }
}