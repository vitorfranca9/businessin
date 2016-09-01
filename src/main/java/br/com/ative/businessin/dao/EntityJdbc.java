package br.com.ative.businessin.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@Service("entityJdbc")
public class EntityJdbc {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public EntityJdbc(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void test3() {
		try {
			DataSource dataSource = jdbcTemplate.getDataSource();
			Connection connection = dataSource.getConnection();
			DatabaseMetaData dbMetaData = connection.getMetaData();
			String catalog = getCatalog(connection, "test"); 
			
			ResultSet tables = dbMetaData.getTables("business-in", null, null, null); //TODO: continua conectando na 1a conexao definida
			while (tables.next()) {
				String ctlg = tables.getString(1);
				String tableName = tables.getString(3);
				String type = tables.getString(4);
				String idk = tables.getString(5);
				System.out.println(ctlg);
				System.out.println(tableName);
				System.out.println(type);
				System.out.println(idk);
//				Map<String, Object> queryMap = jdbcTemplate.queryForMap("select * from "+tableName); //unique result
				List<Map<String, Object>> queryForList = jdbcTemplate.queryForList("select * from "+tableName);
				for (Map<String, Object> queryMap : queryForList) {
					for (String key : queryMap.keySet()) {
						Object object = queryMap.get(key);
						System.out.println(object);
					}
				}
				System.out.println();
			}
//			catalogs.
			
//			BasicDataSource bds = new BasicDataSource();
//			bds.setDriver(new MysqlConnection);
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private String getCatalog(List<String> catalogs, String catalog) {
		String c = catalogs.stream().filter(t -> t.equals(catalog)).findFirst().get();
		return c;
	}
	
	private String getCatalog(Connection conn, String catalog) throws SQLException {
		List<String> catalogs = getCatalogs(conn);
		return getCatalog(catalogs, catalog);
	}
	
	private List<String> getCatalogs(Connection conn) throws SQLException {
		List<String> catalogs = new ArrayList<>();
		ResultSet rsCatalogs = conn.getMetaData().getCatalogs();
		String dataBaseName = "";
		while (rsCatalogs.next()) {
			dataBaseName = rsCatalogs.getString(1);
			catalogs.add(dataBaseName);
//			System.out.println(dataBaseName);
		}
		return catalogs;
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
			
//			DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/test", "root", "");
//			jdbcTemplate.setDataSource(driverManagerDataSource);
			MysqlDataSource mysqlDataSource = new MysqlDataSource();
			mysqlDataSource.setPassword("");
//			mysqlDataSource.setPort(3306);
			mysqlDataSource.setUrl("jdbc:mysql://localhost:3306");
			mysqlDataSource.setServerName("test");
			mysqlDataSource.setDatabaseName("test");
			mysqlDataSource.setPortNumber(3306);
			mysqlDataSource.setUser("root");
			
			DataSourceUtils.doCloseConnection(connection, jdbcTemplate.getDataSource());
			jdbcTemplate = new JdbcTemplate(mysqlDataSource);
			jdbcTemplate.setDataSource(mysqlDataSource);
			DataSource dataSource2 = jdbcTemplate.getDataSource();
			Connection doGetConnection = DataSourceUtils.doGetConnection(dataSource2);
			Connection getConnection = DataSourceUtils.getConnection(dataSource2);
			
//			String catalog2 = getCatalog(jdbcTemplate.getDataSource().getConnection());
//			String catalog3 = getCatalog(dataSource2.getConnection());
//			String catalog4 = getCatalog(getConnection);
//			String catalog5 = getCatalog(doGetConnection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
