package com.iot.web.controller.custom;

import com.iot.system.domain.bo.CustomWebSocketBo;
import com.iot.system.service.ICustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom")
public class CustomPushController {
    @Autowired
    private ICustomService customService;

    @PostMapping("/push")
    public void push(@RequestBody CustomWebSocketBo webSocketBo) {
        customService.push(webSocketBo);
    }
}
