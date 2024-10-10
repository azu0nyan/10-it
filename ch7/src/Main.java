public class Main {


    static class List {
        int value;
        List next;

        public List(int value, List next) {
            this.value = value;
            this.next = next;
        }
    }


    static List reverse(List l) {
        return null;
    }


    static void print(List l) {
        List tmp = l;
        while (tmp != null) {
            if (tmp.next == null) System.out.print(tmp.value);
            else System.out.print(tmp.value + "->");
            tmp = tmp.next;
        }
    }

    static void print_rec(List l) {
        if (l == null) return;
        if (l.next == null) {
            System.out.print(l.value);
        } else {
            System.out.print(l.value + "->");
            print_rec(l.next);
        }

    }


    static List remove_pre_last(List l) {
        List tmp = l;
        while (tmp.next.next.next != null) {
            tmp = tmp.next;
        }

        tmp.next = tmp.next.next;
        return l;
    }

    static List remove_pre_last_rec(List l) {
        if (l.next.next.next == null) return new List(l.value, l.next.next);
        else return new List(l.value, remove_pre_last_rec(l.next));
    }

    public static void main(String[] args) {

        List l = new List(5, new List(2, new List(3, null)));
        reverse(l);
        print(l);
        System.out.println();
        l = remove_pre_last_rec(l);
        print_rec(l);
        l.value = 1;
//        System.out.println("Hello world!");
    }
}

