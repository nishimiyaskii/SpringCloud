package com.aimerrhythms.springcloud.consumer02.exception;

import com.aimerrhythms.springcloud.consumer02.service.HystrixAndFeignService;
import org.springframework.stereotype.Component;

/**
 * @author aimerrhythms
 * @data 2020/6/26 23:44
 */
@Component
public class HystrixAndFeignFallBack implements HystrixAndFeignService {

    @Override
    public String hfTest() {
        return "测试整合Hystrix和Feign的fallback属性";
    }
}
