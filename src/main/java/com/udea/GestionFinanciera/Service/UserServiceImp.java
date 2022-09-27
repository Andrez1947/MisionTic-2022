package com.udea.GestionFinanciera.Service;

import com.udea.GestionFinanciera.Entity.Employee;
import com.udea.GestionFinanciera.Entity.User;
import com.udea.GestionFinanciera.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserServiceI{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User consultarUserById(String email) {

        return userRepository.findById(email).get();
    }
}


