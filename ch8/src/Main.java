import java.util.Stack;

public class Main {
    static class Tree{
        int value;
        Tree left;
        Tree right;

        public Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static int count(Tree t) {
        if(t == null) return 0;
        return 1 + count(t.left) + count(t.right);
    }

    static int cont_no_rec(Tree t) {
        Stack<Tree> toWalk = new Stack<>();
        toWalk.push(t);
        int count = 0;
        while (!toWalk.empty()){
            Tree cur = toWalk.pop();
            count++;
            if(cur.left != null) toWalk.push(cur.left);
            if(cur.right != null) toWalk.push(cur.right);
        }
        return count;
    }

    public static void main(String[] args) {
        Tree t = new Tree(2, null, null);
        Tree tmp = t;
        for (int i = 0; i < 100_000; i++) {
            tmp.left = new Tree(1, null, null);
            tmp = tmp.left;
        }
        System.out.println(cont_no_rec(t));
    }
}