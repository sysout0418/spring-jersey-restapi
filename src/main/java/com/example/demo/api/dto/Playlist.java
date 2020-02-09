package com.example.demo.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Playlist {

    private long playlistId;
    private long userId;
    private String playlistName;
    private List<Song> songs;

}
