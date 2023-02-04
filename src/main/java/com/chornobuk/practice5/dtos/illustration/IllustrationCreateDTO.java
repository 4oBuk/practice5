package com.chornobuk.practice5.dtos.illustration;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IllustrationCreateDTO {
    @NotNull
    private Long artistId;

    @NotBlank
    private String name;

    @NotNull
    private Boolean aiGenerated;
}
