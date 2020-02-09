package com.example.demo.api.controller;

import com.example.demo.api.dto.Album;
import com.example.demo.api.service.AlbumService;
import com.example.demo.common.ResponseCodeProperty;
import com.example.demo.common.exception.APIException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Class Name : AlbumController
 * Description : Album List API
 * </pre>
 *
 * @author sangil kim
 * @since 2020. 02. 08.
 * @see
 */
@Component
@Slf4j
public class AlbumController {

    @Autowired
    private ResponseCodeProperty responseProperties;

    @Autowired
    private AlbumService albumService;

    @Value("${page.display.count}")
    private int displayCount;

    /**
     * 앨범을 10개 단위로 paging 해서 return
     *
     * @param locale
     * @param page
     * @return
     */
    @GET
    @Path("/albums/{locale}/{page}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getAlbumlist(@PathParam("locale") String locale, @PathParam("page") int page) {
        log.info("[getAlbumlist 시작]");

        log.info("locale : " + locale);
        log.info("page : " + page);
        log.info("display_count : " + displayCount);

        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> paramMap = new HashMap<>();
        resultMap.put("statusCode", "200");

        try {
            // 앨범 목록 조회
            paramMap.put("locale", locale);
            paramMap.put("page", page);
            paramMap.put("display_count", displayCount);
            List<Album> albumList = albumService.getAlbumList(paramMap);

            // 페이지 정보 셋팅
            Map<String, Object> pageInfo = albumService.getPageInfo(page, albumList.size());

            resultMap.put("pages", pageInfo);
            resultMap.put("albums", albumList);

        } catch (APIException e) {
            log.error(e.getCode()+":"+e.getMessage());
            resultMap.put("statusCode", e.getCode());
            resultMap.put("statusMsg", e.getMessage());
        } catch (Exception e) {
            resultMap.put("statusCode", "system_error");
            resultMap.put("statusMsg", responseProperties.getSystemError());
        }

        log.info("Res Param : " + resultMap);
        log.info("[getAlbumlist 종료]");

        return resultMap;
    }

}
