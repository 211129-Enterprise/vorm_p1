package com.vorm.sql;

import java.util.Objects;

public class FieldType {

	String columnName;
	String dataType;
	public FieldType(String columnName, String dataType) {
		super();
		this.columnName = columnName;
		this.dataType = dataType;
//		if (dataType.toString() == "String") {
//			this.dataType = "VARCHAR(255)";
//		}
//		
//		if (dataType.toString().equals("int") || dataType == "long") {
//			this.dataType = "NUMBER";
//		}
	}
	public String getColumnName() {
		return columnName;
	}

	public String getDataType() {
		return dataType;
	}

	@Override
	public String toString() {
		return "FieldType [columnName=" + columnName + ", dataType=" + dataType + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(columnName, dataType);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FieldType other = (FieldType) obj;
		return Objects.equals(columnName, other.columnName) && Objects.equals(dataType, other.dataType);
	}
	
	
	
	
}
