package com.santander.bootcamp.exceptions;

import com.santander.bootcamp.util.MessageUtil;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){
        super(MessageUtil.STOCK_NOT_FOUND);
    }
}
