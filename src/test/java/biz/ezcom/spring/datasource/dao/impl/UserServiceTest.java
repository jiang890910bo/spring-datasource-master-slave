package biz.ezcom.spring.datasource.dao.impl;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import biz.ezcom.spring.datasource.dao.api.IUserDao;
import biz.ezcom.spring.datasource.po.User;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class UserServiceTest {
    @Autowired
    private IUserDao userDao;

    @Test
    public void testSave() {
        User user = new User(1, "Felix", "save", new Date(System.currentTimeMillis()));
        userDao.save(user);
    }

    @Test
    public void testRemove() {
        userDao.remove(1);
    }

    @Test
    public void testModify() {
        User user = new User(1, "Felix", "modify", new Date(System.currentTimeMillis()));
        userDao.modify(user);
    }

    @Test
    public void testFind() {
        Integer id = 1;
        User user = userDao.find(id);
        System.out.println(user);
    }
}
