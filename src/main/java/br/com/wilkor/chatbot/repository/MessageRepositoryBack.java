package br.com.wilkor.chatbot.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.wilkor.chatbot.model.SetDataBack;



public interface MessageRepositoryBack extends CrudRepository<SetDataBack, Long> {
	
	
}
