package xyz.metanarrative.spring_sandbox.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.metanarrative.spring_sandbox.entities.Festival;
import xyz.metanarrative.spring_sandbox.repositories.FestivalRepository;
import xyz.metanarrative.spring_sandbox.services.FestivalService;

@Transactional(rollbackFor = Exception.class)
@Service("fsi")
public class FestivalServiceImpl implements FestivalService {

    @Autowired
    FestivalRepository festivalRepository;

    @Override
    public String getFestival(String name) throws JsonProcessingException {
        Festival festival = festivalRepository.findFestivalByName(name);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(festival);
    }
}
