package br.com.wilkor.chatbot.services;



import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.wilkor.chatbot.Envelope.EnvelopeBlip;

	@Service
	public class ServiceHttp {
		
		
		
		private RestTemplate restTemplate;

		@Autowired
		public ServiceHttp(RestTemplate restTemplate) {
			this.restTemplate = restTemplate;
		}
           
		public HttpStatus post(EnvelopeBlip envelope) {
			
			HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.set("Authorization","Key dGVzdGV3aWxrb3I6MTROVjhJdEdnalJza3Q5YW9jVGs=");

	        HttpEntity<EnvelopeBlip> entity = new HttpEntity<EnvelopeBlip>(envelope, headers);
	        
	

	        ResponseEntity<Object> response = restTemplate.postForEntity("https://msging.net/messages", entity, Object.class);
	        
	        return response.getStatusCode();
		}

}
	


