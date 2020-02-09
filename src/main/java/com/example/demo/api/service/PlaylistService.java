package com.example.demo.api.service;

import com.example.demo.api.dto.Playlist;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PlaylistService {

    // create playlist
    Playlist initDataCreatePlaylist(Map<String, Object> reqParam);
    void insertPlaylist(Playlist playlist);

    // add playlist
    Playlist initDataAddSong(Map<String, Object> reqParam);
    void checkValidationAddSong(Map<String, Object> reqParam);
    void insertPlaylistSong(Playlist playlist);

    // search playlist by user_id
    List<Playlist> getUserPlaylist(long userId);

    // delete playlist by user_id and playlist_id
    void deletePlaylist(long userId, long playlistId);

}
