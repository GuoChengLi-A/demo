package com.shunteng.gof;

/**
 * @Description 责任链设计模式
 * @Author GCL
 * @Date 2020/7/3 上午11:24
 */
public class ChainOfResponsibilityTest {

    public static void main(String[] args) {
        LeaveRequest leaveRequest = new LeaveRequest("咚咚锵",20);
        AbstractLeaveHandler directLeaderLeaveHandler = new DirectLeaderLeaveHandler("小明");
        AbstractLeaveHandler deptManagerLeaveHandler = new DeptManagerLeaveHandler("小花");
        AbstractLeaveHandler gManagerLeaveHandler = new GManagerLeaveHandler("小钟");
        directLeaderLeaveHandler.setNextHandler(deptManagerLeaveHandler);
        deptManagerLeaveHandler.setNextHandler(gManagerLeaveHandler);
        directLeaderLeaveHandler.handlerRequest(leaveRequest);
    }
}

/**
 * @Description: 员工请假申请类
 */
class LeaveRequest {
    private String name;
    private Integer leaveDay;

    public LeaveRequest(String name, Integer leaveDay) {
        this.name = name;
        this.leaveDay = leaveDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLeaveDay() {
        return leaveDay;
    }

    public void setLeaveDay(Integer leaveDay) {
        this.leaveDay = leaveDay;
    }
}

/**
 * @Description: 请假处理抽象类
 */
abstract class AbstractLeaveHandler {

    protected int min = 1;

    protected int middle = 3;

    protected int max = 30;

    protected String handlerName;

    protected AbstractLeaveHandler nextHandler;

    /**
     * @Description: 设置下一节点处理
     */
    protected void setNextHandler(AbstractLeaveHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected void handlerRequest(LeaveRequest leaveRequest) {

    }

}

/**
 * @Description: 直接主管处理请假类
 */
class DirectLeaderLeaveHandler extends AbstractLeaveHandler {
    public DirectLeaderLeaveHandler(String name){
        this.handlerName=name;
    }

    @Override
    protected void handlerRequest(LeaveRequest leaveRequest) {
        super.handlerRequest(leaveRequest);
        if (leaveRequest.getLeaveDay() > 0 && leaveRequest.getLeaveDay() <= this.min) {
            System.out.println("直接主管:" + handlerName + ",已经处理;流程结束。");
            return;
        }
        if(null!=this.nextHandler){
            this.nextHandler.handlerRequest(leaveRequest);
        }else{
            System.out.println("审核被拒绝");
        }
    }
}

/**
 * @Description: 部门经理处理请假类
 */
class DeptManagerLeaveHandler extends AbstractLeaveHandler{
    public DeptManagerLeaveHandler(String name){
        this.handlerName=name;
    }

    @Override
    protected void handlerRequest(LeaveRequest leaveRequest) {
        super.handlerRequest(leaveRequest);
        if (leaveRequest.getLeaveDay() > this.min && leaveRequest.getLeaveDay() <= this.middle) {
            System.out.println("部门经理:" + handlerName + ",已经处理;流程结束。");
            return;
        }
        if(null!=this.nextHandler){
            this.nextHandler.handlerRequest(leaveRequest);
        }else{
            System.out.println("审核被拒绝");
        }
    }
}

/**
 * @Description: 总经理处理请假类
 */
class GManagerLeaveHandler extends AbstractLeaveHandler{
    public GManagerLeaveHandler(String name){
        this.handlerName=name;
    }

    @Override
    protected void handlerRequest(LeaveRequest leaveRequest) {
        super.handlerRequest(leaveRequest);
        if (leaveRequest.getLeaveDay() > this.middle && leaveRequest.getLeaveDay() <= this.max) {
            System.out.println("部门经理:" + handlerName + ",已经处理;流程结束。");
            return;
        }
        if(null!=this.nextHandler){
            this.nextHandler.handlerRequest(leaveRequest);
        }else{
            System.out.println("审核被拒绝");
        }
    }
}