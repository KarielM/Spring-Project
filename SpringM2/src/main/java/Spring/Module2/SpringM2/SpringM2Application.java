package Spring.Module2.SpringM2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringM2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringM2Application.class, args);
	}

}
