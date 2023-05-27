package mk.ukim.finki.emt.cdcatalog.domain.repository;

import mk.ukim.finki.emt.cdcatalog.domain.models.Album;
import mk.ukim.finki.emt.cdcatalog.domain.models.AlbumId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, AlbumId> {
}
