package com.example.scheduledemo.service;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;

/**
*  System      : MDMSP API - [mockdds]
*
*  Class name : Say.java
*
*  Description : 
*
*  (c) Copyright Taiwan Power Company 2018-2020
*
*  Modification history :
*    Date        	Person        	Comment						Version
*    ----------  	------------  	------------------------  ---------
*    Feb 4, 2020	richard			Created						1.0
*    
**/
@Slf4j
public class Say implements Runnable {
    
    @Override
    public void run(){
        log.info("" + new Date() + " hello");
    }
}
