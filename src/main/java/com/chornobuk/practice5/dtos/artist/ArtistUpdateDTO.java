package com.chornobuk.practice5.dtos.artist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArtistUpdateDTO {
    // TODO: how to make id unupdatable
    private Long id;
    private String email;
    private String password;
    private String nickname;
}
