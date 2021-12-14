package com.music.utils;

import java.sql.*;

public class JDBCUtils {
    // 加载驱动，并建立数据库连接
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/musicplayer";
        String username = "root";
        String password = "password";
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    // 关闭数据库连接，释放资源
    public static void release(PreparedStatement ps, Connection conn) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

    public static void release(ResultSet rs, PreparedStatement ps, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        release(ps, conn);
    }
}
