import java.util.Scanner;
import java.util.stream.Stream;

public class Main {


    static int f(int x) {
        return x + x % 13;
    }

    static boolean pred(int x) {
        return x % 2 != 0;
    }


    static void iterate_for(int n, int a) {
        for (int i = 0; i < n; i++) {
            System.out.println(a);
            a = f(a);
        }
    }


    static void iterate(int n, int a) {
        Stream
                .iterate(a, Main::f)
                .limit(n)
                .forEach(x -> System.out.println(x));
    }

    static void iterate_while( int a) {
         int res = Stream
                .iterate(a, Main::f)
                .dropWhile(x -> !pred(x))
                .findFirst().get();
        System.out.println(res);
    }

    static int n = 0;
    static void iterate_while_( int a) {
        n = -1;

        int res = Stream
                .iterate(a, Main::f)
                .dropWhile(x -> {
                    n++;
                    return !pred(x);
                })
                .findFirst().get();
        System.out.println(n);
        System.out.println(res);
    }

    static void iterate_while_while( int a) {
        int n = 0;
        while(!pred(a)){
            n++;
            a = f(a);
        }
        System.out.println(n);
        System.out.println(a);
    }

    static int iterate_read() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        return Stream
                .generate(() -> s.nextInt())
                .limit(n)
                .reduce((a, b) -> a - b - 39).get();
    }


    public static void main(String[] args) {

        iterate_while(2);
        iterate_while_(2);
        iterate_while_while(2);
//        Scanner s = new Scanner(System.in);
//        iterate(s.nextInt(), s.nextInt());

//        System.out.println(iterate_read());


//        System.out.println("Hello world!");
    }
}