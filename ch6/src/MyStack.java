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
