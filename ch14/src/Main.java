import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        HashMap<Character, Integer> freq = new HashMap<>();
        freq.put('a', 22);

        for (Character c : freq.keySet()) {
            System.out.println(c + "->" + freq.get(c));
        }

        for (Map.Entry<Character, Integer> kv : freq.entrySet()) {
            System.out.println(kv.getKey() + "->" + kv.getValue());
        }

        PriorityQueue<T> pq = new PriorityQueue<T>(Comparator.comparingInt(t -> t.w));
//        PriorityQueue<T> pq2 = new PriorityQueue<T>((t1, t2)-> t1.w - t2.w);

        pq.add(new T('a', 22));
        pq.add(new T('b', 24));
        pq.add(new T('c', 4));

        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
}

class T{
    T left = null;
    T right = null;
    Character c = null;
    int w;

    public T(Character c, int w) {
        this.c = c;
        this.w = w;
    }

    public T(int w, T right, T left) {
        this.w = w;
        this.right = right;
        this.left = left;
    }

    @Override
    public String toString() {
        return "T{" +
                "left=" + left +
                ", right=" + right +
                ", c=" + c +
                ", w=" + w +
                '}';
    }
}