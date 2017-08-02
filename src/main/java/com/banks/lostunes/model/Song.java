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
    private String code;
    private String url;
    private String coverUrl;

    private Long likes;
    private Long downloads;
    private Long playCount;

    @ManyToOne
    private Album album;

    public String getUrl() {
        return "/song/" + getId() + "" + getCode();
    }

    public String getCoverUrl() {
        return "/cover/song-" + getId() + ".jpg";
    }

}