package com.example.demo.api.dao;

import com.example.demo.api.dto.Album;
import com.example.demo.api.dto.Song;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SearchDao {

    List<Album> getAlbumList(Map<String, Object> paramMap);

    List<Song> getSongList(Map<String, Object> paramMap);

}
