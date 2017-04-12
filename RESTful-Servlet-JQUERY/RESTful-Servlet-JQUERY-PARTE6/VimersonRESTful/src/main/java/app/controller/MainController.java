package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Esse controlador não é um RestController 
public class MainController {
	
	//Aqui estamos mapeando a requisição da raiz
	@RequestMapping(value="/")
	public String raiz(){
		return "forward:/cliente.html";
	}
}
