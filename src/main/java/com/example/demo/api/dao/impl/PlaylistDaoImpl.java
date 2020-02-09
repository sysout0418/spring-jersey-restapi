package com.example.demo.api.dao.impl;

import com.example.demo.api.dao.PlaylistDao;
import com.example.demo.api.dto.Playlist;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("PlaylistDao")
public class PlaylistDaoImpl implements PlaylistDao {

    @Autowired
    private SqlSession mapper;

    @Override
    public void insertPlaylist(Playlist playlist) {
        mapper.insert("Playlist.insertPlaylist", playlist);
    }

    @Override
    public List<Playlist> getUserPlaylist(Map<String, Object> paramMap) {
        return mapper.selectList("Playlist.getUserPlaylist", paramMap);
    }

    @Override
    public void insertPlaylistSong(Playlist playlist) {
        mapper.insert("Playlist.insertPlaylistSong", playlist);
    }

    @Override
    public void deletePlaylist(Map<String, Object> paramMap) {
        mapper.update("Playlist.deletePlaylist", paramMap);
    }

}
