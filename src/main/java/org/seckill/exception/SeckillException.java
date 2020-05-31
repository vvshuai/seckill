package org.seckill.exception;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 15:23 2020/5/28
 * @Modified By:
 */
public class SeckillException extends RuntimeException{

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
