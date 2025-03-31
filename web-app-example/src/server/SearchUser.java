package server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import db.DB;
import db.HumanDAO;
import db.model.Human;
import spark.*;

import java.sql.Connection;
import java.util.stream.Collectors;

public class SearchUser {
    public static String searchUser(Request request, Response response) {
        try{
            var query = request.queryParams("query");
            Connection connection = DB.getConnection();
            var result = HumanDAO.findLikeLogin(query, connection);
            connection.close();
            //Конвертируем Юзера из БД в юзера для ответа пользователю
            var toReturn = result.stream().map(ReturnedUser::fromUser).toList();
            Gson gson = new Gson();
            return gson.toJson(toReturn);
        } catch (Exception e) {
            e.printStackTrace();
            response.status(500);
            return "ERROR";
        }
    }

    //Класс с помощью которого мы задаем формат ответа
    private static class ReturnedUser{
        int id;
        String login;

        public ReturnedUser(int id, String login) {
            this.id = id;
            this.login = login;
        }

        static ReturnedUser fromUser(Human human){
            return new ReturnedUser(human.id, human.login);
        }
    }
}
