package com.ruoyi.system.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysOrder;
import com.ruoyi.system.mapper.SysOrderMapper;
import com.ruoyi.system.service.ISysOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单信息Service业务层处理
 *
 * @author ruoyi
 * @date 2025-12-09
 */
@Service
public class SysOrderServiceImpl implements ISysOrderService {
    @Autowired
    private SysOrderMapper sysOrderMapper;

    /**
     * 查询订单信息
     *
     * @param id 订单信息主键
     * @return 订单信息
     */
    @Override
    public SysOrder selectSysOrderById(Long id) {
        return sysOrderMapper.selectSysOrderById(id);
    }

    /**
     * 查询订单信息列表
     *
     * @param sysOrder 订单信息
     * @return 订单信息
     */
    @Override
    public List<SysOrder> selectSysOrderList(SysOrder sysOrder) {
        return sysOrderMapper.selectSysOrderList(sysOrder);
    }

    /**
     * 新增订单信息
     *
     * @param sysOrder 订单信息
     * @return 结果
     */
    @Override
    public int insertSysOrder(SysOrder sysOrder) {
        sysOrder.setCreateTime(DateUtils.getNowDate());
        return sysOrderMapper.insertSysOrder(sysOrder);
    }

    /**
     * 修改订单信息
     *
     * @param sysOrder 订单信息
     * @return 结果
     */
    @Override
    public int updateSysOrder(SysOrder sysOrder) {
        sysOrder.setUpdateTime(DateUtils.getNowDate());
        return sysOrderMapper.updateSysOrder(sysOrder);
    }

    /**
     * 批量删除订单信息
     *
     * @param ids 需要删除的订单信息主键
     * @return 结果
     */
    @Override
    public int deleteSysOrderByIds(Long[] ids) {
        return sysOrderMapper.deleteSysOrderByIds(ids);
    }

    /**
     * 删除订单信息信息
     *
     * @param id 订单信息主键
     * @return 结果
     */
    @Override
    public int deleteSysOrderById(Long id) {
        return sysOrderMapper.deleteSysOrderById(id);
    }
}
