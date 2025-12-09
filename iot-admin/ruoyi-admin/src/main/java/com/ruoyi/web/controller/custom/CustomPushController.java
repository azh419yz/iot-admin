package com.ruoyi.web.controller.custom;

import com.ruoyi.system.domain.bo.CustomWebSocketBo;
import com.ruoyi.system.service.ICustomService;
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
