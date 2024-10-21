import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Main {
    /*
    id - уникальный
    style - меняем внешний вид
    class - тип внешнего вида


    <тэг атрибут1="значение аттрибута 1" >
      дети
    </тег>

    <тэг/>
*/
    public static void main(String[] args) throws IOException {
        Document doc2 = Jsoup.connect("https://www.avito.ru/sankt-peterburg/vakansii/tag/voditel-gazeli").get();
        System.out.println(doc2.title());
        System.out.println(doc2.body());

        Document doc = Jsoup.connect("https://stackoverflow.com/questions?tab=Bounties").get();
        System.out.println(doc.title());

        var questions = doc.body().getElementById("questions");

        for (Element child : questions.children()) {
            var votes = child
                    .getElementsByClass("s-post-summary--stats-item-number")
                    .first()
                    .text();

            var bounty = child
                    .getElementsByClass("has-bounty")
                    .first()
                    .text();

            var title = child
                    .getElementsByClass("s-post-summary--content-title")
                    .first()
                    .text();
            System.out.println(title + " " + votes + " " + bounty);
        }

    }


    public static void mainn(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://stackoverflow.com/questions?sort=MostFrequent&edited=true").get();

        System.out.println(doc.title());

        var qs = doc.body().getElementById("questions");

//        System.out.println(qs);

        for (Element child : qs.children()) {
            var n = child.getElementsByClass("s-post-summary--stats-item-number").first();

            System.out.println(n.text());

            var t = child.getElementsByClass("s-post-summary--content-title").first();

            System.out.println(t.text());
        }
    }
}