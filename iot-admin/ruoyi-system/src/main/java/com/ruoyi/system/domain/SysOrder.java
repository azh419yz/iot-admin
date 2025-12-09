package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 订单信息对象 sys_order
 *
 * @author ruoyi
 * @date 2025-12-09
 */
public class SysOrder extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    private Long id;

    /**
     * 订单名称
     */
    @Excel(name = "订单名称")
    private String orderName;

    /**
     * 订单编码
     */
    @Excel(name = "订单编码")
    private String orderCode;

    /**
     * 任务名称
     */
    @Excel(name = "任务名称")
    private String taskName;

    /**
     * 任务编码
     */
    @Excel(name = "任务编码")
    private String taskCode;

    /**
     * 产品名称
     */
    @Excel(name = "产品名称")
    private String productName;

    /**
     * 产品交期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "产品交期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deliveryDate;

    /**
     * 状态（0正常 1停用）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("orderName", getOrderName())
                .append("orderCode", getOrderCode())
                .append("taskName", getTaskName())
                .append("taskCode", getTaskCode())
                .append("productName", getProductName())
                .append("deliveryDate", getDeliveryDate())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
