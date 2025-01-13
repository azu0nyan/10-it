import java.util.ArrayList;
import java.util.Objects;

public class Generics {

    public static void main(String[] args) {
        var al = new ArrayList<Object>();
        al.add(new String("sadsad"));
        al.add(Integer.parseInt("2323"));


        var l = ((String)al.get(0)).length();
        System.out.println(l);
        if(al.get(1) instanceof String) {
            System.out.println(((String) al.get(1)).length());
        }
        System.out.println(((String) al.get(1)).length());
    }

}


