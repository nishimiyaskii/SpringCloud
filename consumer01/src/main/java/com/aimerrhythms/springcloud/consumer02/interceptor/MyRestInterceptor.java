package com.aimerrhythms.springcloud.consumer02.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.net.URI;

/**
 * @author aimerrhythms
 * @data 2020/6/24 21:08
 */
public class MyRestInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
//        System.out.println("拦截到了rest请求");
        URI uri = request.getURI();
        System.out.println(uri);
        ClientHttpResponse response = execution.execute(request, body);
//        System.out.println(response);
        return response;
    }
}
