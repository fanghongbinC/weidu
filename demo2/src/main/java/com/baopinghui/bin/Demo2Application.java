package com.baopinghui.bin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baopinghui.bin.util.MyMapper;

@SpringBootApplication
//@MapperScan("com.baopinghui.bin.mapper.app")
@MapperScan(basePackages = "com.baopinghui.bin.mapper", markerInterface = MyMapper.class)
@EnableTransactionManagement // 开启注解事务管理，等同于xml配置文件中的 <tx:annotation-driven />
public class Demo2Application extends  SpringBootServletInitializer {
//	如果是打成可以运行的jar要用自带的tomcat就把上面的继承 去掉，再把下面的第一个方法注释掉
	   @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(Demo2Application.class);
	    }
	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
	
}
