package com.chornobuk.practice5.data;

import java.time.LocalDateTime;
import java.util.List;

import com.chornobuk.practice5.entities.Artist;
import com.chornobuk.practice5.entities.Illustration;

public class Illustrations {

    public static List<Illustration> getSecondPageAiGenerated() {
        Artist artist = Artists.getById(11L);
        LocalDateTime dateTime = LocalDateTime.of(2023, 1, 1, 11, 1, 0);
        return List.of(
                new Illustration(201L, artist, "illustration11.12", "url", dateTime, true),
                new Illustration(202L, artist, "illustration11.13", "url", dateTime, true),
                new Illustration(203L, artist, "illustration11.14", "url", dateTime, true),
                new Illustration(204L, artist, "illustration11.15", "url", dateTime, true),
                new Illustration(205L, artist, "illustration11.16", "url", dateTime, true),
                new Illustration(206L, artist, "illustration11.17", "url", dateTime, true),
                new Illustration(207L, artist, "illustration11.18", "url", dateTime, true),
                new Illustration(208L, artist, "illustration11.19", "url", dateTime, true),
                new Illustration(209L, artist, "illustration11.20", "url", dateTime, true)
        );
    }

    public static List<Illustration> getThirdUserSecondPageIllustrations() {
        Artist artist = Artists.getById(23L);
        LocalDateTime dateTime = LocalDateTime.of(2023, 1, 1, 11, 1, 0);
        return List.of(
                new Illustration(429L, artist, "illustration23.12", "url", dateTime, false),
                new Illustration(430L, artist, "illustration23.13", "url", dateTime, false),
                new Illustration(431L, artist, "illustration23.14", "url", dateTime, false),
                new Illustration(432L, artist, "illustration23.15", "url", dateTime, false),
                new Illustration(433L, artist, "illustration23.16", "url", dateTime, false),
                new Illustration(434L, artist, "illustration23.17", "url", dateTime, false),
                new Illustration(435L, artist, "illustration23.18", "url", dateTime, false),
                new Illustration(436L, artist, "illustration23.19", "url", dateTime, false),
                new Illustration(437L, artist, "illustration23.20", "url", dateTime, false)
                );
    }
}
