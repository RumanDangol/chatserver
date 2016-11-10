/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.MyServer.dao;

import com.leapfrog.MyServer.entity.User;
import java.util.List;

/**
 *
 * @author ruman dangol
 */
public interface UserDao {
    boolean insert(User user);
    List<User> getAll();
    User login(String userName,String password);
    
}
