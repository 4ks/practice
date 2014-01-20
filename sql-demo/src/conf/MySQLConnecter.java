package conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MySQLConnecter implements DBConfig {
	
	private static Log log = LogFactory.getLog(MySQLConnecter.class);
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME,PASSWORLD);
		} catch (SQLException e) {
			log.error("创建数据库连接", e);
		} catch (ClassNotFoundException e) {
			log.error("找不到MYSQL数据库驱动", e);
		}
		return conn;
	}

}
