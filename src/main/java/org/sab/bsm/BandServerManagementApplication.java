package org.sab.bsm;

import org.sab.bsm.configuration.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@Import({ WebConfig.class })
public class BandServerManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BandServerManagementApplication.class, args);
	}

}
