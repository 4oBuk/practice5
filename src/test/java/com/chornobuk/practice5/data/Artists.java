package com.chornobuk.practice5.data;

import com.chornobuk.practice5.entities.Artist;

import java.time.LocalDateTime;
import java.util.List;

public class Artists {

    public static List<Artist> getAllArtists() {
        return List.of(
                new Artist(1L, "artist1@art.com", "artist1", "artist1", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(2L, "artist2@art.com", "artist2", "artist2", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(3L, "artist3@art.com", "artist3", "artist3", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(4L, "artist4@art.com", "artist4", "artist4", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(5L, "artist5@art.com", "artist5", "artist5", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(6L, "artist6@art.com", "artist6", "artist6", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(7L, "artist7@art.com", "artist7", "artist7", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(8L, "artist8@art.com", "artist8", "artist8", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(9L, "artist9@art.com", "artist9", "artist9", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(10L, "artist10@art.com", "artist10", "artist10", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(11L, "artist11@art.com", "artist11", "artist11", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(12L, "artist12@art.com", "artist12", "artist12", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(13L, "artist13@art.com", "artist13", "artist13", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(14L, "artist14@art.com", "artist14", "artist14", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(15L, "artist15@art.com", "artist15", "artist15", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(16L, "artist16@art.com", "artist16", "artist16", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(17L, "artist17@art.com", "artist17", "artist17", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(18L, "artist18@art.com", "artist18", "artist18", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(19L, "artist19@art.com", "artist19", "artist19", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(20L, "artist20@art.com", "artist20", "artist20", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(21L, "artist21@art.com", "artist21", "artist21", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(22L, "artist22@art.com", "artist22", "artist22", LocalDateTime.of(2023, 1, 1, 11, 0)),
                new Artist(23L, "artist23@art.com", "artist23", "artist23", LocalDateTime.of(2023, 1, 1, 11, 0))
        );
    }
}
