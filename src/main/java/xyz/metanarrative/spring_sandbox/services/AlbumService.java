package xyz.metanarrative.spring_sandbox.services;

import xyz.metanarrative.spring_sandbox.entities.Album;

public interface AlbumService {

    String getAll();

    String getAlbum(int year);

    void addAlbum(Album album);

    void removeByYear(int year);

}
