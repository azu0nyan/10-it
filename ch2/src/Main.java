public class Main {
    //  13 -> 5+5+1+1+1
    /// len   1 2 3 4  5
    /// price 2 3 3 4 10
    static int prices[] = {0, 2, 3, 3, 4, 10};
    public static void main(String[] args) {
        int n = 13;
        int [] table = new int[n + 1];
        System.out.println(f(n, table));
        System.out.println(f_no_rec(n));
    }

    static int f(int n, int [] table) {
        if(n == 0) return prices[0];
        if(n == 1) return prices[1];

        if(table[n] != 0) return table[n];

        int maxPrice = 0;
        for (int i = 1; i < n; i++) {
            int len1 = i;
            int len2 = n - i;
            int price = f(len1, table) + f(len2, table);
            maxPrice = Math.max(price, maxPrice);
        }
        if(n < prices.length){
            //большее из продать нарезав или целиком
            maxPrice = Math.max(maxPrice, prices[n]);
        }

        table[n] = maxPrice;

        return maxPrice;
    }

    static int f_no_rec(int n) {
        int [] table = new int[n + 1];

        table[0] =  prices[0];
        table[1] = prices[1];

        for (int l = 2; l < n + 1; l++) {
            int maxPrice = 0;
            for (int i = 1; i < l; i++) {
                int len1 = i;
                int len2 = l - i;
                int price = table[len1] + table[len2];
                maxPrice = Math.max(price, maxPrice);
            }
            if (l < prices.length) {
                //большее из продать нарезав или целиком
                maxPrice = Math.max(maxPrice, prices[l]);
            }

            table[l] = maxPrice;
        }
        return table[n];
    }

    //Базовый пример числа фибоначчи
    int f(int n){
        if(n == 0) return 1;
        if(n == 1) return 1;
        return f(n - 1) + f(n -2) ;
    }
}