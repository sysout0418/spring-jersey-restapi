package com.example.demo.api.controller;

import com.example.demo.api.dto.Album;
import com.example.demo.api.dto.Song;
import com.example.demo.api.service.SearchService;
import com.example.demo.common.ResponseCodeProperty;
import com.example.demo.common.exception.APIException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Class Name : SearchController
 * Description : Search API
 * </pre>
 *
 * @author sangil kim
 * @since 2020. 02. 08.
 * @see
 */
@Component
@Slf4j
@Path("/search")
public class SearchController {

    @Autowired
    private ResponseCodeProperty responseProperties;

    @Autowired
    private SearchService searchService;

    /**
     * 앨범/곡을 검색
     *
     * @param title
     * @param locale
     * @return
     */
    @GET
    @Path("/{title}/{locale}")
    @Produces("application/json")
    public Map<String, Object> search(@PathParam("title") String title, @PathParam("locale") String locale) {
        log.info("[search 시작]");

        log.info("title : {}", title);
        log.info("locale : {}", locale);

        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> paramMap = new HashMap<>();

        try {
            paramMap.put("title", title);
            paramMap.put("locale", locale);
            List<Album> albumList = searchService.getAlbumList(paramMap);
            List<Song> songList = searchService.getSongList(paramMap);

            log.info("albumList : " + albumList);
            log.info("songList : " + songList);

            resultMap.put("albums", albumList);
            resultMap.put("songs", songList);
        } catch (APIException e) {
            log.error(e.getCode()+":"+e.getMessage());
            resultMap.put("status_code", e.getCode());
            resultMap.put("status_msg", e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resultMap.put("status_code", "system_error");
            resultMap.put("status_msg", responseProperties.getSystemError());
        }

        log.info("Res Param : " + resultMap);
        log.info("[search 종료]");

        return resultMap;
    }

}
