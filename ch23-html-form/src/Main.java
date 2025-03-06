import  spark.Spark;
public class Main {
    public static void main(String[] args) {
        Spark.staticFileLocation("");
        Spark.get("/login", (request, response) -> {
                    var login = request.queryParams("login");
                    var password = request.queryParams("password");
                    if (login.equals("admin") && password.equals("123")) {
                        return "secret";
                    } else {
                        response.redirect("/index.html");
                        return "";
                    }
                }
        );

    }
}