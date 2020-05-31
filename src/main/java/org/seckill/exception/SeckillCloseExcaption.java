package org.seckill.exception;

/**
 * @Author: vvshuai
 * @Description: 秒杀关闭异常
 * @Date: Created in 15:22 2020/5/28
 * @Modified By:
 */
public class SeckillCloseExcaption extends SeckillException{

    public SeckillCloseExcaption(String message) {
        super(message);
    }

    public SeckillCloseExcaption(String message, Throwable cause) {
        super(message, cause);
    }
}
