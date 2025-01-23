package model;

public class Anime {
    Data data;

    @Override
    public String toString() {
        return "Anime{" +
                "data=" + data +
                '}';
    }
}

class Data{
    int mal_id;
    String title_japanese;
    String title_english;

    @Override
    public String toString() {
        return "Data{" +
                "mal_id=" + mal_id +
                ", title_japanese='" + title_japanese + '\'' +
                ", title_english='" + title_english + '\'' +
                '}';
    }
}
