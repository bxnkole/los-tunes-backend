package com.banks.lostunes.model;

import lombok.Getter;
import lombok.Setter;
import sun.java2d.loops.ProcessPath;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by banks on 8/1/17.
 */
@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
}
