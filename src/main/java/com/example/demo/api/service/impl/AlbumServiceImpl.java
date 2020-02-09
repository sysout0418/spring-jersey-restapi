package com.example.demo.api.service.impl;

import com.example.demo.api.dao.AlbumDao;
import com.example.demo.api.dto.Album;
import com.example.demo.api.service.AlbumService;
import com.example.demo.common.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("AlbumService")
@Slf4j
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;

    @Resource(name = "PageUtil")
    private PageUtil pageUtil;

    @Override
    public List<Album> getAlbumList(Map<String, Object> paramMap) {
        log.info("포스팅에 등록한 해시태그 Select 시작");


        return null;
    }
}
