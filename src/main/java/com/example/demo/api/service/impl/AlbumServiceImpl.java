package com.example.demo.api.service.impl;

import com.example.demo.api.dao.AlbumDao;
import com.example.demo.api.dto.Album;
import com.example.demo.api.service.AlbumService;
import com.example.demo.common.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("AlbumService")
@Slf4j
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;

    @Resource(name = "PageUtil")
    private PageUtil pageUtil;

    @Value("${server.address}")
    private String serverAddress;

    @Override
    public List<Album> getAlbumList(Map<String, Object> paramMap) {
        log.info("=== getAlbumList start ===");

        pageUtil.setPagingInfo(paramMap);
        List<Album> albumList = albumDao.getAlbumList(paramMap);

        log.info("=== getAlbumList end ===");

        return albumList;
    }

    @Override
    public Map<String, Object> getPageInfo(int page, int albumSize) {
        log.info("=== getPageInfo start ===");

        Map<String, Object> pageInfo = new HashMap<>();

        if (albumSize > 0 && albumSize == 1) {
            pageInfo.put("first", serverAddress + "/albums/1");
            pageInfo.put("last", serverAddress + "/albums/" + albumSize);
        } else if (albumSize > 1) {
            pageInfo.put("first", serverAddress + "/albums/1");
            pageInfo.put("prev", serverAddress + "/albums/" + (page - 1));
            pageInfo.put("last", serverAddress + "/albums/" + albumSize);
            pageInfo.put("next", serverAddress + "/albums/" + (page + 1));
        }

        log.info("=== getPageInfo start ===");

        return pageInfo;
    }
}
