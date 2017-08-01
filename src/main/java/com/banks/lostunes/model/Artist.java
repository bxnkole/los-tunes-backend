package com.banks.lostunes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by banks on 8/1/17.
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Artist extends BaseEntity {
    private String name;

    @OneToMany
    private Set<Album> albums;
}
