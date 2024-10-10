import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    //Main.q = 2
    public static int q = 2;
    public static void main(String[] args) throws Throwable {
        Scanner sf = new Scanner(new File("asd.txt"));
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();


        int a = 3, b = 3, c = 3;
        if (a == b && b != c) System.out.println("YES");
        if (a == c && a != b) System.out.println("YES");
        if (b == c && a != b) System.out.println("YES");

        int x[] = {1, 3, 4};
        int y[] = new int[2];

        boolean all = true;
        for (int i = 1; i < x.length; i++) {
            if (x[i] - x[i - 1] == 2 || x[i] - x[i - 1] == -2) {
                all = false;
            }
        }
        if (all) System.out.println("YES");


        //int -> Integer
        var al = new ArrayList<Integer>();
//        al.add(1);
//        al.indexOf(1);
//        al.contains(2);
//        al.clear();
//        al.get(0);
//        al.remove(1);

        var hm = new HashMap<String, Integer>();
        String[] words = {"one", "one", "two", "cat", "cat", "cat"};

        for (String word : words) {
            if (hm.containsKey(word)) hm.put(word, hm.get(word) + 1);
            else hm.put(word, 1);
        }


        System.out.println(
                hm.entrySet()
                        .stream()
                        .sorted(Comparator.comparing(s -> s.getValue()))
                        .collect(Collectors.toUnmodifiableList()));
        System.out.println(hm);


        Class w = new Class();
        w.str = "aaa";
        int z = w.sum();
    }
}

class Class{
    int x;
    int y;
    String str;

    int sum(){
        return x + y;
    }

}