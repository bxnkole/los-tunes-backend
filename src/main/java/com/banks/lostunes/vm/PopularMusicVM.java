package com.banks.lostunes.vm;

import com.banks.lostunes.model.Song;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

/**
 * Created by banks on 8/1/17.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PopularMusicVM {

    private String title;
    private String snakeTitle;

    private Long albumId;
    private String albumName;
//    private String snakeAlbumName;

    private Long artistId;
    private String artistName;
//    private String snakeArtistName;

    private String songCoverUrl;
    private String songUrl;
//    private String songFullUrl;

    private Long likes;
//    private Long rLikes;

    private Long downloads;
//    private Long rDownloads;

    private Long playCount;
//    private Long rPlayCount;

    private Long rank;
//    private Long cRank;
//    private Long hRank;

    public PopularMusicVM(Song song) {
        this.title = song.getTitle();
        this.snakeTitle = song.getCode();
        this.albumId = song.getAlbum().getId();
        this.albumName = song.getAlbum().getName();
        this.artistId = song.getAlbum().getArtist().getId();
        this.artistName = song.getAlbum().getArtist().getName();
        this.songCoverUrl = song.getCoverUrl();
        this.songUrl = song.getUrl();
        this.likes = song.getLikes();
        this.downloads = song.getDownloads();
        this.playCount = song.getPlayCount();
        this.rank = 1L;
    }

    public void setTitle(String title) {
        this.title = title;
    }



}
