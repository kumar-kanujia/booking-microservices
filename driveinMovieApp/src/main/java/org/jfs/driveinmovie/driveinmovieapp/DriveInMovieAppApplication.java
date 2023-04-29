package org.jfs.driveinmovie.driveinmovieapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DriveInMovieAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriveInMovieAppApplication.class, args);
	}

}
