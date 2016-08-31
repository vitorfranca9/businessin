package br.com.ative.businessin.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class TesteVO implements IEntityVO {
	private static final long serialVersionUID = -2527199084970927784L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idteste")
	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
	private String descricao;
	
}
