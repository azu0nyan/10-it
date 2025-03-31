package app;

import db.DB;
import server.*;
import spark.Spark;

public class Main {


    public static void main(String[] args) throws Throwable {

//        DB.init();
        Spark.externalStaticFileLocation("static");
        Spark.port(4567);


//        Spark.get("/", (req, res) -> );
        //Страницы
        Spark.get("/", AuthRoute.authRoute(PageMaker::makeMainPageForUser, "/anonMain", 200));
        Spark.get("/anonMain", PageMaker::makeMainPage);
        Spark.get("/register", PageMaker::makeRegistrationPage);
        Spark.get("/login", PageMaker::makeLoginPage);
        Spark.get("/hidden", AuthRoute.authRoute(PageMaker::makeHiddenPage));
        Spark.get("/searchUsers", PageMaker::makeSearchUsersPage);

        //запросы
        Spark.get("/searchUsersReq", SearchUser::searchUser);
        Spark.post("/submitRegister", Register::registerUser);
        Spark.post("/submitLogin", Login::loginUser);

    }


}