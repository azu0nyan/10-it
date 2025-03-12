import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;

public class Main {


    public static void main(String[] args) throws Throwable {

        String schemaSql = Files.readAllLines(Path.of("schema.sql")).stream().reduce((x, y) -> x + y).get();

        System.out.println(schemaSql);

        Connection conn = DriverManager.
                getConnection("jdbc:h2:mem:;NON_KEYWORDS=USER, VALUE");

        Statement stmt = conn.createStatement();
        var result = stmt.executeUpdate(schemaSql);

//        var insert = "INSERT INTO user(login, password) VALUES(?, ?);";
//
//        var insertStmt = conn.prepareStatement(insert);
//        insertStmt.setString(1, "admin");
//        insertStmt.setString(2, "password");

        String sql = "INSERT INTO user(login, password) " + "VALUES ('admin', 'password');";


        var inserted = conn.createStatement().executeUpdate(sql);



        System.out.println("Добавлено " + inserted + " записей");

        var select = "SELECT * FROM user";
        var selectStmt = conn.createStatement();
        var resultSet = selectStmt.executeQuery(select);
        while (resultSet.next()) {
            var id = resultSet.getInt("id");
            var login = resultSet.getString("login");
            var password = resultSet.getString("password");
            System.out.println("id: " + id + ", login: " + login + ", password: " + password);
        }


        conn.close();
    }


//    public static void viewTable(Connection con) throws SQLException {
//        String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";
//        try (Statement stmt = con.createStatement()) {
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                String coffeeName = rs.getString("COF_NAME");
//                int supplierID = rs.getInt("SUP_ID");
//                float price = rs.getFloat("PRICE");
//                int sales = rs.getInt("SALES");
//                int total = rs.getInt("TOTAL");
//                System.out.println(coffeeName + ", " + supplierID + ", " + price +
//                        ", " + sales + ", " + total);
//            }
//        } catch (SQLException e) {
//            JDBCTutorialUtilities.printSQLException(e);
//        }
//    }
}