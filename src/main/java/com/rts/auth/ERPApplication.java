

package com.rts.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = {"com.rts"})
@EntityScan( basePackages = {"com.rts"} )
@SpringBootApplication
@EnableScheduling
public class ERPApplication {

	public static void main(String[] args) {
		System.setProperty("server.port","8090");
		System.setProperty("file.encoding", "UTF-8");
		SpringApplication.run(ERPApplication.class, args);
	}

		
}
