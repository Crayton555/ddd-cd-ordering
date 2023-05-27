package mk.ukim.finki.emt.cdcatalog.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "album")
@Getter
public class Album extends AbstractEntity<AlbumId> {
    private String albumName;
    private int releaseYear;
    private String albumArtwork;

    public Album() {
        super(AlbumId.randomId(AlbumId.class));
    }

    public static Album build(String albumName, int releaseYear, String albumArtwork) {
        Album album = new Album();
        album.albumName = albumName;
        album.releaseYear = releaseYear;
        album.albumArtwork = albumArtwork;
        return album;
    }
}
