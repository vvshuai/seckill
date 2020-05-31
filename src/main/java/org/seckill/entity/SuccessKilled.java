package org.seckill.entity;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 17:55 2020/5/27
 * @Modified By:
 */
public class SuccessKilled {

    private long seckilled;

    private long userPhone;

    private short state;

    private Date createTime;

    private Seckill seckill;

    public long getSeckilled() {
        return seckilled;
    }

    public void setSeckilled(long seckilled) {
        this.seckilled = seckilled;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "seckilled=" + seckilled +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", createTime=" + createTime +
                '}';
    }
}
