package com.example.demo.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <pre> 
 * com.example.demo.common
 * </pre>
 * @author : sangil im
 * @since : 2020. 02. 08.
 */
@Component
@ConfigurationProperties("response.code")
@Getter
@Setter
public class ResponseCodeProperty {

	private String success;
	private String systemError;
	private String invalidParameter;
	private String noPlaylist;

}
