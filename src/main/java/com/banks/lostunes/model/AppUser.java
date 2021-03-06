package com.banks.lostunes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by banks on 8/1/17.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class AppUser extends BaseEntity {

    private String username;
    private String password;

    @OneToMany
    private Set<Role> roles;

}
