package br.com.decioluckow.springexamples;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import br.com.decioluckow.springexamples.service.ClientService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringExamplesApplication {
	
	@Autowired
	private ApplicationContext ctx;
	
	@Autowired
	private ClientService clientService1;
	
	@Autowired
	private ClientService clientService2;
	
	@Autowired
	@Qualifier("clientService2")
	private ClientService clientServiceDois;

	@Autowired
	private ClientService clientService3;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringExamplesApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		log.info("clientService1= " + clientService1 + " (" + clientService1.getName() + ")");
		clientService1.printDependencies();
		log.info("clientService2= " + clientService2 + " (" + clientService2.getName() + ")");
		clientService2.printDependencies();
		log.info("clientServiceDois= " + clientServiceDois + " (" + clientServiceDois.getName() + ")");
		clientServiceDois.printDependencies();
		log.info("clientService3= " + clientService3 + " (" + clientService3.getName() + ")");
		clientService3.printDependencies();
		
	}
}
