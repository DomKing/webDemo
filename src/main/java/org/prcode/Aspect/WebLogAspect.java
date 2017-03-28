package org.prcode.Aspect;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.prcode.utility.util.ExceptionUtil;
import org.prcode.utility.util.IPUtil;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @ClassName: WebLogAspect
 * @Date: 2017-03-28 13:16
 * @Auther: kangduo
 * @Description: (日志请求AOP记录)
 */
@Aspect
@Order(5)//多个切面根据order依次执行，小的先行
@Component
public class WebLogAspect {

    private Logger logger = Logger.getLogger(getClass());

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * org.prcode.web..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        logger.info("***************请求开始***************");
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + IPUtil.getRealIP(request));
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + JSON.toJSONString(ret));
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()) + "ms");
        logger.info("***************请求结束***************");
    }

    @AfterThrowing(throwing="ex", pointcut = "webLog()")
    public void doAfterThrowing(Throwable ex) {
        //有异常
        logger.info("EXCEPTION : " + ExceptionUtil.parseException(ex));
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()) + "ms");
        logger.info("***************请求结束***************");
    }
}
