package learnmake.microservices;

import learnmake.microservices.config.AppContextInitializer;
import learnmake.microservices.config.MainConfig;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication
@Import(MainConfig.class)
public class RunApplication implements CommandLineRunner {

	@Autowired
	Environment environment;

	public static void main(String[] args) {
		new SpringApplicationBuilder(RunApplication.class)
				.initializers(new AppContextInitializer())
				.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		StringBuilder sb = new StringBuilder();
		for (String option : args) {
			sb.append(" ").append(option);
		}
		sb = sb.length() == 0 ? sb.append("No extra options specified") : sb;
		log.info(String.format("APP launched with options: %s", sb.toString()));
	}
}