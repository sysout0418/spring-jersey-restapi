package com.example.demo.api.service;

import com.example.demo.api.dto.Album;
import com.example.demo.api.dto.Song;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface SearchService {

    List<Album> getAlbumList(Map<String, Object> paramMap);

    List<Song> getSongList(Map<String, Object> paramMap);

}
