package xyz.metanarrative.spring_sandbox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xyz.metanarrative.spring_sandbox.entities.Album;

import java.util.List;

@Repository
public interface AlbumDAO extends JpaRepository<Album, Long> {

    @Modifying
    @Query(value = "insert into album(name, year, band) values(:name, :year , :band)", nativeQuery=true)
    void addAlbum(String name, int year, String band);

    List<Album> findAlbumByYear(int year);

    void removeAlbumsByYear(int year);

}
