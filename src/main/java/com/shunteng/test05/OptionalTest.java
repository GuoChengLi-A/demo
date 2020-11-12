package com.shunteng.test05;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
 *
 * @Description TODO
 * @Author GCL
 * @Date 2020/11/5 下午4:22
 */

public class OptionalTest {

    public static void main(String[] args) {
        WorkOrderVo vo = new WorkOrderVo();
        vo.setCustMobile("130837762837");
        vo.setTypeId(123L);
        Map<String, Object> params = createParams(vo);
        System.out.println(params);

       /* String str = null;
        System.out.println(str + "");*/
        //null+""  ->  "null"
//        System.out.println(StringUtils.isNotBlank(null + ""));

    }

    private static Map<String, Object> createParams(WorkOrderVo vo) {
        Map<String, Object> params = new HashMap<>();
        /*if (vo.getPage() != null && vo.getLimit() != null) {
            params.put("offset", (vo.getPage() - 1) * vo.getLimit());
            params.put("limit", vo.getLimit());
        }

        if (StringUtils.isNotBlank(vo.getCustMobile())) {
            params.put("custMobile", vo.getCustMobile());
        }*/

        OptionalUtils.ofNullable(vo.getCustMobile()).map(custMobile -> params.put("custMobile", custMobile));
        OptionalUtils.ofNullable(vo.getCustCompany()).map(custCompany -> params.put("custCompany", custCompany));
        Optional.ofNullable(vo.getTypeId()).map(typeId -> params.put("typeId", typeId));

        /*if (StringUtils.isNotBlank(vo.getCustCompany())) {
            params.put("custCompany", vo.getCustCompany());
        }
        if (StringUtils.isNotBlank(vo.getWorkOrderNo())) {
            params.put("workOrderNo", vo.getWorkOrderNo());
        }
        if (StringUtils.isNotBlank(vo.getTimeRange())) {
            String rangeTime = vo.getTimeRange();
            //时间范围
            if (StringUtils.isNotEmpty(rangeTime)) {
                String startTime = rangeTime.split(" ")[0];
                String endTime = rangeTime.split(" ")[2];
                params.put("timeStart", startTime + " 00:00:00");
                params.put("timeEnd", endTime + " 23:59:59");
            }
        }
        if (vo.getTypeId() != null) {
            params.put("typeId", vo.getTypeId());
        }
        if (StringUtils.isNotBlank(vo.getTitle())) {
            params.put("title", vo.getTitle());
        }
        if (vo.getStatus() != null) {
            params.put("status", vo.getStatus());
        }
        if (vo.getStatisify() != null) {
            params.put("statisify", vo.getStatisify());
        }
        if (StringUtils.isNotEmpty(vo.getTime())) {
            params.put("create", "isNotNull");
            params.put("createStart", vo.getTime() + " 00:00:00");
            params.put("createEnd", vo.getTime() + " 23:59:59");
        }
        if (vo.getUserId() != null) {
            params.put("userId", vo.getUserId());
        }

        if (StringUtils.isNotEmpty(vo.getType())) {
            params.put("type", vo.getType());
        }
        if (vo.getGroupId() != null) {
            params.put("originGroupId", vo.getGroupId());
        }*/
        return params;
    }
}
