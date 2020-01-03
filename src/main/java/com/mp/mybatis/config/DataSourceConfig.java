package com.mp.mybatis.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.mp.mybatis.datasource.DataSourceType;
import com.mp.mybatis.datasource.DynamicDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 多数据源配置类
 * Created by pure on 2018-05-06.
*/
@Configuration
public class DataSourceConfig {

    //数据源1
    @Bean
    @ConfigurationProperties("spring.datasource.druid.master") // application.properteis中对应属性的前缀
    public DataSource masterDataSource()
    {
        return DruidDataSourceBuilder.create().build();
    }
    //数据源2
    @Bean
    // application.properteis中对应属性的前缀
    @ConfigurationProperties("spring.datasource.druid.slave") // application.properteis中对应属性的前缀
    @ConditionalOnProperty(prefix = "spring.datasource.druid.slave", name = "enabled", havingValue = "true")
    public DataSource slaveDataSource()
    {
        return DruidDataSourceBuilder.create().build();
    }
    /**
     * 如果还有数据源,在这继续添加 DataSource Bean
     * */

    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource(DataSource masterDataSource, DataSource slaveDataSource)
    {
        Map<Object, Object> targetDataSources = new HashMap<>();
        // 配置多数据源
        targetDataSources.put(DataSourceType.MASTER.name(), masterDataSource);
        targetDataSources.put(DataSourceType.SLAVE.name(), slaveDataSource);
        return new DynamicDataSource(masterDataSource, targetDataSources);
    }
}
