/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sxy.j2ee.project.model;

/**
 *
 * @author Y400
 */
public interface UserDao {

    public User findByName(String name);

    public User findByEmail(String email);

    public String getPasswordByEmail(String email);

    public boolean insert(User user);

    public boolean update(User user);

    public boolean delete(User user);

    public boolean delete(long id);

}
