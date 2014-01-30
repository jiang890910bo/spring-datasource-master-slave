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
    public void test() throws InterruptedException {
        userDao.modifyUser(new User(1, "save1", "pwd", new Date(System.currentTimeMillis())));
        userDao.saveUser(new User(null, "save2", "pwd", new Date(System.currentTimeMillis())));
        userDao.removeUser(8);
        System.out.println(userDao.findUser(1));
        System.out.println(userDao.findUser(1));
        System.out.println(userDao.findUser(1));
    }
}
