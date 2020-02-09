package com.example.demo.api.service.impl;

import com.example.demo.api.dao.PlaylistDao;
import com.example.demo.api.dto.Playlist;
import com.example.demo.api.dto.Song;
import com.example.demo.api.service.PlaylistService;
import com.example.demo.common.ResponseCodeProperty;
import com.example.demo.common.exception.APIException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("PlaylistService")
@Slf4j
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private ResponseCodeProperty responseProperties;

    @Autowired
    private PlaylistDao playlistDao;

    @Override
    public Playlist initDataCreatePlaylist(Map<String, Object> reqParam) {
        log.info("=== initDataCreatePlaylist start ===");

        String userId = String.valueOf(reqParam.get("user_id"));
        String playlistName = String.valueOf(reqParam.get("playlist_name"));
        log.info("userId : {}", userId);
        log.info("playlistName : {}", playlistName);

        if ("null".equals(userId) || "".equals(userId)) {
            log.error("user_id is Null");
            throw new APIException("invalid_parameter", responseProperties.getInvalidParameter());
        }
        if ("null".equals(playlistName) || "".equals(playlistName)) {
            log.error("playlist_name is Null");
            throw new APIException("invalid_parameter", responseProperties.getInvalidParameter());
        }

        Playlist playlist = new Playlist();
        playlist.setUserId(Long.parseLong(userId));
        playlist.setPlaylistName(playlistName);

        log.info("=== initDataCreatePlaylist end ===");

        return playlist;
    }

    @Override
    public void insertPlaylist(Playlist playlist) {
        log.info("=== insertPlaylist start ===");

        playlistDao.insertPlaylist(playlist);

        log.info("=== insertPlaylist end ===");
    }

    @Override
    public Playlist initDataAddSong(Map<String, Object> reqParam) {
        log.info("=== initDataAddSong start ===");

        String userId = String.valueOf(reqParam.get("user_id"));
        String playlistId = String.valueOf(reqParam.get("playlist_id"));
        List<Song> songIdList = (List<Song>) reqParam.get("song_ids");
        log.info("userId : {}", userId);
        log.info("playlistName : {}", playlistId);
        log.info("songIdList : {}", songIdList);

        if ("null".equals(userId) || "".equals(userId)) {
            log.error("user_id is Null");
            throw new APIException("invalid_parameter", responseProperties.getInvalidParameter());
        }
        if ("null".equals(playlistId) || "".equals(playlistId)) {
            log.error("playlist_id is Null");
            throw new APIException("invalid_parameter", responseProperties.getInvalidParameter());
        }
        if (songIdList == null || songIdList.size() == 0) {
            log.error("song_ids is Null");
            throw new APIException("invalid_parameter", responseProperties.getInvalidParameter());
        }

        Playlist playlist = new Playlist();
        playlist.setUserId(Long.parseLong(userId));
        playlist.setPlaylistId(Long.parseLong(playlistId));
        playlist.setSongs(songIdList);

        log.info("=== initDataAddSong end ===");

        return playlist;
    }

    @Override
    public void checkValidationAddSong(Map<String, Object> reqParam) {
        log.info("=== checkValidationAddSong start ===");

        String userId = String.valueOf(reqParam.get("user_id"));
        String playlistId = String.valueOf(reqParam.get("playlist_id"));

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        paramMap.put("playlistId", playlistId);
        List<Playlist> userPlaylist = playlistDao.getUserPlaylist(paramMap);
        if (userPlaylist == null || userPlaylist.size() == 0) {
            log.error("user playlist is not exists");
            throw new APIException("no_playlist", responseProperties.getNoPlaylist());
        }

        log.info("=== checkValidationAddSong end ===");
    }

    @Override
    public void insertPlaylistSong(Playlist playlist) {
        log.info("=== insertPlaylistSong start ===");

        playlistDao.insertPlaylistSong(playlist);

        log.info("=== insertPlaylistSong end ===");
    }

    @Override
    public List<Playlist> getUserPlaylist(long userId) {
        log.info("=== getUserPlaylist start ===");

        log.info("userId : " + userId);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        List<Playlist> userPlaylist = playlistDao.getUserPlaylist(paramMap);

        log.info("=== getUserPlaylist end ===");

        return userPlaylist;
    }

    @Override
    public void deletePlaylist(long userId, long playlistId) {
        log.info("=== deletePlaylist start ===");

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        paramMap.put("playlistId", playlistId);
        playlistDao.deletePlaylist(paramMap);

        log.info("=== deletePlaylist end ===");
    }

}
