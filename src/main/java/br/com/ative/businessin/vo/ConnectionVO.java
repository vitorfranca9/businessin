package br.com.ative.businessin.vo;

import lombok.Getter;
import lombok.Setter;

public class ConnectionVO {
	
	@Getter @Setter private String name;
	@Getter @Setter private String url;
	@Getter @Setter private String user;
	@Getter @Setter private String password;

}
