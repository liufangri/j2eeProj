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
public interface CommentDao {

    public boolean insert(Comment comment);

    public ArrayList<Comment> getCommentsByBookId(String bookId);

    public boolean delete(String id);
}
