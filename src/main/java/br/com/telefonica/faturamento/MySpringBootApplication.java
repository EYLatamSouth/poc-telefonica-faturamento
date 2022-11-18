package br.com.telefonica.faturamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

import com.microsoft.applicationinsights.attach.ApplicationInsights;

@EnableKafka
@SpringBootApplication
public class MySpringBootApplication {

    /**
     * A main method to start this application.
     */
    public static void main(String[] args) {
    	
    	ApplicationInsights.attach();
    	
        SpringApplication.run(MySpringBootApplication.class, args);
    }

}
