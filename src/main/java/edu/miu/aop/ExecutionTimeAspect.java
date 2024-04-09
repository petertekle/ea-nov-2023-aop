package edu.miu.aop;

import edu.miu.domain.ActivityLog;
import edu.miu.repository.ActivityLogRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {
    private final ActivityLogRepository activityLogRepository;

    @Pointcut("@annotation(ExecutionTime)")
    public void executionTimePointcut() {}

    @After("executionTimePointcut()")
    public void logExecutionTime(JoinPoint joinPoint) throws Throwable {
        Method method = resolveMethod(joinPoint);
        ExecutionTime annotation = method.getAnnotation(ExecutionTime.class);
        String operation = method.getDeclaringClass().getSimpleName() + "." + method.getName();
        long duration = System.currentTimeMillis() - annotation.startTime();
        activityLogRepository.save(new ActivityLog(new Date(), operation, duration));
    }

    private edu.miu.aop.Method resolveMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod();
    }
}
