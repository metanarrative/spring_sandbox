package xyz.metanarrative.spring_sandbox.services.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.metanarrative.spring_sandbox.entities.Album;
import xyz.metanarrative.spring_sandbox.repositories.AlbumDAO;
import xyz.metanarrative.spring_sandbox.services.AlbumService;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service("asi")
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumDAO repository;

    @Override
    public String getAll() {
        List<Album> albums = repository.findAll();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(albums);
    }

    @Override
    public String getAlbum(int year){
        List<Album> albums = repository.findAlbumByYear(year);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(albums);
    }

    @Override
    public void addAlbum(Album album) {
        String name = album.getName();
        int year = album.getYear();
        String artist = album.getBand();
        repository.addAlbum(name, year, artist);
    }

    @Override
    public void removeByYear(int year) {
        repository.removeAlbumsByYear(year);
    }
}
