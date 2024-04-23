package org.mik.first.spring.service;

import org.mik.first.spring.domain.UserInfo;
import org.mik.first.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collection;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository= userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDetails loadUserByName(String userName) throws UsernameNotFoundException{
        if (userName == null || !StringUtils.hasLength(userName))
            throw new UsernameNotFoundException("Username is empty");

        UserInfo userInfo= this.userRepository.findByUserName(userName)
                .orElseThrow(()->new UsernameNotFoundException("cannot find user"));

        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getPassword() {
                return userInfo.getPassword();
            }

            @Override
            public String getUsername() {
                return userInfo.getUserName();
            }

            @Override
            public boolean isAccountNonExpired() {
                return userInfo.getActive();
            }

            @Override
            public boolean isAccountNonLocked() {
                return userInfo.getActive();
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return userInfo.getActive();
            }

            @Override
            public boolean isEnabled() {
                return userInfo.getActive();
            }
        };
    }


}
