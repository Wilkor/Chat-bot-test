package br.com.wilkor.chatbot.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.wilkor.chatbot.model.SetData;


public interface MessageRepository extends CrudRepository<SetData, Long> {
	
	
}
