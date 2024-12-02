import java.util.Map;

public interface Decoder {
    byte [] readEncodedFile(String filename);

    Map<String, Character> readCodeTable(String filename);

    String byteArrayToBitString(byte [] encoded);

    String decode(Map<String, Character> freqDictionary, String bitString);

    void writeToFile(String filename, String data);

}
