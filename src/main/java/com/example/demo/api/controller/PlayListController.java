package com.example.demo.api.controller;

import com.example.demo.api.dto.Playlist;
import com.example.demo.api.service.PlaylistService;
import com.example.demo.common.ResponseCodeProperty;
import com.example.demo.common.exception.APIException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Class Name : PlayListController
 * Description : Playlist 관련 API
 * </pre>
 *
 * @author sangil kim
 * @since 2020. 02. 08.
 * @see
 */
@Component
@Slf4j
@Path("/playlist")
public class PlayListController {

    @Autowired
    private ResponseCodeProperty responseProperties;

    @Autowired
    private PlaylistService playlistService;

    /**
     * Playlist 생성
     *
     * @param reqParam
     * @return
     */
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> createPlaylist(@RequestBody Map<String, Object> reqParam) {
        log.info("[createPlaylist 시작]");

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status_code", "success");
        resultMap.put("status_msg", responseProperties.getSuccess());

        try {
            // 파라미터 초기화
            Playlist playlist = playlistService.initDataCreatePlaylist(reqParam);

            // playlist 생성
            playlistService.insertPlaylist(playlist);

        } catch (APIException e) {
            log.error(e.getCode()+":"+e.getMessage());
            resultMap.put("status_code", e.getCode());
            resultMap.put("status_msg", e.getMessage());
        } catch (Exception e) {
            resultMap.put("status_code", "system_error");
            resultMap.put("status_msg", responseProperties.getSystemError());
        }

        log.info("Res Param : " + resultMap);
        log.info("[createPlaylist 종료]");

        return resultMap;
    }

    /**
     * Playlist 노래, 앨범 추가
     *
     * @param reqParam
     * @return
     */
    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> addSong(@RequestBody Map<String, Object> reqParam) {
        log.info("[addSong 시작]");

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status_code", "0");
        resultMap.put("status_msg", responseProperties.getSuccess());

        try {
            // 파라미터 초기화
            Playlist playlist = playlistService.initDataAddSong(reqParam);

            // 유효성 체크
            playlistService.checkValidationAddSong(reqParam);

            // playlist 생성
            playlistService.insertPlaylistSong(playlist);

        } catch (APIException e) {
            log.error(e.getCode()+":"+e.getMessage());
            resultMap.put("status_code", e.getCode());
            resultMap.put("status_msg", e.getMessage());
        } catch (Exception e) {
            resultMap.put("status_code", "system_error");
            resultMap.put("status_msg", responseProperties.getSystemError());
        }

        log.info("Res Param : " + resultMap);
        log.info("[addSong 종료]");

        return resultMap;
    }

    /**
     * Playlist 목록
     *
     * @param userId
     * @return
     */
    @GET
    @Path("/user/{user_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getUserPlaylist(@PathParam("user_id") long userId) {
        log.info("[getUserPlaylist 시작]");

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status_code", "0");
        resultMap.put("status_msg", responseProperties.getSuccess());

        try {
            // user_id에 해당하는 playlist 조회
            List<Playlist> userPlaylist = playlistService.getUserPlaylist(userId);
            resultMap.put("playlist", userPlaylist);

        } catch (APIException e) {
            log.error(e.getCode()+":"+e.getMessage());
            resultMap.put("status_code", e.getCode());
            resultMap.put("status_msg", e.getMessage());
        } catch (Exception e) {
            resultMap.put("status_code", "system_error");
            resultMap.put("status_msg", responseProperties.getSystemError());
        }

        log.info("Res Param : " + resultMap);
        log.info("[getUserPlaylist 종료]");

        return resultMap;
    }

    /**
     * Playlist 삭제
     *
     * @param userId
     * @param playlistId
     * @return
     */
    @DELETE
    @Path("/delete/{user_id}/{playlist_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> deletePlaylist(@PathParam("user_id") long userId, @PathParam("playlist_id") long playlistId) {
        log.info("[deletePlaylist 시작]");

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status_code", "0");
        resultMap.put("status_msg", responseProperties.getSuccess());

        try {
            // user_id, playlist_id에 해당하는 playlist 삭제
            playlistService.deletePlaylist(userId, playlistId);

        } catch (APIException e) {
            log.error(e.getCode()+":"+e.getMessage());
            resultMap.put("status_code", e.getCode());
            resultMap.put("status_msg", e.getMessage());
        } catch (Exception e) {
            resultMap.put("status_code", "system_error");
            resultMap.put("status_msg", responseProperties.getSystemError());
        }

        log.info("Res Param : " + resultMap);
        log.info("[deletePlaylist 종료]");

        return resultMap;
    }

}
