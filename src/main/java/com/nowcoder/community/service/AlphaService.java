package com.nowcoder.community.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype")
public class AlphaService {
    public AlphaService(){
        System.out.println("构造");
    }

    @PostConstruct
    public void init(){
        System.out.println("构造之后");
    }

    @PreDestroy
    public void destory(){
        System.out.println("销毁之前");
    }
}
