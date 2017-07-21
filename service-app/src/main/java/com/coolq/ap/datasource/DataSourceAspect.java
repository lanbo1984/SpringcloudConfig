package com.coolq.ap.datasource;

import com.coolq.ap.datasource.annotation.DbMsEnum;
import com.coolq.ap.datasource.annotation.SwitchDs;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * 数据源切面，拦截指定方法
 */
@Aspect
@Component
@Order(0)
public class DataSourceAspect {
    private static final Logger log = LoggerFactory.getLogger(DataSourceAspect.class);


    @Pointcut("execution(* com.coolq.ap.service.impl..*(..))")
    public void pointcut() {
    }

    @Before(value = "pointcut()")
    public void before(JoinPoint point) throws Throwable {

        Object target = point.getTarget();
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        Method method = target.getClass().getMethod(point.getSignature().getName(), parameterTypes);

        if (method.isAnnotationPresent(SwitchDs.class)) {
            SwitchDs ds = method.getAnnotation(SwitchDs.class);
            DynamicDataSourceHolder.putDataSource(ds.ms().get());
            log.info("switch ds is {}", ds.ms().get());
        } else {
            DynamicDataSourceHolder.putDataSource(DbMsEnum.SCHEDB.get());
        }
    }
}
