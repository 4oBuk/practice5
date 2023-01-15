package com.chornobuk.practice5.data;

import com.chornobuk.practice5.entities.Artist;

import java.time.LocalDateTime;
import java.util.List;

public class Artists {

    public static List<Artist> ARTISTS;

    // ! passwords are null because in API they are write only 
    static {
        ARTISTS = List.of(
                new Artist(1L, "artist1@art.com", null, "artist1", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(2L, "artist2@art.com", null, "artist2", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(3L, "artist3@art.com", null, "artist3", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(4L, "artist4@art.com", null, "artist4", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(5L, "artist5@art.com", null, "artist5", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(6L, "artist6@art.com", null, "artist6", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(7L, "artist7@art.com", null, "artist7", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(8L, "artist8@art.com", null, "artist8", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(9L, "artist9@art.com", null, "artist9", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(10L, "artist10@art.com", null, "artist10", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(11L, "artist11@art.com", null, "artist11", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(12L, "artist12@art.com", null, "artist12", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(13L, "artist13@art.com", null, "artist13", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(14L, "artist14@art.com", null, "artist14", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(15L, "artist15@art.com", null, "artist15", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(16L, "artist16@art.com", null, "artist16", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(17L, "artist17@art.com", null, "artist17", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(18L, "artist18@art.com", null, "artist18", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(19L, "artist19@art.com", null, "artist19", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(20L, "artist20@art.com", null, "artist20", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(21L, "artist21@art.com", null, "artist21", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(22L, "artist22@art.com", null, "artist22", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(23L, "artist23@art.com", null, "artist23", LocalDateTime.of(2023, 1, 1, 11, 0)));
    }

    public static Artist getById(Long id) {
        return ARTISTS.stream().filter(a -> a.getId().equals(id)).findAny().get();
    }
}
