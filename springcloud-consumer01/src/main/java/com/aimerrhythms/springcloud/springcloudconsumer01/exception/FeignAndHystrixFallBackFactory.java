package com.aimerrhythms.springcloud.springcloudconsumer01.exception;

import com.aimerrhythms.springcloud.springcloudconsumer01.service.FeignAndHystrixService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory的优先级低于FallBack?
 * @author aimerrhythms
 * @data 2020/6/7 20:11
 */
@Component
public class FeignAndHystrixFallBackFactory implements FallbackFactory<FeignAndHystrixService> {

    @Override
    public FeignAndHystrixService create(Throwable t) {
        //只有一个方法的话可以使用lambda表达式
        return new FeignAndHystrixService() {
            @Override
            public String alive() {
                //可以通过throwable参数获得异常的参数
                Map<String, String> map = new HashMap<>();
                map.put("Throwable", t.toString());
                map.put("ErrorMessage", t.getMessage());
                map.put("StackTrace", Arrays.toString(t.getStackTrace()));
                map.put("LocalizedMessage", t.getLocalizedMessage());

                //也可以针对不同的异常类型，返回不同的消息
                if (t instanceof ArithmeticException) {
                    map.put("ErrorType", "远程服务错误");
                } else {
                    map.put("ErrorType", "其他错误");
                }

                System.out.println(map);

                return map.toString();
            }
        };
    }
}
