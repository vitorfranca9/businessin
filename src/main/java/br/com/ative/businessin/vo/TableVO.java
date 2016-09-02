package br.com.ative.businessin.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class TableVO {
	
	@Getter @Setter private String name;
	@Getter @Setter private List<ColumnVO> columns;
	@Getter @Setter private List<ValueVO> values;

}
