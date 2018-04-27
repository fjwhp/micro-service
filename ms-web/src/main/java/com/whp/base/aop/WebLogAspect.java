package com.whp.base.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * @描述：web日志记录
 *
 * @作者：wuhp
 * 
 * @时间：2018年3月16日 下午4:05:06
 */

@Aspect
@Component
public class WebLogAspect {

  private Logger logger = LoggerFactory.getLogger(getClass());
  ThreadLocal<Long> startTime = new ThreadLocal<>();

  @Pointcut("execution(public * com.whp.*.controller..*.*(..))")
  public void webLog() {}

  @Before("webLog()")
  public void doBefore(JoinPoint joinPoint) throws Throwable {
    // 这里可以处理 用户操作日志记录 TODO
    // 接收到请求，记录请求内容
    ServletRequestAttributes attributes =
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();

    startTime.set(System.currentTimeMillis());
    // 记录下请求内容
    logger.info("URL : " + request.getRequestURL().toString());
    logger.info("HTTP_METHOD : " + request.getMethod());
    logger.info("IP : " + request.getRemoteAddr());
    logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
        + joinPoint.getSignature().getName());
    logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
  }

  @AfterReturning(returning = "ret", pointcut = "webLog()")
  public void doAfterReturning(Object ret) throws Throwable {
    // 处理完请求，返回内容
    logger.info("RESPONSE : " + ret);
    logger.info("耗时 : " + (System.currentTimeMillis() - startTime.get()) + " ms");
  }
}
