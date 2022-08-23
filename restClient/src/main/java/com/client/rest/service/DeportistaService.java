package com.client.rest.service;

import java.util.List;
import com.client.rest.model.Deportista;

public interface DeportistaService {

	public List<Deportista> getDeportistas();

	public void saveDeportista(Deportista theDeportista);

	public Deportista getDeportista(int theId);

	public void deleteDeportista(int theId);
	
}
