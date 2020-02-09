package com.example.demo.common;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component("PageUtil")
public class PageUtil {

	public void setPagingInfo(Map<String, Object> paramMap) {

		int pageNo = Integer.parseInt((String) paramMap.get("page"));
		int displayCnt = Integer.parseInt((String) paramMap.get("row_count"));
		
		int startNum = (pageNo - 1) * displayCnt;
		
		paramMap.put("display_count", displayCnt);
		paramMap.put("offset", startNum);
	}

}
