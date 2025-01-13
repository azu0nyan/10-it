public class Main {
    /*
    S -> C | E
    C -> 0 | N
    N0 -> 1 | 2 | .. | 9
    N1 -> eps | 0 | 1 .. | 9 | N1N1
    N -> NON1
    E -> (S+S) | (S*S) | (S-S)
     */
    public static void main(String[] args) {
        new Mull(
                new Plus(new Number(2), new Number(4)),
                 new Sub(new Number(3), new Number(5))
        ); //((2+4)*(3-5))

        Expression result = parse("((2+4)*(3-5))");
        System.out.println(result);
        System.out.println(result.calc());
    }

    static int i = 0;

    static Expression parse(String s) {
            if(Character.isDigit(s.charAt(i)))
                return  parseNumber(s);
             else
                return parseBrackets(s);

    }

    static Expression parseBrackets(String s) {
        i++;
        var e1 = parse(s);
        var op = s.charAt(i);
        i++;
        var e2 = parse(s);
        i++;

        switch (op){
            case '+': return new Plus(e1, e2);
            case '-': return new Sub(e1, e2);
            case '*': return new Mull(e1, e2);
        }
        return null;
    }

    static Number parseNumber(String s) {
        int end = i;
        while (end  < s.length() && Character.isDigit(s.charAt(end)))
            end++;

        int res = Integer.parseInt(s.substring(i, end));
        i = end;
        return new Number(res);
    }
}


interface Expression{
    int calc();
}

class Number implements Expression{
        int n;

    public Number(int n) {
        this.n = n;
    }

    public int calc() {
        return n;
    }

    public String toString() {
        return "Number{" +
                "n=" + n +
                '}';
    }
}

class Plus implements Expression{
    Expression e1;
    Expression e2;

    public Plus(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public int calc() {
        return e1.calc() + e2.calc();
    }

    public String toString() {
        return "Plus{" +
                "e1=" + e1 +
                ", e2=" + e2 +
                '}';
    }
}
class Sub implements Expression{
    Expression e1;
    Expression e2;

    public Sub(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public int calc() {
        return e1.calc() - e2.calc();
    }

    public String toString() {
        return "Sub{" +
                "e1=" + e1 +
                ", e2=" + e2 +
                '}';
    }
}
class Mull implements Expression{
    Expression e1;
    Expression e2;

    public Mull(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public int calc() {
        return e1.calc() * e2.calc();
    }

    public String toString() {
        return "Mull{" +
                "e1=" + e1 +
                ", e2=" + e2 +
                '}';
    }
}
