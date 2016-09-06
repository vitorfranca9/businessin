package br.com.ative.businessin.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;

@SessionScoped
@Controller
public class IndexController implements Serializable {
	private static final long serialVersionUID = -1764062855666696929L;
	
	@Getter @Setter
	private String opa;
	
	@PostConstruct
	public void init() {
		opa = "coe";
		System.out.println("coe");
	}
	
	public String coe() {
		System.out.println("coe");
		return null;
	}
	
}
