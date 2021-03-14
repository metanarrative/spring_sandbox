package xyz.metanarrative.spring_sandbox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xyz.metanarrative.spring_sandbox.entities.Band;

@Repository
public interface BandRepository extends JpaRepository<Band, Long> {

    @Query(value = "select distinct b from Band b join fetch b.members where b.id = :id")
    Band findMyBand(int id);

}
