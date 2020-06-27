package com.aimerrhythms.springcloud.consumer02.exception;

import com.aimerrhythms.springcloud.consumer02.service.HystrixAndFeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author aimerrhythms
 * @data 2020/6/27 0:06
 */
@Component
public class HystrixAndFeignFallBackFactory implements FallbackFactory<HystrixAndFeignService>{

    @Override
    public HystrixAndFeignService create(Throwable t) {
        return new HystrixAndFeignService() {
            @Override
            public String hfTest() {
                System.out.println(t);
                /*
                    根据错误类型进行不同的Fail逻辑
                    if(cause instanceof InternalServerError) {
                        System.out.println("InternalServerError");
                        return "远程服务报错";
                    }else if(cause instanceof RuntimeException) {
                        return "请求时异常：" + cause;
                    }else {
                        return "都算不上";
                    }
                 */
                return t.getLocalizedMessage();
            }
        };
    }
}
