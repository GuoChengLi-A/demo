package com.shunteng.gof;

/**
 * @Description 日志记录责任链
 * @Author GCL
 * @Date 2020/7/3 下午1:56
 */
public class LogChainOfResposityTest {
    public static void main(String[] args) {
        Logger log = new Logger(2, "NullPointException");
        AbstractLoggerHandler infoLogger = new InfoLogger(0);
        AbstractLoggerHandler debuggerLogger = new DebuggerLogger(1);
        AbstractLoggerHandler errorLogger = new ErrorLogger(2);
        AbstractLoggerHandler fatalLogger = new FatalLogger(3);
        infoLogger.setNextLogger(debuggerLogger);
        debuggerLogger.setNextLogger(errorLogger);
        errorLogger.setNextLogger(fatalLogger);
        infoLogger.write(log);
    }
}

/**
 * @Description: 日志类
 */
class Logger {
    private Integer level;
    private String msg;

    public Logger(Integer level, String msg) {
        this.level = level;
        this.msg = msg;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

/**
 * @Description: 抽象日志处理类
 */
abstract class AbstractLoggerHandler {
    protected final Integer INFO = 0;
    protected final Integer DEBUGGER = 1;
    protected final Integer ERROR = 2;
    protected final Integer FATAL = 3;
    protected Integer level;
    protected AbstractLoggerHandler nextLoggerHandler;

    public AbstractLoggerHandler(Integer level) {
        this.level = level;
    }

    /**
     * @Description: 发送至下一节点
     */
    protected void setNextLogger(AbstractLoggerHandler nextLoggerHandler) {
        this.nextLoggerHandler = nextLoggerHandler;
    }

    /**
     * @Description: 写入日志
     */
    protected void write(Logger logger) {

    }

    /**
     * @Description: 日志详情
     */
    protected void logMessage(String log) {

    }
}

/**
 * @Description: 提醒级别日志处理类
 */
class InfoLogger extends AbstractLoggerHandler {

    public InfoLogger(Integer level) {
        super(level);
    }

    @Override
    protected void write(Logger logger) {
        if (this.INFO.equals(logger.getLevel())) {
            System.out.println("[INFO]日志已写入text");
            logMessage(logger.getMsg());
            return;
        }
        if (null != this.nextLoggerHandler) {
            this.nextLoggerHandler.write(logger);
        } else {
            System.out.println("INFO日志记录完毕");
        }
    }

    @Override
    protected void logMessage(String log) {
        System.out.println("[INFO]日志信息为：" + log);
    }
}

/**
 * @Description: 错误级别日志处理类
 */
class ErrorLogger extends AbstractLoggerHandler {

    public ErrorLogger(Integer level) {
        super(level);
    }

    @Override
    protected void write(Logger logger) {
        if (this.ERROR.equals(logger.getLevel())) {
            System.out.println("[ERROR]日志已写入text");
            logMessage(logger.getMsg());
            return;
        }
        if (null != this.nextLoggerHandler) {
            this.nextLoggerHandler.write(logger);
        } else {
            System.out.println("ERROR日志记录完毕");
        }
    }

    @Override
    protected void logMessage(String log) {
        System.out.println("[ERROR]日志信息为：" + log);
    }
}

/**
 * @Description: 调试级别日志处理类
 */
class DebuggerLogger extends AbstractLoggerHandler {


    public DebuggerLogger(Integer level) {
        super(level);
    }

    @Override
    protected void write(Logger logger) {
        if (this.DEBUGGER.equals(logger.getLevel())) {
            System.out.println("[DEBUFFER]日志已写入text");
            logMessage(logger.getMsg());
            return;
        }
        if (null != this.nextLoggerHandler) {
            this.nextLoggerHandler.write(logger);
        } else {
            System.out.println("DEBUGGER日志记录完毕");
        }
    }

    @Override
    protected void logMessage(String log) {
        System.out.println("[DEBUFFER]日志信息为：" + log);
    }
}

/**
 * @Description: 严重级别日志处理类
 */
class FatalLogger extends AbstractLoggerHandler {

    public FatalLogger(Integer level) {
        super(level);
    }

    @Override
    protected void setNextLogger(AbstractLoggerHandler abstractLoggerHandler) {

    }

    @Override
    protected void write(Logger logger) {
        if (this.FATAL.equals(logger.getLevel())) {
            System.out.println("[FATAL]日志已写入text");
            logMessage(logger.getMsg());
            return;
        }
        if (null != this.nextLoggerHandler) {
            this.nextLoggerHandler.write(logger);
        } else {
            System.out.println("FATAL日志记录完毕");
        }
    }

    @Override
    protected void logMessage(String log) {
        System.out.println("[FATAL]日志信息为：" + log);
    }
}