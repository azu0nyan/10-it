package db;

import db.model.Human;

import java.sql.Connection;

public class HumanDAO {
    public static int insertNew(Human human, Connection conn) throws Exception {
        var stmt = conn.prepareStatement("INSERT INTO HUMAN(login, password) VALUES(?, ?);");
        stmt.setString(1, human.login);
        stmt.setString(2, human.password);

        return stmt.executeUpdate();
    }

    public static Human selectByLogin(String login, Connection conn) throws Exception {
        var stmt = conn.prepareStatement("SELECT * FROM HUMAN WHERE login = ?;");
        stmt.setString(1, login);
        var rs = stmt.executeQuery();
        if (rs.next()) {
            var human = new Human(
                    rs.getInt("id"),
                    rs.getString("login"),
                    rs.getString("password")
            );
            return human;
        }
        return null;
    }
}
