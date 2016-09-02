package br.com.ative.businessin.vo;

import java.util.List;

import br.com.ative.businessin.enums.ColumnTypeEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(of="name")
public class ColumnVO {
//	TODO valuetype deve ficar em column e nao value
	@Getter @Setter private String name;
	@Getter @Setter private TableVO table;
	@Getter @Setter private ColumnTypeEnum type;
	@Getter @Setter private List<ValueVO> values;
	
}
