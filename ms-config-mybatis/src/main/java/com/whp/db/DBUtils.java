package com.whp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @描述：直接数据库操作类
 *
 * @作者：whp
 *
 * @时间：2017年6月17日 下午9:48:25
 */
public class DBUtils {

	private final static Logger logger = LoggerFactory.getLogger(DBUtils.class);

	/**
	 * 
	 * @描述：查询结果集列表
	 *
	 * @返回：List<Map<String,String>>
	 *
	 * @作者：whp
	 *
	 * @时间：2017年6月17日 下午9:50:03
	 */
	public static List<Map<String, String>> queryForList(String sql, DataSource ds, String... args) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Map<String, String>> retList = new ArrayList<Map<String, String>>();
		try {
			conn = ds.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			if (args != null && args.length > 0) {
				for (int i = 0; i < args.length; i++) {
					preparedStatement.setString(i + 1, args[i]);
				}
			}
			rs = preparedStatement.executeQuery();
			ResultSetMetaData rsm = rs.getMetaData();
			int colNum = rsm.getColumnCount();
			while (rs.next()) {
				Map<String, String> rsMap = new LinkedHashMap<String, String>();
				for (int i = 0; i < colNum; i++) {
					// key转成小写
					rsMap.put(rsm.getColumnName(i + 1).toLowerCase(), rs.getString(rsm.getColumnName(i + 1)));
				}
				retList.add(rsMap);
			}
		} catch (SQLException e) {
			logger.error("", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error("", e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					logger.error("", e);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("", e);
				}
			}
		}
		return retList;
	}

	/**
	 * 
	 * @描述：执行update操作
	 *
	 * @返回：void
	 *
	 * @作者：whp
	 *
	 * @时间：2017年6月17日 下午9:50:13
	 */
	public static void doUpdate(String sql, DataSource ds, String... args) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setString(i + 1, args[i]);
			}
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error("", e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					logger.error("", e);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("", e);
				}
			}
		}
	}
}
