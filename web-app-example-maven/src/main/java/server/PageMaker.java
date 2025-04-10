package server;

import spark.Request;
import spark.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PageMaker {
    static String template;
    static String anonMenu;
    static String userMenu;
    static String loginForm;
    static String registrationForm;
    static String mainPageContent;
    static String hiddenPageContent;
    static String searchUsersContent;


    static {
        try {
            template = Files.readAllLines(Path.of("html/template.html")).stream().reduce((x, y) -> x + y).get();
            anonMenu = Files.readAllLines(Path.of("html/anonMenu.html")).stream().reduce((x, y) -> x + y).get();
            userMenu = Files.readAllLines(Path.of("html/userMenu.html")).stream().reduce((x, y) -> x + y).get();
            loginForm = Files.readAllLines(Path.of("html/loginForm.html")).stream().reduce((x, y) -> x + y).get();
            registrationForm = Files.readAllLines(Path.of("html/registrationForm.html")).stream().reduce((x, y) -> x + y).get();
            mainPageContent = Files.readAllLines(Path.of("html/mainContent.html")).stream().reduce((x, y) -> x + y).get();
            hiddenPageContent = Files.readAllLines(Path.of("html/hiddenPage.html")).stream().reduce((x, y) -> x + y).get();
            searchUsersContent = Files.readAllLines(Path.of("html/searchUsers.html")).stream().reduce((x, y) -> x + y).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String makeMainPage(Request request, Response response) {
        return makePage(mainPageContent, anonMenu);
    }

    public static String makeMainPageForUser(Request request, Response response) {
        return makePage(mainPageContent, userMenu);
    }

    public static String makeRegistrationPage(Request request, Response response) {
        return makePage(registrationForm, anonMenu);
    }

    public static String makeLoginPage(Request request, Response response) {
        return makePage(loginForm, anonMenu);
    }

    public static String makeHiddenPage(Request request, Response response) {
        return makePage(hiddenPageContent, userMenu);
    }

    public static String makeSearchUsersPage(Request request, Response response) {
        return makePage(searchUsersContent, userMenu);
    }


    public static String makePage(String content, String menu) {
        return template
                .replace("{{content}}", content)
                .replace("{{menu}}", menu);
    }
}
