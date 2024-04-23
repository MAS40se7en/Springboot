package org.mik.first.spring.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.mik.first.spring.domain.Country;
import org.mik.first.spring.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    private ObjectMapper objectMapper;
    @Autowired
    public CountryService(CountryRepository countryRepository , ObjectMapper objectMapper){
        this.countryRepository=countryRepository;
        this.objectMapper= objectMapper;
    }

    private void init(){
        log.info("Enter init");
        List<Country> q=countryRepository.findAll();
        q.forEach(log::info);
    }

    public List<Country> getAll() {
        return this.countryRepository.findAll();
    }
}
