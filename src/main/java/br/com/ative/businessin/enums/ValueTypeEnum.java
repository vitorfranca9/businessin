package br.com.ative.businessin.enums;

import java.util.Date;

public enum ValueTypeEnum {
	STRING,
	INTEGER,
	DOUBLE,
	DATE,
	BINARY;
	
	public static ValueTypeEnum getValueType(Object obj) {
		if (obj != null) {
			if (obj instanceof Integer) {
				return ValueTypeEnum.INTEGER;
			} else if (obj instanceof String) {
				return ValueTypeEnum.STRING;
			} else if (obj instanceof Double) {
				return ValueTypeEnum.DOUBLE;
			} else if (obj instanceof Date) {
				return ValueTypeEnum.DATE;
			}
			throw new RuntimeException("ValueType not mapped");
		}
		return null;
	}
}
