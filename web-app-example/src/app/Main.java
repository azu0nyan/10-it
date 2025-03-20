package app;

import db.DB;
import server.AuthRoute;
import server.Login;
import server.PageMaker;
import server.Register;
import spark.Spark;

public class Main {


    public static void main(String[] args) throws Throwable {

        DB.init();

        Spark.port(4567);


//        Spark.get("/", (req, res) -> );
        Spark.get("/", AuthRoute.authRoute(PageMaker::makeMainPageForUser, "/anonMain", 200));
        Spark.get("/anonMain", PageMaker::makeMainPage);
        Spark.get("/register", PageMaker::makeRegistrationPage);
        Spark.get("/login", PageMaker::makeLoginPage);

        Spark.get("/hidden", AuthRoute.authRoute(PageMaker::makeHiddenPage));

        Spark.post("/submitRegister", Register::registerUser);
        Spark.post("/submitLogin", Login::loginUser);

    }


}