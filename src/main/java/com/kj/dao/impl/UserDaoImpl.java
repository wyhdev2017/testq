package com.kj.dao.impl;

import com.kj.dao.UserDao;
import com.kj.entity.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wyh on 2017/9/30.
 */
@Transactional(rollbackFor = Exception.class)
//出现Exception异常回滚
@Repository("userDao") //进行注入
public class UserDaoImpl implements UserDao {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
    public boolean login(User user) {
        Iterator<User> it;
        String hsql="FROM User u where u.userId=? and u.password=?";
        System.out.println(hsql);
        Query query = sessionFactory.getCurrentSession().createQuery(hsql);
        query.setString(0, user.getUserId());
        query.setString(1, user.getPassword());
        System.out.println(user.getUserId());
        it=query.iterate();
        if(it.hasNext()) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }

    public List getUser() {
        return sessionFactory.getCurrentSession().createQuery("FROM User").list();
    }

    public User getUser(int id) {
        return (User)sessionFactory.getCurrentSession().get(User.class, id);
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(
                sessionFactory.getCurrentSession().get(User.class, id)
        );
    }
}