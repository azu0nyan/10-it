public class Coding {
    /**
     * То что уже должно быть сделано или доделано, задание ниже.
     *
     *
     * Кодирование.
     * Дана кодовая таблица, например
     * A -> 10
     * B -> 11
     * C -> 0110
     * D -> 000
     * Дано сообщение например "ABBCDD"
     * Заводим пустую строку для ответа.
     * Запускаем цикл по символам сообщения и добавляем к строке ответа соответсвующие символам строки коды.
     * Получаем "10111101 10000000"
     * Полученную строку нарезаем на группы по 8 символов, каждую группу конвертирум в соответсвующий байт.
     * Получаем массив байт [189, 1]
     * <p>
     * Раскодирование.
     * Дана кодовая таблица, например
     * 10 -> A
     * 11 -> B
     * 0110 -> C
     * 000 -> D
     * Дан массив байт наример [189, 1]
     * По массиву байт строим код, как строку - "10111101 10000000"
     * Запускаем цикл по символам строки строке.
     * В цикле пытаемся найти префикс являющийся кодовым словом.
     * Если префикс найден отрезаем его, и добавляем соответсвующий символ к ответу.
     * Получаем ответ "ABBCDD"
     * <p>
     * s.substing(откуда, до куда не включительно)
     */


    /*
    Задание:
    0) Запустить FileOps и проверить что все файлы "bytes.bin" "some.txt" "some2.txt" создались.
    1) Дан файл c текстом, составить "Частотный словарь" - таблицу(Map) сколько раз какой символ встречается в тексте.
    Например для текста "AABCCC" ответом должен быть
    Map(
     'A' -> 2,
     'B' -> 1,
     'C' -> 3,
     )
     2)Доработать вашу программу про кодирование, чтобы она читала данные для кодирования из тектового файла,
     и записывала код в бинарный. (см FileOps.helpfullyFunctions)
     3)Доработать вашу программу про кодирование, чтобы она читала код из бинарного файла,
     и записывал раскодированный тескст в текстовый.
     4)Разобраться со случаями кода длинный не кратной 8(с лишними нулями)
     путем добавления в первые байты закодированного файла, длинны кода.
     Можно, например, в первые 4 байта записать int - кол-во символов в коде(как в задании ip-адрес)
     */

    /*Как построить Частотный словарь в виде массива*/
    static int [] buildTable(String s) {
        int [] freqDict  = new int[Character.MAX_VALUE];
        for(char c : s.toCharArray()){
            freqDict[c]++; //ДА, символы можно исппользовать как индексы т.к. char это число от 0 до 65535
        }
        //к сожалению в массиве будет много 0, что нам неудобно, поэтому вам нужно сделать Map как в задании выше
        return freqDict;
    }


    static boolean getBit(int x, int i) {
        return ((x >> i) & 1) == 1;
    }

    static int setBit(int x, int i) {
        return x | (1 << i);
    }


}
