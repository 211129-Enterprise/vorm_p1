package com.vorm.sql;

import java.util.List;

import com.vorm.util.ColumnField;
import com.vorm.util.MetaModel;

/**
 * Used to insert data into exsisting tables
 * @author viralbhavsar
 *
 */
public class Insert {
	
	int insert (Class<?> clazz) {
		
		/**
		 * INSERT INTO student (student_name, student_last_name, pin) VALUES ('viral', 'bhavsar', 123) RETURNING student_id;
		 */
		
		
		List<ColumnField> columnFields;
		
		
	
		
		System.out.println(tableName);
		
		return 0;
	}

}
