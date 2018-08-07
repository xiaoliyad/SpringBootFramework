package com.watchdata.framework.aspectj;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.watchdata.common.toolkits.StringUtils;
import com.watchdata.framework.aspectj.lang.annotation.Ds;
import com.watchdata.framework.datasource.DynamicDataSourceContextHolder;

/**
 * 多数据源处理
 * 
 * @author 
 */
@Aspect
@Order(1)
@Component
public class DsAspect
{
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(com.watchdata.framework.aspectj.lang.annotation.Ds)")
    public void dsPointCut()
    {

    }

    @Around("dsPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable
    {
        MethodSignature signature = (MethodSignature) point.getSignature();

        Method method = signature.getMethod();

        if (method.isAnnotationPresent(Ds.class))
        {
            Ds dataSource = method.getAnnotation(Ds.class);
            if (StringUtils.isNotNull(dataSource) && StringUtils.isNotEmpty(dataSource.name()))
            {
                DynamicDataSourceContextHolder.setDB(dataSource.name());
            }
        }

        try
        {
            return point.proceed();
        }
        finally
        {
            DynamicDataSourceContextHolder.clearDB();
        }
    }
}
