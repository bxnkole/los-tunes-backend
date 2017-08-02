package com.banks.lostunes.controller;

import com.banks.lostunes.repo.SongRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by banks on 8/1/17.
 */
@RestController("/v2/api/popularmusic")
public class PopularMusicController {

    private SongRepo songRepo;

    public PopularMusicController(SongRepo songRepo) {
        this.songRepo = songRepo;
    }

    @GetMapping
    public ResponseEntity getPopularMusic() {
        return null;
    }

}
