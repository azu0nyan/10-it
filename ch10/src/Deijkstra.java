import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Deijkstra {
    static ArrayList<String> getLinks(String link) throws IOException {
        System.out.println("Скачиваю: " + link);
        Document doc = Jsoup.connect("https://wikipedia.org/wiki" + link).get();
        var elems = doc.body().getElementsByAttribute("href");
        ArrayList<String> res = new ArrayList<>();
        for (Element elem : elems) {
            res.add(elem.attr("href"));
        }

        return res;

    }

    public static void main(String[] args) throws IOException {
        var start = "/wolf";
        var end = "/sheep";

        LinkedList<String> queue = new LinkedList<>();
        queue.addLast(start);

        HashSet<String> added = new HashSet<>();
        added.add(start);

        HashMap<String, String> cameFrom = new HashMap<>();

        HashMap<String, Integer> len = new HashMap<>();
        len.put(start, 0);

        while (!queue.isEmpty()) {
            var cur = queue.removeFirst();
            var curLen = len.get(cur);

            var neighbours = getLinks(cur);

            if(neighbours.contains(end)) {
                var tmp = end;
                System.out.println("Путь найден");
                while (!tmp.equals(start)){
                    System.out.println(tmp);
                    tmp = cameFrom.get(tmp);
                }
                System.out.println(start);

                break;
            } else {
                if(curLen > 5){
                    System.out.println("Длинна пути превышена");
                    break;
                }

                for (String neighbour : neighbours) {
                    if(!added.contains(neighbour)) {
                        queue.add(neighbour);
                        added.add(neighbour);
                        cameFrom.put(cur, neighbour);
                        len.put(neighbour, curLen + 1);
                    }
                }
            }


        }


    }

}