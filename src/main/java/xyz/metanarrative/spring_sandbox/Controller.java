package xyz.metanarrative.spring_sandbox;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.metanarrative.spring_sandbox.entities.Album;
import xyz.metanarrative.spring_sandbox.services.AlbumService;
import xyz.metanarrative.spring_sandbox.services.BandService;
import xyz.metanarrative.spring_sandbox.services.FestivalService;
import xyz.metanarrative.spring_sandbox.services.MemberService;

import javax.persistence.EntityManagerFactory;

@RestController
@RequestMapping(value = "/api")
public class Controller {

    @Autowired
    EntityManagerFactory factory;

    AlbumService albumService;
    MemberService memberService;
    BandService bandService;
    FestivalService festivalService;

    //album

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAlbums(){
        return ResponseEntity.ok(albumService.getAll());
    }

    @Cacheable("albumCache")
    @GetMapping(value = "/get/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAlbum(@PathVariable int year){
        return ResponseEntity.ok(albumService.getAlbum(year));
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addAlbum(@RequestBody Album album){
        albumService.addAlbum(album);
    }

    @DeleteMapping(value = "/del/{year}")
    public void removeAlbumByYear(@PathVariable int year){
        albumService.removeByYear(year);
    }

    //member

    @GetMapping(value = "/getMember/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getMember(@PathVariable int id){
        return ResponseEntity.ok(memberService.getMember(id));
    }

    //band

    @GetMapping(value = "/getBand/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getBand(@PathVariable int id) throws JsonProcessingException {
        return ResponseEntity.ok(bandService.getBand(id));
    }

    //fest

    @GetMapping(value = "/getFest/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getFest(@PathVariable String name) throws JsonProcessingException {
        return ResponseEntity.ok(festivalService.getFestival(name));
    }

    //service setters

    @Qualifier("asi")
    @Autowired
    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }

    @Qualifier("msi")
    @Autowired
    public void setAlbumService(MemberService memberService) {
        this.memberService = memberService;
    }

    @Qualifier("bsi")
    @Autowired
    public void setBandService(BandService bandService) {
        this.bandService = bandService;
    }

    @Qualifier("fsi")
    @Autowired
    public void setFestivalService(FestivalService festivalService){
        this.festivalService = festivalService;
    }

}
