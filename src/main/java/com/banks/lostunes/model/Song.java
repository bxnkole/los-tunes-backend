package com.banks.lostunes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by banks on 8/1/17.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Song extends BaseEntity {

    private String title;

    private Long downloads;

    @ManyToOne
    private Album album;

}
