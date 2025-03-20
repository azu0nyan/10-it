package server;

import java.time.Instant;

public class LoggedInUserInfo{
    Instant validBefore;
    String username;

    public LoggedInUserInfo(String username) {
        this.username = username;
    }
}