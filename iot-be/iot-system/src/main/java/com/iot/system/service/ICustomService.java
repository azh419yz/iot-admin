package com.iot.system.service;

import com.iot.system.domain.bo.CustomWebSocketBo;

public interface ICustomService {

    void push(CustomWebSocketBo customWebSocketBo);
}
