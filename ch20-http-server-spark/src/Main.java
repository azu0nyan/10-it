import  spark.Spark;
/*
   com.sparkjava.spark-core:2.9.4

   Сделайте http сервер с 4мя РУЧКАМИ(endpoint, route, method, remote procedure)

   /add?p1=x&p2=y
   /sub?p1=x&p2=y
   /mull?p1=x&p2=y
   /div?p1=x&p2=y

   В итоге при запросе
   http://localhost:4567/add?p1=x&p2=y
   Пользователь должен увидеть сумму x и y
   Аналогично с разностью, произведением, частным для другиз трех запросоов

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