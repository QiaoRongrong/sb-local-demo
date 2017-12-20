package com.yf.sblocaldemo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Slf4j
@EnableWebMvc
@SpringBootApplication
@MapperScan(basePackages = "com.yf.sblocaldemo.mapper")
public class SbLocalDemoApplication extends WebMvcConfigurerAdapter implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SbLocalDemoApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        log.info("...服务启动完成!");
    }
}
