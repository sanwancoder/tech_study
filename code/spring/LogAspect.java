package com.megvii.insight.dzh.advice;

import com.alibaba.fastjson.JSON;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Author: 
 */
@Aspect
@Slf4j
@Component
public class LogAspect {

  //设置切入点：这里直接拦截被@RestController注解的类
  @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
  public void controllerAspect() {

  }

  /**
   * 前置通知 用于拦截Controller层记录用户的操作
   *
   * @param joinPoint 切点
   */
  @Before("controllerAspect()")
  public  void doBefore(JoinPoint joinPoint) {

    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    HttpSession session = request.getSession();

    log.info("请求IP: {} 请求路径: {} 请求方式: {} 方法描述: {} 请求参数: {}",
         request.getRemoteAddr(), request.getRequestURL(), request.getMethod(),
        getMethodInfo(joinPoint), JSON.toJSONString(request.getParameterMap()));
  }

  private String getMethodInfo(JoinPoint point) {
    ConcurrentHashMap<String, Object> info = new ConcurrentHashMap<>(3);

    info.put("class", point.getTarget().getClass().getSimpleName());
    info.put("method", point.getSignature().getName());

    String[] parameterNames = ((MethodSignature) point.getSignature()).getParameterNames();
    ConcurrentHashMap<String, String> args = null;

    if (Objects.nonNull(parameterNames)) {
      args = new ConcurrentHashMap<>(parameterNames.length);
      for (int i = 0; i < parameterNames.length; i++) {
        String value = point.getArgs()[i] != null ? point.getArgs()[i].toString() : "null";
        args.put(parameterNames[i], value);
      }
      info.put("args", args);
    }
    return JSON.toJSONString(info);
  }


}
