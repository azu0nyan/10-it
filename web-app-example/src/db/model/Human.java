package db.model;

public class Human {
    public int id = -1;
    public String login;
    public String password;

    public Human(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Human(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }
}
