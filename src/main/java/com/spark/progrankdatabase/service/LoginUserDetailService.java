package com.spark.progrankdatabase.service;
import com.spark.progrankdatabase.dto.CustomUserDetails;
import com.spark.progrankdatabase.entity.User;
import com.spark.progrankdatabase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginUserDetailService implements UserDetailsService {
    @Autowired
    private  UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user=this.userRepository.findByUserName(username);
         if (user==null )
         {
             throw  new UsernameNotFoundException("user is not present");
         }
         UserDetails customUserDetails=new CustomUserDetails(user);

         return customUserDetails;


    }
}
