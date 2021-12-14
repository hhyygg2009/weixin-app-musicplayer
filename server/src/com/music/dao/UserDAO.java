package com.music.dao;

import com.music.dto.User;
import com.music.utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public static boolean checkUser(User user) {
        String name, password;
        name = user.getName();
        password = user.getPassword();

        String sql = "select * from tb_user where name=?";
        String p[] = {name};
        List<User> users = getUsers(DBUtil.execQuery(sql, p));

        if (users != null && users.get(0).getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }

    }

    public static User getUser(String name) {


        String sql = "select * from tb_user where name=?";
        String p[] = {name};
        List<User> users = getUsers(DBUtil.execQuery(sql, p));

        return users.get(0);

    }


    public static boolean addUser(User user) {
        String sql = "INSERT INTO tb_user VALUES(?,?,?,?,?,?,?)";

        String[] p = {user.getName(), user.getPassword(), user.getAge() + "",
                user.getGender(), user.getEmail(), user.getEducation(),
                user.getInteresting()};
        return DBUtil.execUpdate(sql, p);

    }

    public static boolean setUser(User user) {


        String sql = "UPDATE tb_user "
                + "SET age=?,gender=?,email=?,education=?,interesting=?"
                + " WHERE name=?";

        String[] p = {String.valueOf(user.getAge()), user.getGender(), user.getEmail(), user.getEducation(), user.getInteresting(),
                user.getName()};
        return DBUtil.execUpdate(sql, p);

    }


    public static List<User> getUsers(ResultSet rs) {
        ArrayList<User> users = new ArrayList<>();
        String interesting, education, email, gender, password, name;
        int age;
        try {
            while (rs.next()) {
                name = rs.getString("name");
                password = rs.getString("password");
                age = rs.getInt("age");
                gender = rs.getString("gender");
                email = rs.getString("email");
                education = rs.getString("education");
                interesting = rs.getString("interesting");

                User user = new User(name, password, age, gender, email, education, interesting);
                users.add(user);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (users.size() == 0) {
            return null;
        }
        return users;
    }


}
