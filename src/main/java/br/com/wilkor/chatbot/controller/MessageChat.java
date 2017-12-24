package br.com.wilkor.chatbot.controller;

import java.util.UUID;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.wilkor.chatbot.Envelope.EnvelopeBlip;
import br.com.wilkor.chatbot.model.SetData;
import br.com.wilkor.chatbot.model.SetDataBack;
import br.com.wilkor.chatbot.repository.MessageRepository;
import br.com.wilkor.chatbot.repository.MessageRepositoryBack;
import br.com.wilkor.chatbot.services.ServiceHttp;
import br.com.wilkor.chatbot.services.ServiceMapper;


//definindo a rota
@RestController
@RequestMapping("msg")
public class MessageChat {

	private ServiceMapper serviceMapper;
	private ServiceHttp serviceHttp;
	private MessageRepository messageRepository;
	private MessageRepositoryBack messageRepositoryBack;
	
	
	@Inject
	public MessageChat(ServiceMapper serviceMapper, ServiceHttp serviceHttp, MessageRepository messageRepository, MessageRepositoryBack messageRepositoryBack) {

		this.serviceMapper = serviceMapper;
		this.serviceHttp = serviceHttp;
		this.messageRepository = messageRepository;
		this.messageRepositoryBack = messageRepositoryBack;
	}

	@RequestMapping(value = "/echo", method = RequestMethod.POST)
	public void messageResponse(@RequestBody String envelope) throws Exception {

		try {

			EnvelopeBlip from = serviceMapper.get().readValue(envelope, EnvelopeBlip.class);

			
			HttpStatus status = serviceHttp.post(from);

			messageRepository.save(new SetData(envelope));


			EnvelopeBlip to = new EnvelopeBlip();
			to.setTo(from.getFrom());
			to.setFrom(from.getTo());
			to.setId(UUID.randomUUID().toString());
			to.setContent(from.getContent());
			to.setType(from.getType());

			status = serviceHttp.post(to);

			messageRepositoryBack.save(new SetDataBack(to.toString()));

			if (status != HttpStatus.ACCEPTED) {

			}

		} catch (Exception e) {

		}

	}

}
