package com.music.dao;

import com.music.dto.Music;
import com.music.utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicDAO {
    public static List getAllMusic() {
        String sql = "SELECT * FROM music";

        ResultSet rs = DBUtil.execQuery(sql, null);
        List<Music> musics = getMusicList(rs);


        if (musics.size() == 0) {
            return null;
        }
        return musics;
    }

    public static List getMusic(String name) {
        String sql = "SELECT * FROM music WHERE title LIKE ?";
        String[] p = {"%" + name + "%"};
        ResultSet rs = DBUtil.execQuery(sql, p);

        List<Music> musics = getMusicList(rs);


        if (musics.size() == 0) {
            return null;
        }
        return musics;
    }


    static List<Music> getMusicList(ResultSet rs) {
        String title, singer, src, coverImgUrl;
        int id;
        List<Music> musics = new ArrayList<>();
        try {
            if (rs != null)
                while (rs.next()) {
                    id = rs.getInt("id");
                    title = rs.getString("title");
                    singer = rs.getString("singer");
                    src = rs.getString("src");
                    coverImgUrl = rs.getString("coverImgUrl");
                    Music m = new Music(id, title, singer, src, coverImgUrl);
                    musics.add(m);
                }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return musics;

    }

}
