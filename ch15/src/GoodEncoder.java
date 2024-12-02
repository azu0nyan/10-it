import java.util.Map;

public class GoodEncoder implements Encoder {
    @Override
    public String readFileAsText(String filename) {
        return "";
    }

    @Override
    public Map<Character, Integer> buildFreqDictionary(String text) {
        return Map.of();
    }

    @Override
    public Map<Character, String> buildCodeTable(Map<Character, Integer> freqDictionary) {
        return Map.of();
    }

    @Override
    public String encodeAsBitString(Map<Character, String> codeTable, String text) {
        return "";
    }

    @Override
    public byte[] bitStringAsByteArray(String bitString) {
        return new byte[0];
    }

    @Override
    public void writeCodeToFile(String filename, byte[] data) {

    }

    @Override
    public void writeTableToFile(String filename, Map<Character, String> table) {

    }
}
