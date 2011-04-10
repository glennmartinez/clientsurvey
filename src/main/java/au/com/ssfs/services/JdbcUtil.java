package au.com.ssfs.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.informix.jdbcx.IfxDataSource;


public class JdbcUtil {

	private static Logger logger = LoggerFactory.getLogger(JdbcUtil.class);

	private static String driverClassName;
	private static String url;
	private static String username;
	private static String password;

	static {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		driverClassName = bundle.getString("jdbc.driverClassName");
		url = bundle.getString("jdbc.url");
		username = bundle.getString("jdbc.username");
		password = bundle.getString("jdbc.password");
	}

	public static Connection getConnection() throws SQLException {
		logger.debug("Getting connection.");
		return JdbcUtil.getDataSource().getConnection(username, password);
	}

	public static DataSource getDataSource() throws SQLException {
		IfxDataSource dataSource = new IfxDataSource();
		// Parsing advice: the following should be extrapolated from the "url".
		dataSource.setDataSourceName("com.informix.jdbcx.IfxXADataSource");
		dataSource.setServerName("ssfs_netbr2");
		dataSource.setPortNumber(1551);
		dataSource.setDatabaseName("pro");
		dataSource.setIfxIFXHOST("199.100.101.133");
		// End parsing advice.
		dataSource.setUser(username);
		dataSource.setPassword(password);
		return dataSource;
	}

}
