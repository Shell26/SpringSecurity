package ru.shell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shell.dao.UserDao;
import ru.shell.dao.UserDaoImpl;
import ru.shell.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public void UserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    @Transactional  //метод должен выполняться в транзакции
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    @Transactional  //метод должен выполняться в транзакции
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    @Transactional  //метод должен выполняться в транзакции
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    @Transactional  //метод должен выполняться в транзакции
    public void edit(User user) {
        userDao.edit(user);
    }

    @Override
    @Transactional  //метод должен выполняться в транзакции
    public User getById(int id) {
        return userDao.getById(id);
    }
}
