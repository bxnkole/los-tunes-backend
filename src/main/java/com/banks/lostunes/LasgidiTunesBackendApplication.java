package com.banks.lostunes;

import com.banks.lostunes.model.AppUser;
import com.banks.lostunes.model.Role;
import com.banks.lostunes.repo.AppUserRepo;
import com.banks.lostunes.repo.RoleRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class LasgidiTunesBackendApplication {

    private AppUserRepo appUserRepo;
    private RoleRepo roleRepo;

    public LasgidiTunesBackendApplication(AppUserRepo appUserRepo, RoleRepo roleRepo) {
        this.appUserRepo = appUserRepo;
        this.roleRepo = roleRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(LasgidiTunesBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                if (appUserRepo.count() == 0L) {
                    Role adminRole = new Role("ADMIN");
                    roleRepo.save(adminRole);

                    Role userRole = new Role("USER");
                    roleRepo.save(userRole);

                    AppUser adminAppUser = new AppUser();
                    adminAppUser.setUsername("admin");
                    adminAppUser.setPassword(new BCryptPasswordEncoder().encode("admin"));
                    adminAppUser.setRoles(new HashSet<>(Arrays.asList(adminRole)));
                    appUserRepo.save(adminAppUser);

                    AppUser userAppUser = new AppUser();
                    userAppUser.setUsername("user");
                    userAppUser.setPassword(new BCryptPasswordEncoder().encode("user"));
                    userAppUser.setRoles(new HashSet<>(Arrays.asList(userRole)));
                    appUserRepo.save(userAppUser);
                }
            }
        };
    }

}
