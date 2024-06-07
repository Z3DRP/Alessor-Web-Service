package com.alessor.app.ws.service;

import com.alessor.app.ws.io.entities.Role;
import com.alessor.app.ws.io.entities.UserEntity;
import com.alessor.app.ws.repositories.UserRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlessorUserDetailService implements UserDetailsService {

    private UserRepo userRepository;

    public AlessorUserDetailService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity usr = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user not found."));
        return new User(usr.getUsername(), usr.getPassword(), mapRolesToAuthorities(usr.getRoles()));
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}

