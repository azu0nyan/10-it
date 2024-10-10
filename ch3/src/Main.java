import java.util.Scanner;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

// +2 +3
public class Main {

    static int f(int i){
        return 32 * i;
    }

    static int sum_f(int l, int n){
        int acc = 0;
        for (int i = l; i <= n ; i++)
            acc += f(i);

        return acc;
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int i = s.nextInt();
        System.out.println(sum_f(1, i));

        IntStream.of(2).map(k ->{
            var q = k + k;
            return q;
        });


    }

}