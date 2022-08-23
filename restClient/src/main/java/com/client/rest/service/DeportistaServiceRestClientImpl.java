package com.client.rest.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.client.rest.model.Deportista;

@Service
public class DeportistaServiceRestClientImpl implements DeportistaService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public DeportistaServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Deportista> getDeportistas() {
		
		logger.info("***OBTENER LISTA DE DEPORTISTAS DESDE EL SERVICE REST CLIENTE");
		logger.info("in getDeportistas(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Deportista>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
													 new ParameterizedTypeReference<List<Deportista>>() {});

		// get the list of deportistas from response
		List<Deportista> deportistas = responseEntity.getBody();

		logger.info("in getDeportistas(): deportistas" + deportistas);
		
		return deportistas;
	}

	@Override
	public Deportista getDeportista(int theId) {
		logger.info("***OBTENER UN DEPORTISTA DESDE EL SERVICE REST CLIENTE");

		logger.info("in getDeportista(): Calling REST API " + crmRestUrl);

		// make REST call
		Deportista theDeportista = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
						Deportista.class);

		logger.info("in saveDeportista(): theDeportista=" + theDeportista);
		
		return theDeportista;
	}

	@Override
	public void saveDeportista(Deportista theDeportista) {

		logger.info("in saveDeportista(): Calling REST API " + crmRestUrl);
		
		int deportistaId = theDeportista.getId();

		// make REST call
		if (deportistaId == 0) {
			// add employee
			logger.info("***SALVAR UN DEPORTISTA DESDE EL SERVICE REST CLIENTE");

			restTemplate.postForEntity(crmRestUrl, theDeportista, String.class);			
		
		} else {
			// update deportista
			logger.info("***ACTUALIZAR UN DEPORTISTA DESDE EL SERVICE REST CLIENTE");

			restTemplate.put(crmRestUrl, theDeportista);
		}

		logger.info("in saveDeportista(): success");	
	}

	@Override
	public void deleteDeportista(int theId) {
		logger.info("***BORRAR UN DEPORTISTA DESDE EL SERVICE REST CLIENTE");

		logger.info("in deleteDeportista(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteDeportista(): deleted deportista theId=" + theId);
	}

}
