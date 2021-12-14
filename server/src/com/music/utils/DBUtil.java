package com.music.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    public static boolean execUpdate(String sql, String[] p) {
        try {

            Connection con = JDBCUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            if (p != null)
                for (int i = 0; i < p.length; i++) {
                    ps.setString(i + 1, p[i]);
                }

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public static ResultSet execQuery(String sql, String[] p) {
        try {

            Connection con = JDBCUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            if (p != null)
                for (int i = 0; i < p.length; i++) {
                    ps.setString(i + 1, p[i]);
                }

            return ps.executeQuery();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
