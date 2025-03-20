package server;

import spark.Request;
import spark.Response;
import spark.Route;

import java.time.Instant;

public class AuthRoute {

    public static Route authRoute(Route route) {
      return authRoute(route, "/error", 403);
    }

    public static Route authRoute(Route route, String redirect, int code) {
        return (request, response) -> {
            var information = validateCookie(request);

            if (information != null) {
                try {
                    return route.handle(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                response.status(code);
                response.redirect(redirect);
                return "";
            }
        };
    }

    public static LoggedInUserInfo validateCookie(Request request) {
        //todo нормальная валидация
        var cookie = request.cookie("username");
        if(cookie != null) return new LoggedInUserInfo(cookie);
        else return null;
    }
}

