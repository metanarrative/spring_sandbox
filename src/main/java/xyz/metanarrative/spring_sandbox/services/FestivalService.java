package xyz.metanarrative.spring_sandbox.services;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface FestivalService {

    String getFestival(String name) throws JsonProcessingException;

}
