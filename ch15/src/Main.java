public class Main {
    public static void main(String[] args) {
        encodingRoutine(new GoodEncoder());
        encodingRoutine(new BadEncoder());
//        encodingRoutine(new HuffmanEncoder());
//        decodingRoutine(new HuffmanDecoder());
    }

    static void encodingRoutine(Encoder encoder){
        var text = encoder.readFileAsText("in.txt");
        var dict = encoder.buildFreqDictionary(text);
        var codeTable = encoder.buildCodeTable(dict);
        var bitString = encoder.encodeAsBitString(codeTable, text);
        var res = encoder.bitStringAsByteArray(bitString);
        encoder.writeCodeToFile("out.bin", res);
        encoder.writeTableToFile("table.txt", codeTable);
    }

    static void decodingRoutine(Decoder decoder) {
        var byteArray = decoder.readEncodedFile("out.bin");
        var table = decoder.readCodeTable("table.txt");
        var bitString = decoder.byteArrayToBitString(byteArray);
        var decodedText = decoder.decode(table, bitString);
        decoder.writeToFile("out.txt", decodedText);
    }
}