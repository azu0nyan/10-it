package app;

import db.DB;
import server.Register;
import spark.Spark;

public class Main {


    public static void main(String[] args) throws Throwable {

        DB.init();

        Spark.port(4567);
        Spark.staticFileLocation("/html");

        Spark.post("/submitRegister", Register::registerUser);


        Spark.get("/login", (req, res) -> "<h1>login page<h2>");

        Spark.get("/important-data", (req, res) -> {
                if(req.cookie("token").equals("Я залогинился мамой клянусь"))return "data";
                else return "No data";
        });

    }


}