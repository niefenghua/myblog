package com.z.service;

import com.z.dao.CommentsDao;
import com.z.model.Bcomments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentsService")
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsDao commentsDao;

    public void setCommentsDao(CommentsDao commentsDao) {
        this.commentsDao = commentsDao;
    }
    public CommentsDao getCommentsDao() {
        return commentsDao;
    }


    @Override
    public void save(Bcomments comms) {
        commentsDao.save(comms);
    }

    @Override
    public List<Bcomments> getCommentsByArticle(Integer aid) {
        return  commentsDao.getCommentsByArticle(aid);
    }

    @Override
    public void deleteById(Integer id) {
        commentsDao.deleteById(id);
    }
}
