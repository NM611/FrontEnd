package sn.isi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebappexamApplication implements CommandLineRunner {


	@Autowired
	public CustomProperties customProperties;

	public static void main(String[] args) {
		SpringApplication.run(WebappexamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// System.out.println(customProperties.getApiUrl());

	}
}
