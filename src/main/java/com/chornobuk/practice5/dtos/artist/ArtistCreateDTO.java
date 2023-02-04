package com.chornobuk.practice5.dtos.artist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArtistCreateDTO {
    private String email;

    private String password;

    private String nickaname;
}
