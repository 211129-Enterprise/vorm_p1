package com.vorm.sql;

import java.util.List;

import com.vorm.util.Configuration;
import com.vorm.util.MetaModel;

// Responsible for taking cfg object and executing it
public class Execute {
	Tables tables = new Tables();
	
	public void execute(Configuration cfg ){
//		System.out.println("attempting to connect to db");
//		com.vorm.sql.ConnectionUtil.getConnection();
		
		
		// need to know what is in the cfg
		
		for (MetaModel<?> metamodel : cfg.getMetaModels()) {
			tables.createTable(metamodel);
			
		}
		
		
	}
	
	
}
