package com.aimerrhythms.springcloud.springcloudconsumer01.exception;

import com.aimerrhythms.springcloud.springcloudconsumer01.service.FeignAndHystrixService;
import org.springframework.stereotype.Component;

/**
 *
 * @author aimerrhythms
 * @data 2020/6/7 20:04
 */
@Component
public class FeignAndHystrixFallBack implements FeignAndHystrixService {

    //当远程调用的方法抛出异常时，执行下面同名的方法
    @Override
    public String alive() {
        return "降级处理...";
    }
}
