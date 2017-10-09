package com.ifes.sgpf.service;

import java.util.List;
import com.ifes.sgpf.dao.EmpresaDAO;
import com.ifes.sgpf.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 

@Service("empresaService")
public class EmpresaService {


	 @Autowired
	 EmpresaDAO empresaDao;
	 

	 @Transactional
	 public List getAllEmpresas() {
	  return empresaDao.getAllEmpresas();
	 }
	 
	 @Transactional
	 public Empresa getEmpresa(int id) {
	  return empresaDao.getEmpresa(id);
	 }
	 
	 @Transactional
	 public void addEmpresa(Empresa empresa) {
	  empresaDao.addEmpresa(empresa);
	 }
	 
	 @Transactional
	 public void updateEmpresa(Empresa empresa) {
		 empresaDao.updateEmpresa(empresa);
	 
	 }
	 
	 @Transactional
	 public void deleteEmpresa(int id) {
		 empresaDao.deleteEmpresa(id);
	 }
	
}//end_class...