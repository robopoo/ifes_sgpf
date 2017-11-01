package com.ifes.sgpf.controller;

import java.util.List;
 
import com.ifes.sgpf.model.Empresa;
import com.ifes.sgpf.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EmpresaController {


	@Autowired
	EmpresaService empresaService;
	
	
	
	@RequestMapping(value = "/empresas", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getEmpresas(Model model) {
		
		List listOfCountries = empresaService.getAllEmpresas();
		model.addAttribute("empresa", new Empresa());
		model.addAttribute("listOfEmpresas", listOfCountries);
		return "empresaDetails";
	}
 
	@RequestMapping(value = "/empresa/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Empresa getEmpresaById(@PathVariable int id) {
		return empresaService.getEmpresa(id);
	}

	
	@RequestMapping(value = "/addEmpresa", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addEmpresa(@ModelAttribute("empresa") Empresa empresa) {
		
		if(empresa.getId() == 0){
			empresaService.addEmpresa(empresa);
		}
		else{
			
			empresaService.updateEmpresa(empresa);
		}
		
		return "redirect:/empresas";
	}
 
	@RequestMapping(value = "/updateEmpresa/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateEmpresa(@PathVariable("id") int id,Model model) {
		
		 model.addAttribute("empresa", this.empresaService.getEmpresa(id));
		 
	        model.addAttribute("listOfEmpresas", this.empresaService.getAllEmpresas());
	        return "empresaDetails";
	}
 
	@RequestMapping(value = "/deleteEmpresa/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteEmpresa(@PathVariable("id") int id) {
		
		empresaService.deleteEmpresa(id);
		
		 return "redirect:/empresas";
 
	}	
	
}//end_class...