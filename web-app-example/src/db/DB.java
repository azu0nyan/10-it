package db;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {

    public static void init() throws Exception {
        Connection conn = getConnection();
        init(conn);
        conn.close();
    }
    public static void init(Connection conn) throws Exception {
        String schemaSql = Files.readAllLines(Path.of("schema.sql")).stream().reduce((x, y) -> x + y).get();

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(schemaSql);

    }

    public static Connection getConnection() throws Exception {

        Connection conn = DriverManager.
                getConnection("jdbc:h2:./test");

        return conn;
    }
}
