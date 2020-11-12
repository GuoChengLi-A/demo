package com.shunteng.test05;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/9/17 上午11:14
 */
public class WorkOrderVo implements Serializable {

    private static final long serialVersionUID = 1417789508587789036L;
    private String workOrderNo;//工单编号
    private String type;//工单类型
    private Long typeId;//工单类型id
    private String custMobile;//客户手机号
    private String custCompany;//客户公司名
    private String title;//工单标题
    private String remark;//问题描述
    private String picUrls;//图片url
    private String timeRange;//创建时间 xxx-xxx
    private Integer status;//工单状态
    private String userName;//工单发起人
    private String dealName;//工单受理人
    private String suggest;//审核意见
    private Integer recordStatus;//工单记录状态
    private Long groupId;//发起团队id
    private Integer operate;//操作类型 区分重新提交-0、重新发起-1
    private String reason;//申诉理由
    private String orderBy;
    private String ascOrDesc;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getAscOrDesc() {
        return ascOrDesc;
    }

    public void setAscOrDesc(String ascOrDesc) {
        this.ascOrDesc = ascOrDesc;
    }

    /**
     * 统计携带的时间 默认查询条件
     */
    private String time;

    /**
     * 满意度
     */
    private Integer statisify;

    /**
     * 工单发起人姓名
     */
    private String creator;

    /**
     * 发起人团队名称
     */
    private String teamName;

    /**
     * 受理人姓名
     */
    private String auditName;

    /**
     * 受理人团队姓名
     */
    private String auditTeamName;

    /**
     * 总耗时
     */
    private String totalTimes;

    /**
     * 用户Id
     */
    private Long userId;
    private Integer emergency;

    private Integer page;//页码
    private Integer limit;//每页数量

    
    public Integer getEmergency() {
        return emergency;
    }

    
    public void setEmergency(Integer emergency) {
        this.emergency = emergency;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    public String getCustCompany() {
        return custCompany;
    }

    public void setCustCompany(String custCompany) {
        this.custCompany = custCompany;
    }

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String picUrls) {
        this.picUrls = picUrls;
    }

    public String getWorkOrderNo() {
        return workOrderNo;
    }

    public void setWorkOrderNo(String workOrderNo) {
        this.workOrderNo = workOrderNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getStatisify() {
        return statisify;
    }

    public void setStatisify(Integer statisify) {
        this.statisify = statisify;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }
    public String getAuditTeamName() {
        return auditTeamName;
    }

    public void setAuditTeamName(String auditTeamName) {
        this.auditTeamName = auditTeamName;
    }

    public String getTotalTimes() {
        return totalTimes;
    }

    public void setTotalTimes(String totalTimes) {
        this.totalTimes = totalTimes;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Integer getOperate() {
        return operate;
    }

    public void setOperate(Integer operate) {
        this.operate = operate;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}