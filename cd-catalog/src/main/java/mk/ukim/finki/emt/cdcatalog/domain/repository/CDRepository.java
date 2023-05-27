package mk.ukim.finki.emt.cdcatalog.domain.repository;

import mk.ukim.finki.emt.cdcatalog.domain.models.CD;
import mk.ukim.finki.emt.cdcatalog.domain.models.CDId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CDRepository extends JpaRepository<CD, CDId> {
}