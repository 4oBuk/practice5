package com.chornobuk.practice5.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Illustration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JsonView(Views.IllustrationCreate.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", referencedColumnName = "id", updatable = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    private Artist artist;

    @NotBlank
    @JsonView(Views.IllustrationCreate.class)
    private String name;

    @Column(updatable = false)
    private String imageUrl;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @JsonView(Views.IllustrationCreate.class)
    private Boolean aiGenerated;
}
