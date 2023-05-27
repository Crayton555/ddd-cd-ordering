package mk.ukim.finki.emt.cdcatalog.domain.repository;


import mk.ukim.finki.emt.cdcatalog.domain.models.Artist;
import mk.ukim.finki.emt.cdcatalog.domain.models.ArtistId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, ArtistId> {
}
