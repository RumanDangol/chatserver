/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.MyServer.dao.impl;

import com.leapfrog.MyServer.dao.UserDao;
import com.leapfrog.MyServer.entity.User;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ruman dangol
 */
public class UserDaoImpl implements UserDao{
 private List<User> userList = new ArrayList<>();

    @Override
    public boolean insert(User user) {
        return userList.add(user);
    }

    @Override
    public List<User> getAll() {
        userList.add(new User(1, "nikunj", "nikunj", "nikunj@gmail.com", true));
        userList.add(new User(2, "kripesh", "kripesh", "kripesh@gmail.com", true));
        userList.add(new User(3, "ruman", "ruman", "ruman@gmail.com", true));
        userList.add(new User(4, "bibek", "bibek", "bibek@gmail.com", false));
        return userList;
    }

    @Override
    public User login(String userName, String password) {
        for(User u: getAll()){
            if(u.getUserName().equalsIgnoreCase(userName)&& u.getPassword().equalsIgnoreCase(password)){
                return u;
            }
        }
        return null;
    }
    
}
