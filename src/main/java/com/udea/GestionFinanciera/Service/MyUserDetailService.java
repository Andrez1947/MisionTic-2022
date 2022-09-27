package com.udea.GestionFinanciera.Service;

import com.udea.GestionFinanciera.Entity.MyUserDetail;
import com.udea.GestionFinanciera.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailService implements UserDetailsService {


    @Autowired
    UserServiceI userServiceI;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            User user = userServiceI.consultarUserById(username);
            return  new MyUserDetail(user);
        } catch (Exception e){
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
