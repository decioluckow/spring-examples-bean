package br.com.decioluckow.springexamples.service;

import br.com.decioluckow.springexamples.dao.ClientDao;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientServiceImpl implements ClientService {
	
	@Getter
	@Setter
	private ClientDao clientDao;

	private String name;
	
	@Override
	public void init() {
		log.info("initializing=" + name);
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void printDependencies() {
		log.info("clientDao=" + clientDao);
	}
	
	@Override
	public void destroy() {
		log.info("destroying=" + name);
	}

}
