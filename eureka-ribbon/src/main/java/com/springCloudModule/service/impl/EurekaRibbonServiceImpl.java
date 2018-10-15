package com.springCloudModule.service.impl;

import com.springCloudModule.service.EurekaRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created By
 *
 * @author :   zhangjian
 * @date :   2018-10-12
 */

@Service
public class EurekaRibbonServiceImpl implements EurekaRibbonService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String ribbonTest(String name) {
        return restTemplate.getForObject("http://eureka-service/getServicePort?name=" + name, String.class);
    }
}
