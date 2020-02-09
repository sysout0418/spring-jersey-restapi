package com.example.demo.api.service.impl;

import com.example.demo.api.dao.SearchDao;
import com.example.demo.api.dto.Album;
import com.example.demo.api.dto.Song;
import com.example.demo.api.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("SearchService")
@Slf4j
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchDao searchDao;

    @Override
    public List<Album> getAlbumList(Map<String, Object> paramMap) {
        log.info("=== getAlbumList start ===");

        List<Album> albumList = searchDao.getAlbumList(paramMap);

        log.info("=== getAlbumList end ===");

        return albumList;
    }

    @Override
    public List<Song> getSongList(Map<String, Object> paramMap) {
        log.info("=== getSongList start ===");

        List<Song> songList = searchDao.getSongList(paramMap);

        log.info("=== getSongList start ===");

        return songList;
    }

}
