import java.util.Map;

public class GoodEncoder implements Encoder{

    public String readFileAsText(String filename) {
        return "";
    }

    public Map<Character, Integer> buildFreqDictionary(String text) {
        return Map.of();
    }

    public Map<Character, String> buildCodeTable(Map<Character, Integer> freqDictionary) {
        return Map.of();
    }

    public String encodeAsBitString(Map<Character, String> codeTable, String text) {
        return "";
    }

    public byte[] bitStringAsByteArray(String bitString) {
        return new byte[0];
    }

    public void writeCodeToFile(String filename, byte[] data) {

    }


    public void writeTableToFile(String filename, Map<Character, String> table) {

    }
}

