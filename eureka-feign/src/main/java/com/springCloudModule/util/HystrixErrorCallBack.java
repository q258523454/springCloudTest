package com.springCloudModule.util;

import com.springCloudModule.service.FeignService;
import org.springframework.stereotype.Component;

/**
 * Created By
 *
 * @author :   zhangjian
 * @date :   2018-10-15
 */


@Component
public class HystrixErrorCallBack implements FeignService {
    @Override
    public String callFeign(String name) {
        return "Sorry:"+name+", Hystrix Occur Error.";
    }
}
