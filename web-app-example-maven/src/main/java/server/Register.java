package server;

import db.DB;
import db.HumanDAO;
import db.model.Human;
import spark.*;

import java.sql.Connection;

public class Register {
    public static String registerUser(Request request, Response response) {

        try {
            var login = request.queryParams("login");
            var password = request.queryParams("password");

            Connection connection = DB.getConnection();
            var inserted = HumanDAO.insertNew(new Human(login, password), connection);
            connection.close();

            response.redirect("/login");
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            response.status(500);
            return "ERROR";
        }
    }
}
