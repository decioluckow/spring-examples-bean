package br.com.decioluckow.springexamples.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.decioluckow.springexamples.dao.ClientDao;
import br.com.decioluckow.springexamples.dao.ClientDaoImpl;
import br.com.decioluckow.springexamples.service.ClientService;
import br.com.decioluckow.springexamples.service.ClientServiceImpl;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public ClientService clientService1() {
		ClientServiceImpl clientService = new ClientServiceImpl();
		clientService.setName("instancia client service 1");
		clientService.setClientDao(clientDao()); 
		return clientService;
	}

	@Bean
	public ClientService clientService2() {
		ClientServiceImpl clientService = new ClientServiceImpl();
		clientService.setName("instancia client service 2");
		clientService.setClientDao(clientDao());
		return clientService;
	}
	
	@Bean(initMethod="init", destroyMethod="destroy")
	public ClientService clientService3(final @Qualifier("clientDao") ClientDao clientDaoDois) {
		ClientServiceImpl clientService = new ClientServiceImpl();
		clientService.setName("instancia client service 3");
		clientService.setClientDao(clientDaoDois);
		return clientService;
	}
	
	@Bean
	public ClientDao clientDao() {
		return new ClientDaoImpl();
	}
	
	@Bean
	public ClientDao clientDao3() {
		return new ClientDaoImpl();
	}
}