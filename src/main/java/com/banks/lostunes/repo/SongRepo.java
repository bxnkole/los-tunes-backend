package com.banks.lostunes.repo;

import com.banks.lostunes.model.Role;
import com.banks.lostunes.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by banks on 002 Aug 02 2017 7:06 AM.
 */
@Repository
public interface SongRepo extends JpaRepository<Song, Long> {
}
