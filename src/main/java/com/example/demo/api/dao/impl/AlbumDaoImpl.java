package com.example.demo.api.dao.impl;

import com.example.demo.api.dao.AlbumDao;
import com.example.demo.api.dto.Album;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("AlbumDao")
public class AlbumDaoImpl implements AlbumDao {

    @Autowired
    private SqlSession mapper;

    @Override
    public List<Album> getAlbumList(Map<String, Object> paramMap) {
        return mapper.selectList("Album.getAlbumList", paramMap);
    }

}
