package com.example.demo.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
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

    /**
     * 앨범을 10개 단위로 paging 해서 return
     *
     * @param httpRequest
     * @param reqParam
     * @return
     */
    @GET
    @Path("/albums")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getAlbumlist(@Context HttpServletRequest httpRequest, Map<String, Object> reqParam) {

        Map<String, Object> resultMap = new HashMap<>();

        return resultMap;
    }

}
