package com.iot.system.service.impl;

import com.iot.system.domain.bo.CustomWebSocketBo;
import com.iot.system.service.ICustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomServiceImpl implements ICustomService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Override
    public void push(CustomWebSocketBo customWebSocketBo) {
        messagingTemplate.convertAndSend("/topic/data", customWebSocketBo);
    }
}
