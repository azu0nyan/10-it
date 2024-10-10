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
