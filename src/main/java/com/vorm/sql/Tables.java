package com.vorm.sql;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

import com.vorm.util.ColumnField;
import com.vorm.util.MetaModel;


// Responsible for creating, altering tables
public class Tables {

	// grab a conection
	Connection conn = ConnectionUtil.getConnection();
	
	
	// make a db call
	
	String sql = "drop table if exists ? cascade;\r\n"
			+ "create table students ();";
	
	void createTable (MetaModel<?> metaModel) {
		
		/**
		 * need
		 * - table name
		 * - filed name, type, 
		 */
		
		String tableName = metaModel.getSimpleClassName();
		
		List <FieldType> fieldType = new LinkedList<>();
		
		for (ColumnField columns : metaModel.getColumns()) {
			String columnName = columns.getColumnName();
			String columnType = columns.getType().toString();
			
			fieldType.add(new FieldType(columnName, columnType));
			
		
		}
		
		System.out.println("+++++++++");
		for (FieldType ft : fieldType) {
			System.out.println(ft.getColumnName()+ " " + ft.getDataType());
			
		}
	}
	
	
}
