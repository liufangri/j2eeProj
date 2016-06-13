/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sxy.j2ee.project.model;

import java.util.ArrayList;

/**
 *
 * @author Y400
 */
public interface BookDao {

    public Book findBookById(String id);

    public ArrayList<Book> findBooksByTitle(String title);

    public Book findBookByAuthor(String author);

    public boolean insert(Book book);

    public boolean delete(Book book);

    public boolean delete(String id);

    public boolean update(Book book);

}
