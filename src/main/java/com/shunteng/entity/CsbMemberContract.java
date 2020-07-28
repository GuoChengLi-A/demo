package com.shunteng.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * csb_member_contract
 * @author 
 */
public class CsbMemberContract implements Serializable {
    private Long id;

    /**
     * 订单编号
     */
    private String orderId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 百度联盟id
     */
    private String memberId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 百度合同编码，系统生成，和纸质合同不同

     */
    private String contractId;

    /**
     * 合同图片
     */
    private String contractImg;

    /**
     * 合同类型，10001：普通会员合同，10002实地商家，10003现货商家

     */
    private String contractType;

    /**
     * 合同审核状态：0:未提交 1.待审核 2审核通过 3审核不通过
     */
    private Integer auditStatus;

    /**
     * 合同开始时间
     */
    private Date startTime;

    /**
     * 合同到期时间
     */
    private Date endTime;

    /**
     * 拒审理由
     */
    private String refuseReason;

    /**
     * 合同余额 按月为单位
     */
    private Integer contractBalance;

    /**
     * 合同上传时间
     */
    private Date uploadTime;

    private Date createtime;

    private Date updatetime;

    private Integer isdelete;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractImg() {
        return contractImg;
    }

    public void setContractImg(String contractImg) {
        this.contractImg = contractImg;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public Integer getContractBalance() {
        return contractBalance;
    }

    public void setContractBalance(Integer contractBalance) {
        this.contractBalance = contractBalance;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}