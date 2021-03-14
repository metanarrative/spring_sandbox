package xyz.metanarrative.spring_sandbox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.metanarrative.spring_sandbox.entities.Festival;

@Repository
public interface FestivalRepository extends JpaRepository<Festival, Long> {

    Festival findFestivalByName(String name);

}
