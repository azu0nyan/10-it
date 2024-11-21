import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class FileOps {
    /**
     *Чтение/запись в файл.
     *
     * Во всех примерах можно указать ОТНОСИТЕЛЬНЫЙ и АБСОЛЮТНЫЙ путь к файлам
     *
     * Абсолютный путь это полный путь к файлу из корня файловой системы например.
     * windows: C:\some\folder\file.txt
     *
     * unix: /home/user/folder/file.txt
     *
     * Относительный это путь оносительно рабочей папки(WORKING DIRECTORY) -
     * папки откуда запускается программа.
     *
     * В IDEA, по умолчанию, это папка вашего проекта(смотрите на панель файлов проекта слева).
     *
     * Во всех примерах используются относительный пути.
     *
     * Запустите программу и убедитесь что все файлы из кода создалисб(смотрите на панель файлов проекта слева)
     */
    public static void main(String[] args) throws IOException {
        writeFilePrintWriter();

        readFileScanner();

        helpfullyFunctions();
    }

    /**
     * Простой способ читаем из файла так же как и из консоли
     * */
    static void readFileScanner() throws FileNotFoundException {
        System.out.println("Читаем файл:");
        Scanner s = new Scanner(new File("some.txt"));
        while (s.hasNext()){ // у файла есть "конец" и проверка на то что он закончился, в отличие от консоли
            System.out.println(s.nextLine());//тут доступно все тоже что и в консоли nextInt, nextDouble ...
        }
        s.close();//По хорошему файлы нужно "закрывать" иначе могут быть проблемы при
        //обращении к одному файлу из нескольких программ
    }

    /*Записываем в данные, как в консоль*/
    static void writeFilePrintWriter() throws FileNotFoundException {
        System.out.println("Пишем в файл");
        PrintWriter pw = new PrintWriter(new File("some.txt"));
        //вместо System.out.println используем pw.println
        pw.println("Some text to file");
        pw.close();
    }

    /**Так же есть полезные фунеции чтобы читать/писать в файл массивы байт/строк в одну стройчку*/
    static void helpfullyFunctions() throws IOException {
        //запись строки в файл
        Files.writeString(Path.of("some2.txt"), "some\nsome2");
        //чтение массива строк
        var lines = Files.readAllLines(Path.of("some2.txt"));
        System.out.println(lines);

        //!!!!!!!!!!!!!!!Пригодится для записи/чтения закодированных данных в файл

        Files.write(Path.of("bytes.bin"),new byte[]{ 2, -2, 127});

        var bytes = Files.readAllBytes(Path.of("bytes.bin"));
        System.out.println(Arrays.toString(bytes));
    }


    static void unused() throws FileNotFoundException {
        /***
         * Возникает пробелема того что весь файл может не влезть в память.
         * В таких случаях используется потоковая обработка через классы File[Input|Output]Stream
         *
         * Но мы ей, в ближайшее время заниматься не будем, так что примера неб будет.
         */
        new FileInputStream("some.txt");
        new FileOutputStream("some.txt");
    }

}