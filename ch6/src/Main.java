////PART 1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int x = 2;

    public static void main(String[] args) {
        x = 4;
//        Main.x;
        System.out.println("Hello world!");
        //создать новый экземпляр класса А(выделить под него память и инициализировать)
        A a = new A();
        System.out.println(a.y);
        a.y = 3;
        A a3 = a;

        System.out.println(a.y);
        System.out.println(a3.y);


        A a2 = new A();
        a2.y = 5;
        int z = a2.f();

        System.out.println(a.y);
        System.out.println(a2.y);




    }

}


class A {

    int x = 1;
    int y = 2;
    int f(){
        return y * y;
    }
}


///PART 2

public class Counter {

    int c = 0;

    void inc(){
        c++;
    }
    void dec(){
        c--;
    }

    int get(){
        return c;
    }

    void set(int toSet){
        c = toSet;
    }
}

///PART 3

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        c1.inc();
        c1.inc();
        c1.inc();
        c1.inc();
        c1.inc();
        System.out.println(c1.get());


        Stack<Integer> st = new Stack<>();
        st.pop();

        ArrayList<Integer> queue = new ArrayList<>();
        queue.addLast(2);//push
        int aa = queue.removeFirst();//pop
        int bb = queue.getFirst();//peek


        //reading
        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());
        for (int i = 0; i < n; i++) {
            String read = s.nextLine();
            String [] splitted = read.split(" ");
            if(splitted[0].equals("pop")){

            } else if(splitted[0].equals("push")){
                int num = Integer.parseInt(splitted[1]);

            }
        }


        int n2 = s.nextInt();
        for (int i = 0; i < n2; i++) {
            String read = s.next();
            if(read.equals("pop")){

            } else if(read.equals("push")){
                int num = s.nextInt();

            }
        }
    }
}

///PART 4

import java.util.Arrays;

public class MyStack {
    int filled = 0;
    int [] stack = new int[10];
    void push(int x){
        if(stack.length >= filled){
            stack = Arrays.copyOf(stack, stack.length * 2);
        }
        stack[filled] = x;
        filled++;
    }

    int pop(){
        filled--;
        return stack[filled];
    }

    int peek(){
        return stack[filled - 1];
    }
}
