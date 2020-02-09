package com.example.demo.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Album {

    private String title;
    private long id;
    private List<Song> songs;

}
