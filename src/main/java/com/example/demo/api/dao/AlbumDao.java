package com.example.demo.api.dao;

import com.example.demo.api.dto.Album;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AlbumDao {

    List<Album> getAlbumList(Map<String, Object> paramMap);

}
