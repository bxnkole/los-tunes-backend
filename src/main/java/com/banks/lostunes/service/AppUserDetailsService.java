package com.banks.lostunes.service;

import com.banks.lostunes.model.AppUser;
import com.banks.lostunes.repo.AppUserRepo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by banks on 002 Aug 02 2017 7:03 AM.
 */
@Component
public class AppUserDetailsService implements UserDetailsService {

    private AppUserRepo appUserRepo;

    public AppUserDetailsService(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> distinctByUsername = appUserRepo.findDistinctWithRolesByUsername(username);
        if (distinctByUsername.isPresent()) {
            AppUser appUser = distinctByUsername.get();
            return new User(appUser.getUsername(), appUser.getPassword(), appUser.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList()));
        }
        return null;
    }
}
