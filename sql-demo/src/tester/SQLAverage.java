package tester;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import conf.MySQLConnecter;

/**
 * 分析1条SQL查询语句执行1000次的平均时间。适用于SQL查询语句性能调优。
 * 
 * @author Kim
 */
public class SQLAverage {

	private static Log log = LogFactory.getLog(SQLAverage.class);

	private static final int DEFAULT_TIMES = 1000;

	public static long execute(Connection conn, String sql) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();

			Calendar cs = Calendar.getInstance(); // 开始时间
			log.info("执行次数：" + DEFAULT_TIMES);
			for (int i = 0; i < DEFAULT_TIMES; i++) {
				stmt.executeQuery(sql);
			}

			Calendar ce = Calendar.getInstance();// 结束时间
			long rs = ce.getTimeInMillis() - cs.getTimeInMillis();

			return rs / DEFAULT_TIMES;
		} catch (SQLException e) {
			log.error("创建数据库连接", e);
		} finally {
			if (stmt != null) {
				try {
					if (!stmt.isClosed()) {
						stmt.close();
					}
				} catch (SQLException e) {
					log.error("关闭Statement", e);
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		String sql = " select * from qu_tb_agent_order where createDate > 2013-12-01 and createDate < 2014-01-01 ";
		log.info("SQL语句：" + sql);
		
		Connection conn = MySQLConnecter.getConnection();
		long times = SQLAverage.execute(conn, sql);
		log.info("平均耗时：" + times + "ms");
		
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			log.error("关闭Connection", e);
		}
	}
}