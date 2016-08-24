package com.z.dao;

import com.z.model.Bcomments;

import java.util.List;

public interface CommentsDao {
    void save(Bcomments comms);
    List<Bcomments> getCommentsByArticle(Integer aid);
    void deleteById(Integer id);
}
