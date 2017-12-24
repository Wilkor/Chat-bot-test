package br.com.wilkor.chatbot;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
@EnableAutoConfiguration
public class ApplicationChat {

	public static void main(String[] args) {

		SpringApplication.run(ApplicationChat.class, args);

	}
	
	
	
	 @Bean
	    public DataSource dataSource(Environment environment) {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
	        dataSource.setUrl("jdbc:mariadb://localhost:3306/message");
	        dataSource.setUsername("root");
	        dataSource.setPassword("juliette");
	        return dataSource;
	    }
	 
  
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(clientHttpRequestFactory());
    }

    
    private ClientHttpRequestFactory clientHttpRequestFactory() {
    	
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(20000);
        factory.setConnectTimeout(20000);
        return factory;
    }

}
