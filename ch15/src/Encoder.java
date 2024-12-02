import java.util.Map;

public interface Encoder {
    String readFileAsText(String filename);

    Map<Character, Integer> buildFreqDictionary(String text);

    Map<Character, String> buildCodeTable(Map<Character, Integer> freqDictionary);
    // private T buildTreeFromFreqDictionary(Map<Character, Integer> freqDictionary)
    // private Map<Character, String> buildCodeTableFromTree(T t)

    String encodeAsBitString(Map<Character, String> codeTable, String text);

    byte [] bitStringAsByteArray(String bitString);

    void writeCodeToFile(String filename, byte [] data);

    void writeTableToFile(String filename, Map<Character, String> table);


}
