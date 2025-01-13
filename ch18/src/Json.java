import java.util.ArrayList;

public class Json {
//    Double, String, Boolean, (Object)null, Map<String, Object>, ArrayList<Object>

    static int i = 0;
    Object parseJson(String s) {
        skipWhitespaces();
        i++;
        if(s.charAt(i) == '{') {
            parseMap(s);
        } else if(s.charAt(i) == '[') {
            parseArray(s);
        } else if(Character.isDigit(s.charAt(i)) || s.charAt(i) == '-'){
            parseNumber(s);
        } else if(s.charAt(i) == 't') {
            parseTrue(s);
        } else if(s.charAt(i) == 'f') {
            parseFalse(s);
        } else if(s.charAt(i) == 'n') {
            parseNull(s);
        } else {
            throw new RuntimeException("Unknown token");
        }
    }


    static Object parseNull(String s) {
        i += 4;
        if(s.substring(i, i + 4).equals("null")){
            i += 4;
            return null;
        } else
            throw new RuntimeException("Not null in place of null");
    }


}
