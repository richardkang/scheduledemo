package com.example.scheduledemo.service;

import java.util.Date;
 
import javax.annotation.PostConstruct;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
/**
*  System      : MDMSP API - [mockdds]
*
*  Class name : ScheduleController.java
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
@Controller
@Slf4j
public class ScheduleController {
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
     
    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        return new ThreadPoolTaskScheduler();
    }

    @RequestMapping("/home")
    @ResponseBody
    public String home(){
        return "home";
    }
     
    ///方法二
     
    private String cronStr = "*/5 * * * * *";
    @RequestMapping("/startCron1")
    @ResponseBody
    public String startCron1(){
        log.info("startCron1 >>>>");
        threadPoolTaskScheduler.schedule(new Say(), new Trigger(){
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext){
                return new CronTrigger(cronStr).nextExecutionTime(triggerContext);
            }
        });
        log.info("startCron1 <<<<");
        return "*****";
    }
    @RequestMapping("/changeCronStr")
    @ResponseBody
    public String changeCronStr(){
        cronStr = "*/12 * * * * *";
        log.info("change "  + cronStr);
        return  cronStr;
    }
     
    @RequestMapping("/changeCronStr5")
    @ResponseBody
    public String changeCronStr5(){
        cronStr = "*/5 * * * * *";
        log.info("change "  + cronStr);
        return  cronStr;
    }
    
    
    
   @PostConstruct
   public void start(){
       startCron1();
   }
}

