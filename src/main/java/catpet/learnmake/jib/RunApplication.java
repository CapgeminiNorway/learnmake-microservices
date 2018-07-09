package catpet.learnmake.jib;

import catpet.learnmake.jib.config.AppContextInitializer;
import catpet.learnmake.jib.config.MainConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MainConfig.class)
public class RunApplication implements CommandLineRunner {

	/* public static void main(String[] args) {
		SpringApplication.run(RunApplication.class, args);
	} */
	private Logger logger = LoggerFactory.getLogger(RunApplication.class);

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
		sb = sb.length() == 0 ? sb.append("No Options Specified") : sb;
		logger.info(String.format("WAR launched with following options: %s", sb.toString()));
	}
}