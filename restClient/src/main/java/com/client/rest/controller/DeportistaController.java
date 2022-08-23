package com.client.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.client.rest.model.Deportista;
import com.client.rest.service.DeportistaService;

@Controller
@RequestMapping("/deportista")
public class DeportistaController {

	// need to inject our deportista service
	@Autowired
	private DeportistaService deportistaService;
	
	@GetMapping("/list")
	public String listDeportistas(Model theModel) {
		
		// get deportistas from the service
		List<Deportista> theDeportistas = deportistaService.getDeportistas();
				
		// add the deportistas to the model
		theModel.addAttribute("deportistas", theDeportistas);
		
		return "list-deportistas";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Deportista theDeportista = new Deportista();
		
		theModel.addAttribute("deportista", theDeportista);
		
		/**
		 * JSP
		 */
		return "deportista-form";
	}
	
	//Aqui continuar
	@PostMapping("/saveDeportista")
	public String saveDeportista(@ModelAttribute("deportista") Deportista theDeportista) {
		
		// save the Deportista using our service
		deportistaService.saveDeportista(theDeportista);	
		
		return "redirect:/deportista/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("deportistaId") int theId,
									Model theModel) {
		
		// get the deportista from our service
		Deportista theDeportista = deportistaService.getDeportista(theId);	
		
		// set deportista as a model attribute to pre-populate the form
		theModel.addAttribute("deportista", theDeportista);
		
		// send over to our form		
		return "deportista-form";
	}
	
	@GetMapping("/delete")
	public String deleteDeportista(@RequestParam("deportistaId") int theId) {
		
		// delete the deportista
		deportistaService.deleteDeportista(theId);
		
		return "redirect:/deportista/list";
	}
}
