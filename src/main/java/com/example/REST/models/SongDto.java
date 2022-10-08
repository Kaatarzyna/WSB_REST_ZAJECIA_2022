package com.example.REST.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {

    private String title;
    private String author;
    private Integer year;

}
