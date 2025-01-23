package model;

import java.util.Arrays;
import java.util.List;

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
        AnimeInner [] anime;


        @Override
        public String toString() {
            return "Data{" +
                    "mal_id=" + mal_id +
                    ", name='" + name + '\'' +
                    ", name_kanji='" + name_kanji + '\'' +
                    ", anime=" + Arrays.toString(anime) +
                    '}';
        }

        static class AnimeInner{
            String role;
            AnimeInnerInner anime;
//
            @Override
            public String toString() {
                return "AnimeInner{" +
                        "role='" + role + '\'' +
                        ", anime=" + anime +
                        '}';
            }

            static class AnimeInnerInner{
                int mal_id;
                String url;
                String title;

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


