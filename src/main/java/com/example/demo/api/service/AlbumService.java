package com.example.demo.api.service;

import com.example.demo.api.dto.Album;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface AlbumService {

    List<Album> getAlbumList(Map<String, Object> paramMap);

    Map<String, Object> getPageInfo(int page, int albumSize);

}
