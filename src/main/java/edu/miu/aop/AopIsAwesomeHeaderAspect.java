package edu.miu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AopIsAwesomeHeaderAspect {

    @Pointcut("within(edu.miu.service..*) && @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postRequestsInServiceLayer() {}

    @Before("postRequestsInServiceLayer()")
    public void checkAopIsAwesomeHeader(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
        HttpServletRequest request = (HttpServletRequest) ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String headerValue = request.getHeader("AOP-IS-AWESOME");
        if (headerValue == null || !headerValue.equals("true")) {
            throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header is missing or invalid.");
        }
    }
}
