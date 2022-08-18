package com.academy.beca.rest;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class FunRestController {
	
	@GetMapping("/Saludar")
	@ResponseBody
	public String saludar(@RequestParam("name") String nombre) {
		return "Hola " + nombre + " " + LocalDateTime.now();
	}
	
}
