package com.banks.lostunes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

/**
 * Created by banks on 8/1/17.
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Album extends BaseEntity {

    private String name;

    @OneToOne
    private Artist artist;

    @OneToMany
    private Set<Song> songs;
}
