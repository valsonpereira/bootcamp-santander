package com.santander.bootcamp.service;

import com.santander.bootcamp.exceptions.BusinessException;
import com.santander.bootcamp.mapper.StockMapper;
import com.santander.bootcamp.model.Stock;
import com.santander.bootcamp.model.dto.StockDTO;
import com.santander.bootcamp.repository.StockRepository;
import com.santander.bootcamp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto) {
        Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(), dto.getDate());

        if(optionalStock.isPresent())
            throw new BusinessException(MessageUtil.STOCK_ALREADY_EXISTS);

        Stock stock = mapper.toEntity(dto);
        return mapper.toDto(repository.save(stock));
    }
}
