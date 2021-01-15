package com.shunteng.test06.Dip;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/6 17:49
 */
public abstract class AbstractSohhService {
    private String name;
    private String content;
    private Date serviceStart;
    private Date serviceEnd;

    public abstract Map<String ,Object> open(HashMap<String ,Object> params);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getServiceStart() {
        return serviceStart;
    }

    public void setServiceStart(Date serviceStart) {
        this.serviceStart = serviceStart;
    }

    public Date getServiceEnd() {
        return serviceEnd;
    }

    public void setServiceEnd(Date serviceEnd) {
        this.serviceEnd = serviceEnd;
    }
}
