package com.ts;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ts.models.app.AccessRole;
import com.ts.models.app.AccessUser;
import com.ts.repositories.application.AppUserRepository;

@SpringBootApplication
@ComponentScan(basePackages = "com.ts")
public class TSApplication {

	public static void main(String[] args) {
		SpringApplication.run(TSApplication.class, args);
	}
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AppUserRepository userRepository;

    @Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
    @PostConstruct
    public void init(){
        AccessUser user = new AccessUser(1L,
                "Amr",
                "El-Alamy",
                "aaelalamy",
                passwordEncoder.encode("password"),
                Arrays.asList(
                        new AccessRole("ROLE_USER"),
                        new AccessRole("ROLE_ADMIN"),
                        new AccessRole("ACTUATOR")));

        if (userRepository.findByUsername(user.getUsername()) == null){
            userRepository.save(user);
        }
    }
}
