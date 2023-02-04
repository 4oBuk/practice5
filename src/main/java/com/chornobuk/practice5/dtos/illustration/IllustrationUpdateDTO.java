package com.chornobuk.practice5.dtos.illustration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IllustrationUpdateDTO {
    // TODO how to make id unupdatable
    private Long id;
    private String name;
    private Boolean aiGenerated;
}
