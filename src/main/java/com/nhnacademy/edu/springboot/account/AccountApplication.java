package com.nhnacademy.edu.springboot.account;

import com.nhnacademy.edu.springboot.account.config.AccountVersionProperties;
import com.nhnacademy.edu.springboot.account.config.baseConfig;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@ConfigurationPropertiesScan
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(AccountApplication.class);

		application.run(args);


	}

}
