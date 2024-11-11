public class Main {
    public static void main(String[] args) {
        int xb = 0b11111111;
        int zx = 0xff2;


        int x = 2;
        int y = 3;
        System.out.println(x | y);
        System.out.println(x & y);
        System.out.println(x ^ y);
        System.out.println(~x);
        System.out.println(~y);

        System.out.println(8 >> 2);
    }

    static boolean getBit(int x, int i) {
        return ((x >> i) & 1) == 1;
    }

    static int setBit(int x, int i) {
        return  x | (1<<i);
    }

}