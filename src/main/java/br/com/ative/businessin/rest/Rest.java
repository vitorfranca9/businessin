package br.com.ative.businessin.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ative.businessin.dao.EntityDAO;
import br.com.ative.businessin.dao.EntityJdbc;

@RestController
public class Rest {

//	@Autowired
//	private EntityDAO entityDAO;
	
	@Autowired
	private EntityJdbc entityJdbc;
	
	@RequestMapping("test/{oe}")
	public String oe(@PathVariable String oe) {
		entityJdbc.test();
		return "Coe " +oe;
	}
	
	@RequestMapping("test2/{oe}")
	public String oe2(@PathVariable String oe) {
		entityJdbc.test2();
		return "Coe " +oe;
	}
	
	@RequestMapping("test3/{oe}")
	public String oe3(@PathVariable String oe) {
		entityJdbc.test3();
		return "Coe " +oe;
	}
	
}
