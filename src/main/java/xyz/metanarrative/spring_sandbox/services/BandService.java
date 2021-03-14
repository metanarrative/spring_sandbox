package xyz.metanarrative.spring_sandbox.services;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface BandService {

    String getBand(int id) throws JsonProcessingException;

}
