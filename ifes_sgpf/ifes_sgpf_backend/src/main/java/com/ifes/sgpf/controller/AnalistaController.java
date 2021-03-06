package com.ifes.sgpf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ifes.sgpf.model.Analista;
import com.ifes.sgpf.service.AnalistaService;


@Controller
public class AnalistaController {


	@Autowired
	AnalistaService analistaService;


	@RequestMapping(value = "/analistas", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getAnalistas(Model model) {
		
		List listOfAnalistas = analistaService.getAllAnalistas();
		model.addAttribute("analista", new AnalistaService());
		model.addAttribute("listOfAnalistas", listOfAnalistas);
		return "analistaDetails";
	}

	 
	@RequestMapping(value = "/analista/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Analista getAnalistaById(@PathVariable int id) {
		
		return analistaService.getAnalista(id);
	}


	@RequestMapping(value = "/addAnalista", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addAnalista(@ModelAttribute("analista") Analista analista) {
		
		if(analista.getId() == 0){
			analistaService.addAnalista(analista);
		}
		else{			
			analistaService.updateAnalista(analista);
		}
		
		return "redirect:/analistas";
	}

		
	@RequestMapping(value = "/updateAnalista/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateAnalista(@PathVariable("id") int id, Model model) {
		
		 model.addAttribute("analista", this.analistaService.getAnalista(id));
		 
	        model.addAttribute("listOfAnalistas", this.analistaService.getAllAnalistas());
	        return "AnalistaDetails";
	}
 
	@RequestMapping(value = "/deleteAnalista/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteAnalista(@PathVariable("id") int id) {
		
		analistaService.deleteAnalista(id);
		
		 return "redirect:/analistas";
 
	}
	
}//end_class...
