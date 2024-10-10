import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        var q = new LinkedList<Integer>();

        int n = Integer.parseInt(s.nextLine());
        for (int i = 0; i < n; i++) {
            String read = s.nextLine();
            String [] splitted = read.split(" ");
            if(splitted[0].equals("pop")){
                System.out.println(q.removeFirst());
            } else if(splitted[0].equals("push")){
                int num = Integer.parseInt(splitted[1]);
                q.addLast(num);
            }
        }
    }
}
