package com.mp.mybatis.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 动态数据源
 * */
public class DynamicDataSource extends AbstractRoutingDataSource
{

    @Override
    protected Object determineCurrentLookupKey()
    {
        System.out.println("数据源为"+DynamicDataSourceContextHolder.getDateSoureType());
        return DynamicDataSourceContextHolder.getDateSoureType();
    }
}
