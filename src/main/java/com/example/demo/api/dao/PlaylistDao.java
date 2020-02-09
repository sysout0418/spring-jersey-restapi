package com.example.demo.api.dao;

import com.example.demo.api.dto.Playlist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PlaylistDao {

    void insertPlaylist(Playlist playlist);

    List<Playlist> getUserPlaylist(Map<String, Object> paramMap);

    void insertPlaylistSong(Playlist playlist);

    void deletePlaylist(Map<String, Object> paramMap);

}
