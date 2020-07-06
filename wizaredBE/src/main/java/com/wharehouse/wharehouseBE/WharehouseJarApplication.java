package com.wharehouse.wharehouseBE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class WharehouseJarApplication {
   
	public static void main(String[] args) {
		SpringApplication.run(WharehouseJarApplication.class, args);
	}
        
}
