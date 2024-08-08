package org.example.service.service;

import org.example.dao.UserDao;
import org.example.dao.daoImpl.UserDaoImpl;
import org.example.model.User;
import org.example.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

     UserDao userDao = new UserDaoImpl();
    @Override
    public void createUserTable() {
    userDao.createUserTable();
    }

    @Override
    public void saveUser(User user) {
   userDao.saveUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getByUser(Long id) {
        return null;
    }

    @Override
    public void updateUser(Long id, User user) {

    }

    @Override
    public void cleanTable() {

    }

    @Override
    public void dropTable() {

    }
}
