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
    // todo add validation to all dtos
    private String email;

    private String password;

    private String nickaname;
}
