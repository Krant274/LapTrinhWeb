package vn.thct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import vn.thct.Config.StorageProperties;
import vn.thct.Service.IStorageService;
import vn.thct.configs.MySiteMeshFilter;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(IStorageService storageService) {
		return (arg ->{
			storageService.init();
		});
	}

}
