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

	private static final int DEFAULT_TIMES = 500;

	public static long execute(Connection conn, String sql) {
		try {
			Statement stmt = conn.createStatement();

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
		}
		return 0;
	}

	public static void main(String[] args) {
		String sql = " select * from qu_tb_agent_order ";
		log.info("SQL语句：" + sql);
		
		Connection conn = MySQLConnecter.getConnection();
		long times = SQLAverage.execute(conn, sql);
		log.info("平均耗时：" + times + "ms");
	}
}