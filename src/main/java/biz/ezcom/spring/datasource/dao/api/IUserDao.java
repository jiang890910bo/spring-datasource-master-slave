package biz.ezcom.spring.datasource.dao.api;

import biz.ezcom.spring.datasource.po.User;

public interface IUserDao {
    int saveUser(User user);

    int removeUser(Integer id);

    int modifyUser(User user);

    User findUser(Integer id);
}
