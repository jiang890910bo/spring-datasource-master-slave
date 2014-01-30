package biz.ezcom.spring.datasource.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import biz.ezcom.spring.datasource.dao.api.IUserDao;
import biz.ezcom.spring.datasource.po.User;

@Repository
public class UserDao implements IUserDao {
    @Resource
    private JdbcTemplate jdbcTemplateMaster;
    @Resource
    private JdbcTemplate jdbcTemplateSlave;
    
    @Override
    public int saveUser(final User user) {
        final String sql = "INSERT INTO t_user (username, password, birthday) VALUES(?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int result = jdbcTemplateMaster.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setDate(3, user.getBirthday());
                return ps;
            }
        }, keyHolder);
        int id = keyHolder.getKey().intValue();
        user.setId(id);
        return result;
    }

    @Override
    public int removeUser(Integer id) {
        String sql = "DELETE FROM t_user WHERE id=" + id;
        return jdbcTemplateMaster.update(sql);
    }

    @Override
    public int modifyUser(User user) {
        String sql = "UPDATE t_user SET username=?,password=?,birthday=? WHERE id=?";
        Object[] args = new Object[] { user.getUsername(), user.getPassword(), user.getBirthday(), user.getId() };
        int[] argTypes = new int[] { Types.VARCHAR, Types.VARCHAR, Types.DATE, Types.INTEGER };
        return jdbcTemplateMaster.update(sql, args, argTypes);
    }

    @Override
    public User findUser(Integer id) {
        String sql = "SELECT id,username,password,birthday FROM t_user WHERE id=" + id;
        return jdbcTemplateSlave.queryForObject(sql, new User());
    }
}
