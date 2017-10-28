package br.com.decioluckow.springexamples.service;

public interface ClientService {
	
	void setName(final String name);
	String getName();
	
	void printDependencies();
	
	void init();
	
	void destroy();

}
