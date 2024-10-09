package com.csc340.mvc_second_demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    /**
     * Get all users
     *
     * @return the list of users.
     */
    public List<User> getAllUsers() {
        return repo.findAll();
    }


    /**
     * Save user entry.
     *
     * @param user
     */
    public void saveUser(User user) {
        repo.save(user);
    }


    public Object getUserById(long id) {
        return repo.getReferenceById(id);
    }
}
