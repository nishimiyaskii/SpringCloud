package com.aimerrhythms.springcloud.consumer02.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author aimerrhythms
 * @data 2020/6/26 23:08
 */
public class HystrixTest extends HystrixCommand {

    protected HystrixTest(HystrixCommandGroupKey group) {
        super(group);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
            execute：同步阻塞的方式执行run方法

            执行过程：
                1、调用execute方法
                2、调用线程阻塞
                3、Hystrix创建新的线程去执行run方法
                4、run方法执行成功，返回结果给调用线程，调用线程解除阻塞
                5、run方法执行失败，调用getFallback方法，然后getFallback返回结果给调用线程，调用线程解除阻塞
                6、如果getFallback方法也抛出异常，那么就直接抛出异常：
                    HystrixRuntimeException: HystrixTest failed and fallback failed.

         */
        HystrixTest ext = new HystrixTest(HystrixCommandGroupKey.Factory.asKey("ext"));
        System.out.println("result1 = " + ext.execute());


        /*
            queue：异步非阻塞的方式执行run方法

            执行过程：
                1、调用queue方法，直接返回一个Future对象
                2、Hystrix会创建一个新的线程去运行run方法
                3、再调用Future对象的get方法，获取执行结果
                4、get方法时同步阻塞的，异常处理同execute方法

            注意：同一个对象，不能先执行execute，再行queue，否则会报错：
                HystrixRuntimeException:HystrixTest command executed multiple times - this is not permitted.
         */
        ext = new HystrixTest(HystrixCommandGroupKey.Factory.asKey("ext"));
        Future future = ext.queue();
        System.out.println("result2 = " + future.get());


    }

    @Override
    protected Object run() throws Exception {
        System.out.println("执行逻辑");
        //异常，转到getFallback方法
//        int i = 1 / 0;
        return "ok";
    }

    @Override
    protected Object getFallback() {
//        int i = 1 / 0;
        return "getFallbackgetFallback";
    }
}
