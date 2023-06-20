package com.pablovvoliveira.vendasapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class Cfg {

    @Bean(name = "applicationName")
    String applicationName() {
		return "Sistema de vendas";
	}
	
}
