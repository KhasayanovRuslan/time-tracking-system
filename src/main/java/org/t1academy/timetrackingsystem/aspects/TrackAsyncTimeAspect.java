package org.t1academy.timetrackingsystem.aspects;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.t1academy.timetrackingsystem.exceptions.InternalServerException;
import org.t1academy.timetrackingsystem.services.TimeTrackingService;

import java.util.concurrent.CompletableFuture;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
@EnableAsync
public class TrackAsyncTimeAspect {


    private final TimeTrackingService timeTrackingService;

    @Pointcut("@annotation(org.t1academy.timetrackingsystem.aspect.annotation.TrackAsyncTime)")
    public void trackAsyncPointcut() {
    }

    @Around("trackAsyncPointcut()")
    public Object trackAsyncTimeMethod(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();

        return CompletableFuture.supplyAsync(() -> {
                    try {
                        return joinPoint.proceed();
                    } catch (Throwable e) {
                        throw new InternalServerException(e.getMessage());
                    }
                })
                .thenApply(result -> {
                    long endTime = System.currentTimeMillis();
                    long executionTime = endTime - startTime;
                    timeTrackingService.addTimeTracking(executionTime, joinPoint);
                    log.info("Method {} executed async in {} ms", joinPoint.getSignature().getName(), executionTime);
                    return result;
                })
                .exceptionally(e -> {
                    throw new InternalServerException(e.getMessage());
                });
    }

}
