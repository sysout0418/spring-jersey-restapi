package com.example.demo.api.dao.impl;

import com.example.demo.api.dao.SearchDao;
import com.example.demo.api.dto.Album;
import com.example.demo.api.dto.Song;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("SearchDao")
public class SearchDaoImpl implements SearchDao {

    @Autowired
    private SqlSession mapper;

    @Override
    public List<Album> getAlbumList(Map<String, Object> paramMap) {
        return mapper.selectList("Search.getAlbumList", paramMap);
    }

    @Override
    public List<Song> getSongList(Map<String, Object> paramMap) {
        return mapper.selectList("Search.getSongList", paramMap);
    }

}
