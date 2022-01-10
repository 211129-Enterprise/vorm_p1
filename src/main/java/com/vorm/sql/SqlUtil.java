package com.vorm.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//import org.apache.log4j.Logger;

//import com.revature.dao.UsersDAO;
import com.vorm.sql.ConnectionUtil;

public class SqlUtil  {
//	private static Logger logger = Logger.getLogger(UsersDAO.class);

	// Takes simple sql query returning null and executes it against the dat
	public void sendsql (String sql) {
		try {
			Connection dbconnection = ConnectionUtil.getConnection();
			
			Statement stmt = dbconnection.createStatement();
			stmt.execute(sql);
		} catch (SQLException se) {
//			logger.info(se);
		}
	}

	
	public ResultSet sqlReply (String sql) {
		try {
			Connection dbconnection = ConnectionUtil.getConnection();
			
			Statement stmt = dbconnection.createStatement();
			ResultSet sqlReply = stmt.executeQuery(sql);
			if (sqlReply == null) {
				System.out.println("\nSqlUtil.sqlReply didn't return any data");
			}
			return sqlReply;
		} catch (SQLException se) {
//			logger.info(se);
		}
		return null;
	}
	
	// Print ResultSet
	
	public  void printResultSet (ResultSet resultSet) throws SQLException {
		ResultSetMetaData rsmd = resultSet.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (resultSet.next()) {
		    for (int i = 1; i <= columnsNumber; i++) {
		        if (i > 1) System.out.print(",  ");
		        String columnValue = resultSet.getString(i);
		        System.out.print(columnValue + " " + rsmd.getColumnName(i));
		    }
		    System.out.println("");
		}
	}

}
