package com.chornobuk.practice5.dtos.illustration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IllustrationCreateDTO {
    private Long artistId;
    private String name;
    private Boolean aiGenerated;
}
