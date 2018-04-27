package com.whp.async;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @描述：异步线程调用工具
 *
 * @作者：whp
 * 
 * @时间：2018年3月16日 下午8:40:09
 */
@Component
public class AsysncTheadTaskService {

	private static final Logger log = LoggerFactory.getLogger(AsysncTheadTaskService.class);

	/**
	 * 最简单的异步调用，返回值为void
	 */
	@Async("taskAsyncPool")
	public void asyncInvokeSimplest() {

		log.info("最简单的异步线程调用");
	}

	/**
	 * 带参数的异步调用 异步方法可以传入参数 对于返回值是void，异常会被AsyncUncaughtExceptionHandler处理掉
	 * 
	 * @param s
	 */
	@Async("taskAsyncPool")
	public void asyncInvokeWithException(String s) {
		log.info("asyncInvokeWithParameter, parementer={}", s);
		throw new IllegalArgumentException(s);
	}

	/**
	 * 异常调用返回Future
	 * 对于返回值是Future，不会被AsyncUncaughtExceptionHandler处理，需要我们在方法中捕获异常并处理
	 * 或者在调用方在调用Futrue.get时捕获异常进行处理
	 * 
	 * @param i
	 * @return
	 */
	@Async("taskAsyncPool")
	public Future<String> asyncInvokeReturnFuture(int i) {
		log.info("asyncInvokeReturnFuture, parementer={}", i);
		Future<String> future;
		try {
			Thread.sleep(1000 * 1);
			future = new AsyncResult<String>("success:" + i);
			//throw new IllegalArgumentException("a");
		} catch (InterruptedException e) {
			future = new AsyncResult<String>("error");
			//future.isCancelled();
		} catch (IllegalArgumentException e) {
			future = new AsyncResult<String>("error-IllegalArgumentException");
			//future.isCancelled();
		}
		//future.isDone();
			return future;
	}

	@Async("taskAsyncPool")
	public Future<String> dealHaveReturnTask() {
		JSONObject jsonObject = new JSONObject();
		Future<String> result =new AsyncResult<String>("");
		try {
			Thread.sleep(3000);

			jsonObject.put("thread", Thread.currentThread().getName());
			jsonObject.put("time", System.currentTimeMillis());
		} catch (InterruptedException e) {
			log.error("异步线程执行错误!!", e.getMessage());
			//result.isCancelled();
			
		}
		//result.isDone();
		return result ;
	}

}
