package com.aimerrhythms.springcloud.springcloudconsumer01;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 脱离Spring Cloud，独立使用Hystrix
 *
 * @author aimerrhythms
 * @data 2020/6/7 19:07
 */
public class HystrixTest extends HystrixCommand {


    protected HystrixTest(HystrixCommandGroupKey group) {
        super(group);
    }

    public static void main(String[] args) {


        //	HystrixTest hystrixTest = new HystrixTest(HystrixCommandGroupKey.Factory.asKey("ext"));
        /**
         * execute()：以同步阻塞方式执行run()。以demo为例，调用execute()后，
         * hystrix先创建一个新线程运行run()，
         * 	接着调用程序要在execute()调用处一直阻塞着，直到run()运行完成
         */
        //	System.out.println("result:" + hystrixTest.execute());

        /**
         * queue()：以异步非阻塞方式执行run()。以demo为例，
         * 	一调用queue()就直接返回一个Future对象，
         * 	同时hystrix创建一个新线程运行run()，
         * 	调用程序通过Future.get()拿到run()的返回结果，
         * 	而Future.get()是阻塞执行的
         */
        Future<String> futureResult = new HystrixTest(HystrixCommandGroupKey.Factory.asKey("ext")).queue();
        String result = "";
        try {
            result = futureResult.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("程序结果：" + result);
    }

    @Override
    protected Object run() throws Exception {
        System.out.println("执行逻辑");

        //抛出异常，转到getFallBack方法中执行
        int i = 1 / 0;
        return "ok";
    }

    @Override
    protected Object getFallback() {
        //run方法运行异常后，执行该方法的逻辑。并且将返回值放在Future中
        return "getFallbackgetFallback";
    }
}
