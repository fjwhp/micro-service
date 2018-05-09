package com.able.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.able.consts.Consts;
/**
 * 
 * @描述：创建数据库连接
 *
 * @作者：wuhp
 * 
 * @时间：2018年5月8日 下午4:43:01
 */
public class DBHandler {
    private static Connection conn ;
    
    public static final Connection createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver") ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + Consts.DB_HOST + ":" + Consts.DB_PORT + "/" + Consts.DB_NAME, Consts.DB_USER ,Consts.DB_PASS) ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn ;
    }
    
    public static final void close() {
        if(conn != null) {
            try {
                conn.close() ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}