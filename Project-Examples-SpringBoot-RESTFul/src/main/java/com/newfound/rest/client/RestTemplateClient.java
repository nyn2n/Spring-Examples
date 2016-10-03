/**
 * Copyright NEWFOUND SYSTEMS to Present
 * All Rights Reserved
 */
package com.newfound.rest.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.client.RestTemplate;

import com.newfound.rest.server.model.Person;

public class RestTemplateClient implements RestClientConstants {

	static final Logger log = LoggerFactory.getLogger(RestTemplateClient.class);

	/**
	 * Get Http Information from ResponseEntity
	 * 
	 * @param <T>
	 */
	private <T> void getHttpResponseInfo(ResponseEntity<T> responseEntity) {
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		
		System.out.println("ContentType: " + contentType);
		System.out.println("StatusCode: " + statusCode);
	}

	/**
	 * Exchange with RESTful Web Service as Client
	 */
	private void exchange() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		/**
		 * Authorization Encode in Base64
		 */
		headers.add("Authorization", "Basic " + new String(Base64.encode((USER + ":" + PASSWORD).getBytes())));
		/**
		 * Find by ID
		 */
		{
			HttpEntity<Person> requestEntity = new HttpEntity<Person>(headers);
			String resourceUrl = REST_SERVICE_URL + FIND_BY_ID + "." + ResponseFormat.XML.getFormat();
			ResponseEntity<Person> responseEntity = restTemplate.exchange(resourceUrl, HttpMethod.GET, requestEntity,
					new ParameterizedTypeReference<Person>() {
					});
			Person person = responseEntity.getBody();
			log.info("\n" + person.toString());

			getHttpResponseInfo(responseEntity);
		}
		/**
		 * Create Person
		 */
		{
			HttpEntity<Person> requestEntity = new HttpEntity<Person>(headers);
			String resourceUrl = REST_SERVICE_URL + CREATE;
			ResponseEntity<Person> responseEntity = restTemplate.exchange(resourceUrl, HttpMethod.POST, requestEntity,
					new ParameterizedTypeReference<Person>() {
					});
			Person person = responseEntity.getBody();
			log.info("\n" + person.toString());
		}
		/**
		 * Find By GENDER (MALE)
		 */
		{
			log.info("\n");
			HttpEntity<List<Person>> requestEntity = new HttpEntity<List<Person>>(headers);
			String resourceUrl = REST_SERVICE_URL + FIND_BY_GENDER_MALE;

			ResponseEntity<List<Person>> responseEntity = restTemplate.exchange(resourceUrl, HttpMethod.GET, requestEntity,
					new ParameterizedTypeReference<List<Person>>() {
					});
			List<Person> persons = (List<Person>) responseEntity.getBody();
			for (Person person : persons) {
				log.info(person.toString());
			}
			getHttpResponseInfo(responseEntity);
		}
	}

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new RestTemplateClient().exchange();
	}
}
