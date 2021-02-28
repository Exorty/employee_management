package com.miller.gerenciamentoFuncionarios.services;

import com.miller.gerenciamentoFuncionarios.appuser.AppUser;
import com.miller.gerenciamentoFuncionarios.appuser.CustomUserDetails;
import com.miller.gerenciamentoFuncionarios.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public AppUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AppUserService() {

    }

    public void register(AppUser appUser) {
        try {
            String encodedPassword = passwordEncoder.encode(appUser.getPassword());
            appUser.setPassword(encodedPassword);
          
            appUser.setEnabled(false);
    
            userRepository.save(appUser);
    
            
        } catch (Exception e) {
         
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username ) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);

     
     
    }

}