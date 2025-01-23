package model;

import java.util.Arrays;
import java.util.List;

public class Character {
    public Data data;

    @Override
    public String toString() {
        return "Character{" +
                "data=" + data +
                '}';
    }


    public static class Data {
        public int mal_id;
        public String name;
        public String name_kanji;
        public AnimeInner [] anime;


        @Override
        public String toString() {
            return "Data{" +
                    "mal_id=" + mal_id +
                    ", name='" + name + '\'' +
                    ", name_kanji='" + name_kanji + '\'' +
                    ", anime=" + Arrays.toString(anime) +
                    '}';
        }

        public static class AnimeInner{
            public String role;
            public AnimeInnerInner anime;
//
            @Override
            public String toString() {
                return "AnimeInner{" +
                        "role='" + role + '\'' +
                        ", anime=" + anime +
                        '}';
            }

            public static class AnimeInnerInner{
                public int mal_id;
                public String url;
                public String title;

                @Override
                public String toString() {
                    return "AnimeInnerInner{" +
                            "mal_id=" + mal_id +
                            ", url='" + url + '\'' +
                            ", title='" + title + '\'' +
                            '}';
                }
            }
        }
    }
}


