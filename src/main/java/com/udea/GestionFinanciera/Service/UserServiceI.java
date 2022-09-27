package com.udea.GestionFinanciera.Service;

import com.udea.GestionFinanciera.Entity.User;

public interface UserServiceI {

    public User consultarUserById(String email) throws Exception;
}
