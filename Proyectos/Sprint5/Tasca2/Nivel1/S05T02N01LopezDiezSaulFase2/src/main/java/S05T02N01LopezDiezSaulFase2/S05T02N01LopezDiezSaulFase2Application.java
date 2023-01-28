package S05T02N01LopezDiezSaulFase2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

public class S05T02N01LopezDiezSaulFase2Application {

	public static void main(String[] args) {
		SpringApplication.run(S05T02N01LopezDiezSaulFase2Application.class, args);
	}

}

