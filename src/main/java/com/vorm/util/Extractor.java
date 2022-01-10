package com.vorm.util;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import com.vorm.annotations.Column;

/**
 * This will take a class and extract Field names/ column names and values
 * 
 * @author viralbhavsar
 *
 */
public class Extractor {
	private List<String> columnNames;
	private List<?> columnValues;

	public void getColumns(Object clazz) {

		Field[] fields = clazz.getClass().getDeclaredFields();

		List<String> fieldsString = new LinkedList<>();
		fieldsString.add(clazz.getClass().getDeclaredFields().toString());

		for (Field f : fields) {
		
			if (f.isAnnotationPresent(Column.class)) {
//				System.out.println(f.getAnnotation(Column.class).columnName());
				fieldsString.add(f.getAnnotation(Column.class).columnName());
				System.out.println(clazz.getClass());
			}
			
		}

		for (String s : fieldsString) {
			System.out.println(s);
		}

	}

}
