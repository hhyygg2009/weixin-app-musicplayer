package com.music.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.music.dto.Favor;
import com.music.utils.DBUtil;

public class FavorDAO {
	public static boolean setFavor(Favor fav,boolean INSERT){
		String userid;
		int songid;
		
		userid=fav.getUserid();
		songid=fav.getSongid();
		String sql="INSERT INTO favormusic(userid,songid) VALUES(?,?)";
		String delSQL="DELETE FROM favormusic where userid=? AND songid=?";
		
		String[] p= {String.valueOf(userid),String.valueOf(songid)};
		if(INSERT) {
			return DBUtil.execUpdate(sql, p);			
		}else {
			return DBUtil.execUpdate(delSQL, p);
		}
		
	}
	
	public static List<Favor> getFavor(String userid) {
		String sql="SELECT * FROM favormusic where userid=?";
		String []p= {userid};
		int id,songid;
		List<Favor> favors=new ArrayList<>();
		ResultSet rs=DBUtil.execQuery(sql, p);
		try {
			 
			while(rs.next()) {
				id=rs.getInt("id");
				songid=rs.getInt("songid");
				Favor f=new Favor(id,userid,songid);
				favors.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(favors.size()==0) {
			return null;
		}		
		return favors;
	}
	
}
