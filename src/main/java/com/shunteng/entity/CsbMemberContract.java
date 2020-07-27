package com.shunteng.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * csb_member_contract
 * @author 
 */
@Data
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
}