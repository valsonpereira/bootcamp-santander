package com.santander.bootcamp.service;

import com.santander.bootcamp.mapper.StockMapper;
import com.santander.bootcamp.model.Stock;
import com.santander.bootcamp.model.dto.StockDTO;
import com.santander.bootcamp.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto) {
        Stock stock = mapper.toEntity(dto);
        return mapper.toDto(repository.save(stock));
    }
}
