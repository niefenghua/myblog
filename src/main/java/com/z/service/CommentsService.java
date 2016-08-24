package com.z.service;


import com.z.model.Bcomments;

import java.util.List;

public interface CommentsService {
    void save(Bcomments comms);
    List<Bcomments> getCommentsByArticle(Integer aid);
    void deleteById(Integer id);

}
