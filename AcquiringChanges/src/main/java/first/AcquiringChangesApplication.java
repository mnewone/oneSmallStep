package first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sybase.jdbc4.*;

@SpringBootApplication
public class AcquiringChangesApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(AcquiringChangesApplication.class);
	
	@Autowired
	JdbcTemplate myJdbcTemplate;
	
	@Bean
	public DriverManagerDataSource myDataSource() {
		DriverManagerDataSource myDs = new DriverManagerDataSource();
		myDs.setDriverClassName("com.sybase.jdbc4.jdbc.SybDriver");
		myDs.setUrl("jdbc:sybase:Tds:10.53.9.3:4074/mifid2_feed");
		myDs.setUsername("mifid2_feed");
		myDs.setPassword("mifid2_feed");
		return myDs;
	}
	
	@Bean
	public JdbcTemplate myJdbcTemplate(DriverManagerDataSource drManagerDataSource) {
		JdbcTemplate myJdbc = new JdbcTemplate();
		myJdbc.setDataSource(drManagerDataSource);
		return myJdbc;
	}

	public static void main(String[] args) {
		SpringApplication.run(AcquiringChangesApplication.class, args);
	}
	
	@Override
	public void run (String... strings) throws Exception {
		log.info("Start to acqure changes from table ...");
		
	}
}
