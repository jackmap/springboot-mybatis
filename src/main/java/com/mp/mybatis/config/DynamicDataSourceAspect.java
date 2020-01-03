package com.mp.mybatis.config;

import com.mp.mybatis.datasource.DynamicDataSource;
import com.mp.mybatis.datasource.DynamicDataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * 多数据源处理
 *
 * @author zrsupply
 */
@Aspect
@Order(1)
@Component
public class DynamicDataSourceAspect
{
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(com.mp.mybatis.config.TargetDataSource)")
    public void dsPointCut()
    {

    }

    @Around("dsPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable
    {
        MethodSignature signature = (MethodSignature) point.getSignature();

        Method method = signature.getMethod();

        TargetDataSource dataSource = method.getAnnotation(TargetDataSource.class);

        if (!StringUtils.isEmpty(dataSource))
        {
            DynamicDataSourceContextHolder.setDateSoureType(dataSource.value().name());
        }

        try
        {
            return point.proceed();
        }
        finally
        {
            // 销毁数据源 在执行方法之后
            DynamicDataSourceContextHolder.clearDateSoureType();
        }
    }
}
