package com.vorm.sql;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

//import com.sun.xml.internal.stream.Entity;
import com.vorm.annotations.Id;
import com.vorm.util.ColumnField;
import com.vorm.util.MetaModel;

// Responsible for creating, altering tables
public class Tables {

	// grab a conection
//	Connection conn = ConnectionUtil.getConnection();
	SqlUtil simpleSql = new SqlUtil();

	// make a db call

//	String sql = "drop table if exists ? cascade;\r\n" + "create table students ();";

	void createTable(MetaModel<?> metaModel) {

		/**
		 * need - table name - filed name, type,
		 */
		String tableName = metaModel.getSimpleClassName().toLowerCase();

//		for (ColumnField c : metaModel.getColumns()) {
//			System.out.println(c.getColumnName());
//		}

		String pkName = metaModel.getPrimaryKey().getColumnName().toLowerCase();
		
		List<String> cNames = new LinkedList<>();
		List<String> cTypes = new LinkedList<>();
		
		for (ColumnField f : metaModel.getColumns()) {
			String col = f.getColumnName();
			String typ = "";
			
			
			
			if ((f.getType().toString().length() > 16) && (f.getType().toString()).substring(16).equals(new String("String"))) {
				typ = "VARCHAR(255)";
			} else {
				typ = "NUMERIC";
			}
//			System.out.println("col " + col + " typ " + typ+ "\n");
			
			cNames.add(col);
			cTypes.add(typ);
		}
		
		
		String columdatasql = "";
		for (int i =0; i < cNames.size(); i++) {
			columdatasql = columdatasql + cNames.get(i) + " " + cTypes.get(i) + ", "; 
		}
		
//		System.out.println(columdatasql.substring(0, columdatasql.length()-2));
		
		String sqlCol = columdatasql.substring(0, columdatasql.length()-2);
		
//		metaModel.getClass().getEntityColumnName();
		
//		System.out.println("tableName \t" + tableName);
//		System.out.println("pkName \t\t" + pkName);
		
		String isCascade = "";
		String dropT = "";
		
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("/Users/viralbhavsar/Documents/vorm_p1/src/main/resources/application.properties"));
			 isCascade = prop.getProperty("cascade");
	
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
		if (isCascade.equals(new String ("true"))) {
			dropT = "drop table if exists " + tableName + " cascade; ";
		}
		
		String createT = "CREATE TABLE " + tableName + " ( " +pkName + " SERIAL PRIMARY KEY " +(cNames.size() > 0 ? " ," : " ")  + sqlCol + " );";
		
//		System.out.println(createT);
		
		simpleSql.sendsql(createT);
		
	
	}

}