package com.mp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;



/**
 * springboot入口类,此类需要在所有用到的package上层
 * exclude = {DataSourceAutoConfiguration.class}
 * 禁用springboot默认加载的application.properties单数据源配置
*/
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SpringbootMybatisApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootMybatisApplication.class, args);
		System.out.println("springboot结合druid使用多数据源，动态切换..........");
	}

}
