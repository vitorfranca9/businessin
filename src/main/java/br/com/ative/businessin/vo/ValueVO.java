package br.com.ative.businessin.vo;

import br.com.ative.businessin.enums.ValueTypeEnum;
import lombok.Getter;
import lombok.Setter;

public class ValueVO {
	@Getter @Setter private Object value;
	@Getter @Setter private ValueTypeEnum type;
	@Getter @Setter private ColumnVO column;
}
