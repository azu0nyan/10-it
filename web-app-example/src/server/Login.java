package server;

import db.DB;
import db.HumanDAO;
import db.model.Human;
import spark.Request;
import spark.Response;

public class Login {
    public static String loginUser(Request request, Response response) {

        try {
            var login = request.queryParams("login");
            var password = request.queryParams("password");

            var inDb = HumanDAO.selectByLogin(login, DB.getConnection());
            if(inDb != null && inDb.password.equals(password)) {
                response.cookie("username", inDb.login);
                response.redirect("/hidden");
            } else
              response.redirect("/login");
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            response.status(500);
            return "ERROR";
        }
    }
}
