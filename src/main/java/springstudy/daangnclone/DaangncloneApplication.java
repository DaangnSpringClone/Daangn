package springstudy.daangnclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DaangncloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaangncloneApplication.class, args);
	}

}
