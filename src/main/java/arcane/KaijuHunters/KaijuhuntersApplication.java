package arcane.KaijuHunters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import arcane.KaijuHunters.account.PasswordSecurity;


@SpringBootApplication
@EnableScheduling
public class KaijuhuntersApplication {
	public static void main(String[] args) {
		SpringApplication.run(KaijuhuntersApplication.class, args);
	}

}
