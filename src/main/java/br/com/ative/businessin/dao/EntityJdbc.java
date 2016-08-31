package br.com.ative.businessin.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("entityJdbc")
public class EntityJdbc {

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public EntityJdbc(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void test2() {
		
		try {
			Connection connection = jdbcTemplate.getDataSource().getConnection();
			String catalog = connection.getCatalog();
			Properties clientInfo = connection.getClientInfo();
			int holdability = connection.getHoldability();
			int networkTimeout = connection.getNetworkTimeout();
			String schema = connection.getSchema();
			int transactionIsolation = connection.getTransactionIsolation();
			Map<String, Class<?>> typeMap = connection.getTypeMap();
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void test3() {
		try {
			DataSource dataSource = jdbcTemplate.getDataSource();
			Connection connection = dataSource.getConnection();
			DatabaseMetaData dbMetaData = connection.getMetaData();
			ResultSet catalogs = dbMetaData.getCatalogs();
			catalogs.next();
			String string1 = catalogs.getString(1);
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private String getDataBaseName() throws SQLException {
		DataSource dataSource = jdbcTemplate.getDataSource();
		Connection connection = dataSource.getConnection();
		DatabaseMetaData dbMetaData = connection.getMetaData();
		ResultSet catalogs = dbMetaData.getCatalogs();
		catalogs.next();
		String dataBaseName = catalogs.getString(1);
		return dataBaseName;
	}
	
	public void test() {
		try {
			DataSource dataSource = jdbcTemplate.getDataSource();
			Connection connection = dataSource.getConnection();
			DatabaseMetaData dbMetaData = connection.getMetaData();
			ResultSet schemas = dbMetaData.getSchemas();
			
//			while (!schemas.last()) {
				ResultSetMetaData rsMetaData = schemas.getMetaData();
				int columnCount = rsMetaData.getColumnCount();
				
				String c1 = rsMetaData.getCatalogName(1);
				String c2 = rsMetaData.getCatalogName(2);
				
				int columnDisplaySize = rsMetaData.getColumnDisplaySize(1);
				
				String columnName = rsMetaData.getColumnName(1);
				
				String columnTypeName = rsMetaData.getColumnTypeName(1);
				
				String s1 = rsMetaData.getSchemaName(1);
				String s2 = rsMetaData.getSchemaName(1);
				
				String columnClassName = rsMetaData.getColumnClassName(1);
				
				String columnLabel = rsMetaData.getColumnLabel(1);
				
				int columnType = rsMetaData.getColumnType(1);
				
				int precision = rsMetaData.getPrecision(1);
				
				int scale = rsMetaData.getScale(1);
				
				String tableName = rsMetaData.getTableName(1);
				
//				rsMetaData.columnNoNulls;
//				rsMetaData.columnNullable;
//				rsMetaData.columnNullableUnknown;
				
				System.out.println();
//				String string1 = schemas.getString(1);
//				String string2 = schemas.getString(2);
//				String string3 = schemas.getString(3);
//				String string4 = schemas.getString(4);
//				String string5 = schemas.getString(5);
//				for (int i = 0; i < columnCount; i++) {
//					String schemaName = rsMetaData.getSchemaName(i);
//					System.out.println(schemaName);
//				}
//			}
			
//			jdbcTemplate.query("select * from testevo", n)
			List<Map<String, Object>> queryForList = jdbcTemplate.queryForList("select * from testevo");
//			for (Map<String, Object> map : queryForList) {
//				for (String key : map.keySet()) {
//					Object object = map.get(key);
//					System.out.println(object);
//				}
//			}
			
//			ResultSet tables = dbMetaData.getTables(null, "business-in", null, null);
//			ResultSet tables = dbMetaData.getTables("def", "business-in", "testevo", new String[]{"BASE TABLE"});
//			while (tables.)
			ResultSet tables = dbMetaData.getTables(null, null, "testevo", null);
			
			ResultSetMetaData tbMetaData = tables.getMetaData();
			
			int count = tbMetaData.getColumnCount();
//			for (int i = 0; i < count; i++) {
//				String schemaName = tbMetaData.getSchemaName(i);
//				System.out.println(schemaName);
//				String tableName = tbMetaData.getTableName(i);
//				System.out.println(tableName);
//			}
//			while (tables.next()) {
//				System.out.println(metaData2);
//			}
			
			System.out.println(tables);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
