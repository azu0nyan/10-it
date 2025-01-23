package model;

public class Character {
    Data data;

    @Override
    public String toString() {
        return "Character{" +
                "data=" + data +
                '}';
    }


    static class Data {
        int mal_id;
        String name;
        String name_kanji;

        @Override
        public String toString() {
            return "Data{" +
                    "mal_id=" + mal_id +
                    ", name='" + name + '\'' +
                    ", name_kanji='" + name_kanji + '\'' +
                    '}';
        }
    }
}


