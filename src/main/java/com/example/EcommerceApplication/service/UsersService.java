package com.example.EcommerceApplication.service;

import com.example.EcommerceApplication.dao.UsersRepository;
import com.example.EcommerceApplication.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public void registerUser(Users users) {
        usersRepository.save(users);
    }

}




