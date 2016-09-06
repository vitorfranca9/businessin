package br.com.ative.businessin.controller;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;

@Scope("view")
@Controller
public class IndexController2 implements Serializable {
	private static final long serialVersionUID = -8491598216913568452L;
	
	@Getter @Setter
	private String opa;
	
	@PostConstruct
	public void init() {
		opa = "coe";
		System.out.println("coe");
	}
	
	public String coe() {
		System.out.println("coe");
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//		Object session = FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if (sessionMap.containsKey("indexController2")) {
			sessionMap.remove("indexController2");
		}
//		FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		return null;
	}
	
}
