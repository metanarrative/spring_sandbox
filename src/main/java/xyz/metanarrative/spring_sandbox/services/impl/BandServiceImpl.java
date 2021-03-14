package xyz.metanarrative.spring_sandbox.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.metanarrative.spring_sandbox.entities.Band;
import xyz.metanarrative.spring_sandbox.repositories.BandRepository;
import xyz.metanarrative.spring_sandbox.services.BandService;

@Transactional(rollbackFor = Exception.class)
@Service("bsi")
public class BandServiceImpl implements BandService {

    @Autowired
    BandRepository bandRepository;

    @Override
    public String getBand(int id) throws JsonProcessingException {
        Band band = bandRepository.findMyBand(id);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(band);
    }
}
