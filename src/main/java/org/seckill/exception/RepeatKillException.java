package org.seckill.exception;

/**
 * @Author: vvshuai
 * @Description: 运行期异常
 * @Date: Created in 15:21 2020/5/28
 * @Modified By:
 */
public class RepeatKillException extends SeckillException{

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
