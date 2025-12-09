package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysOrder;

import java.util.List;

/**
 * 订单信息Mapper接口
 *
 * @author ruoyi
 * @date 2025-12-09
 */
public interface SysOrderMapper {
    /**
     * 查询订单信息
     *
     * @param id 订单信息主键
     * @return 订单信息
     */
    public SysOrder selectSysOrderById(Long id);

    /**
     * 查询订单信息列表
     *
     * @param sysOrder 订单信息
     * @return 订单信息集合
     */
    public List<SysOrder> selectSysOrderList(SysOrder sysOrder);

    /**
     * 新增订单信息
     *
     * @param sysOrder 订单信息
     * @return 结果
     */
    public int insertSysOrder(SysOrder sysOrder);

    /**
     * 修改订单信息
     *
     * @param sysOrder 订单信息
     * @return 结果
     */
    public int updateSysOrder(SysOrder sysOrder);

    /**
     * 删除订单信息
     *
     * @param id 订单信息主键
     * @return 结果
     */
    public int deleteSysOrderById(Long id);

    /**
     * 批量删除订单信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysOrderByIds(Long[] ids);
}
