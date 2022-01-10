package com.vorm.sql;

import com.vorm.util.MetaModel;

/**
 * Used to insert data into exsisting tables
 * @author viralbhavsar
 *
 */
public class Insert {
	
	int insert (MetaModel<?> metaModel) {
		
		/**
		 * INSERT INTO student (student_name, student_last_name, pin) VALUES ('viral', 'bhavsar', 123) RETURNING student_id;
		 */
		
		String tableName = metaModel.getSimpleClassName().toLowerCase();
		
		System.out.println(tableName);
		
		return 0;
	}

}
